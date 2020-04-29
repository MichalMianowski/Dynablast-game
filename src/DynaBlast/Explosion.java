package DynaBlast;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Explosion {
    int x, y;
    int[] cellLoc;
    public boolean done;
    int counter;
    int length = 1;
    int lengthL = 0;
    int lengthR = 0;
    int lengthU = 0;
    int lengthD = 0;
    ArrayList<int[]> explosionReach = new ArrayList<>();

    Graphic graph = new Graphic(50, Tile.tileset_bars_death[0], Tile.tileset_bars_death[1], Tile.tileset_bars_death[2], Tile.tileset_bars_death[3]);

    public Explosion(int[] cell){
        done = false;
        x = Level.margin + cell[0] * Tile.tileSize;
        y = Level.margin + cell[1] * Tile.tileSize;
        cellLoc = cell.clone();
        counter = 50;
        go();
    }


    public void tick() {
        countVisibility();
    }

    public void render(Graphics g) {
        g.drawImage(Tile.tileset_explosion_core, (int) x, (int) y, null);
        for(int i = 0; i <= lengthL; i++){
            g.drawImage(Tile.tileset_explosion_horizontal, (int) x - i * Tile.tileSize, (int) y, null);
        }
        for(int i = 0; i <= lengthR; i++){
            g.drawImage(Tile.tileset_explosion_horizontal, (int) x + i * Tile.tileSize, (int) y, null);
        }
        for(int i = 0; i <= lengthU; i++){
            g.drawImage(Tile.tileset_explosion_vertical, (int) x, (int) y - i * Tile.tileSize, null);
        }
        for(int i = 0; i <= lengthD; i++){
            g.drawImage(Tile.tileset_explosion_vertical, (int) x, (int) y + i * Tile.tileSize, null);
        }
    }

    public void go(){
        goLeft();
        goRight();
        goUp();
        goDown();
        getExplosionReach();
        destroy();
    }


    public void goLeft(){
        lengthL = length;
        for(int i = 1; i <= length; i++){
            if(!(Level.block[cellLoc[0]-i][cellLoc[1]].id == Tile.empty)){
                lengthL = i-1;
                if(Level.block[cellLoc[0]-i][cellLoc[1]].id == Tile.bars) {
                    Level.block[cellLoc[0] - i][cellLoc[1]].destroy();
                }
                break;
            }
        }
    }
    public void goRight(){
        lengthR = length;
        for(int i = 1; i <= length; i++){
            if(!(Level.block[cellLoc[0]+i][cellLoc[1]].id == Tile.empty)){
                lengthR = i-1;
                if(Level.block[cellLoc[0]+i][cellLoc[1]].id == Tile.bars) {
                    Level.block[cellLoc[0]+i][cellLoc[1]].destroy();
                }
                break;
            }
        }
    }
    public void goUp(){
        lengthU = length;
        for(int i = 1; i <= length; i++){
            if(!(Level.block[cellLoc[0]][cellLoc[1]-i].id == Tile.empty)){
                lengthU = i-1;
                if(Level.block[cellLoc[0]][cellLoc[1]-i].id == Tile.bars) {
                    Level.block[cellLoc[0]][cellLoc[1]-i].destroy();
                }
                break;
            }
        }
    }
    public void goDown(){
        lengthD = length;
        for(int i = 1; i <= length; i++){
            if(!(Level.block[cellLoc[0]][cellLoc[1]+i].id == Tile.empty)){
                lengthD = i-1;
                if(Level.block[cellLoc[0]][cellLoc[1]+i].id == Tile.bars) {
                    Level.block[cellLoc[0]][cellLoc[1]+i].destroy();
                }
                break;
            }
        }
    }

    private void getExplosionReach() {
        for(int i = 0; i <= lengthL; i++){
            explosionReach.add(new int[] {cellLoc[0]-i, cellLoc[1]});
        }
        for(int i = 0; i <= lengthR; i++){
            explosionReach.add(new int[] {cellLoc[0]+i, cellLoc[1]});
        }
        for(int i = 0; i <= lengthU; i++){
            explosionReach.add(new int[] {cellLoc[0], cellLoc[1]-i});
        }
        for(int i = 0; i <= lengthD; i++){
            explosionReach.add(new int[] {cellLoc[0], cellLoc[1]+1});
        }
    }

    public void countVisibility(){
        counter--;
        if(counter==0){
            done = true;
        }
    }

    private void destroy() {
        Level.bombs.forEach(bomb -> {
            explosionReach.forEach(reach -> {
                if((reach[0] == bomb.cellLoc[0])&&(reach[1] == bomb.cellLoc[1])){
                    if(bomb.stage > 0) {
                        bomb.stage = 0;
                    }
                }
            });
        });

        Level.enemies.forEach(enemy -> {
            explosionReach.forEach(reach -> {
                if((reach[0] == enemy.getCellAtMap()[0])&&(reach[1] == enemy.getCellAtMap()[1])){
                    enemy.die();
                }
            });
        });

        for(int[] reach:explosionReach){
            if((reach[0] == Game.character.getCellAtMap()[0])&&(reach[1] == Game.character.getCellAtMap()[1])){
                    Game.character.exploded();

                    break;
                }
            };
        for(int[] reach:explosionReach){
            if((Game.level.escapeVisible == 1)&&(reach[0] == Game.level.cellOfEscape[0])&&(reach[1] == Game.level.cellOfEscape[1])){
                Game.level.escapeVisible = 2;
                break;
            }
        }
    }
}

