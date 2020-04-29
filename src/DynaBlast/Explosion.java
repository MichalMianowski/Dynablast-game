<<<<<<< HEAD
/**
 * Michal Mianowski & Piotr Strzaska
 */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
package DynaBlast;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

<<<<<<< HEAD
/**
 * class to service explosions caused by bombs
 * check the length of each explosion arm
 * cause proper destruction if can
 */
public class Explosion {
    /** coordinates of explosion center */
    int x, y;
    /** cell index of explosion center */
    int[] cellLoc;
    /** is the explosion ended - if yes remove explosion from list of present explosions */
    public boolean done;
    /** caunt how long explosion should be visible */
    int counter;
    /** general potential length of explosion
     * may be edited by powers in the future loaded from character, which loaded from config
     */
    int length = 1;
    /** real length of left arm */
    int lengthL = 0;
    /** real length of right arm */
    int lengthR = 0;
    /** real length of up arm */
    int lengthU = 0;
    /** real length of down arm */
    int lengthD = 0;
    /** list of cells where explosion raged */
    ArrayList<int[]> explosionReach = new ArrayList<>();

    /**
     * make a explosion
     * get information about range
     * set counter
     * start destruction
     *
     * @param cell cell of the center of explosion
     */
=======
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

>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
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

<<<<<<< HEAD
    /** render explosion's image on map
     *
     * @param g Graphic to which render images and draw animations
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
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

<<<<<<< HEAD
    /** spreading of explosion to each direction
     * saving data to explosionReach list
     * making destruction
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    public void go(){
        goLeft();
        goRight();
        goUp();
        goDown();
        getExplosionReach();
        destroy();
    }

<<<<<<< HEAD
    /** going to left
     * discover range and making bars destruction
     */
=======

>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
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
<<<<<<< HEAD
    /** going to right
     * discover range and making bars destruction
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
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
<<<<<<< HEAD
    /** going to up
     * discover range and making bars destruction
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
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
<<<<<<< HEAD
    /** going to down
     * discover range and making bars destruction
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
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

<<<<<<< HEAD
    /**
     * getting range of explosion
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
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

<<<<<<< HEAD
    /**
     * counting how long explosion should be visible
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    public void countVisibility(){
        counter--;
        if(counter==0){
            done = true;
        }
    }

<<<<<<< HEAD
    /**
     * making a destruction at
     * another bomb
     * enemies
     * character
     * place of escape
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
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
<<<<<<< HEAD
                    enemy.VerticalSpeed = 0;
                    enemy.HorizontalSpeed = 0;
                    if (enemy.type == Tile.guard) {
                        enemy.graph1 = new Graphic(10, Tile.tileset_guard_death[0], Tile.tileset_guard_death[1], Tile.tileset_guard_death[2], Tile.tileset_guard_death[3]);
                    }
                    else if (enemy.type == Tile.swat) {
                        enemy.graph2 = new Graphic(10, Tile.tileset_swat_death[0], Tile.tileset_swat_death[1], Tile.tileset_swat_death[2], Tile.tileset_swat_death[3]);
                    }
                    else if (enemy.type == Tile.army_man){
                        enemy.graph3 = new Graphic(10, Tile.tileset_army_man_death[0], Tile.tileset_army_man_death[1], Tile.tileset_army_man_death[2], Tile.tileset_army_man_death[3]);
                    }
                    enemy.dying = true;
=======
                    enemy.die();
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
                }
            });
        });

        for(int[] reach:explosionReach){
            if((reach[0] == Game.character.getCellAtMap()[0])&&(reach[1] == Game.character.getCellAtMap()[1])){
                    Game.character.exploded();
<<<<<<< HEAD
=======

>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
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

