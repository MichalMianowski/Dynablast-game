package DynaBlast;

import java.awt.*;
import java.util.ArrayList;

public class Level {
    int margin = 20;
    public Block[][] block = new Block[15][15];
    ArrayList<Enemy> enemies = new ArrayList();

//lvl testowy
    char[][] lvl_example = new char[15][15];


    public Level(){
        generateLevel();
    //lvl testowy
        generateLvlExample();
        loadLevel(lvl_example);

    }

    public void generateLevel(){
        for(int y=0; y<block.length; y++){
            for(int x=0; x<block.length; x++){
                block[x][y] = new Block(new Rectangle(margin + x * Tile.tileSize, margin + y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.empty);
            }
        }
    }

    public void loadLevel(char[][] lvl){
        for(int y=0; y<block.length; y++){
            for(int x=0; x<block.length; x++){
                if(lvl[x][y] == Tile.empty) {}
                else if(lvl[x][y] == Tile.unbreakable){
                    block[x][y].id = Tile.unbreakable;
                }
                else if(lvl[x][y] == Tile.bars){
                    block[x][y].id = Tile.bars;
                }
                else if(lvl[x][y] == Tile.ladder){
                    block[x][y].id = Tile.ladder;
                }

                else if(lvl[x][y] == Tile.guard){
                    enemies.add(new Enemy(Tile.guard,margin + x * Tile.tileSize, margin + y*Tile.tileSize));
                }
                else if(lvl[x][y] == Tile.army_man){
                    enemies.add(new Enemy(Tile.army_man,margin + x * Tile.tileSize, margin + y*Tile.tileSize));
                }
                else if(lvl[x][y] == Tile.swat){
                    enemies.add(new Enemy(Tile.swat,margin + x * Tile.tileSize, margin + y*Tile.tileSize));
                }
            }
        }
    }
//lvl testowy
    public void generateLvlExample(){
        for(int y=0; y<15; y++){
            for(int x=0; x<15; x++){
                if(x == 0 || y == 0 || x == block.length-1 || y == block[0].length-1){
                    lvl_example[x][y] = 'U';
                }
                else{
                    lvl_example[x][y] = 'E';
                }
            }
        }
        for(int y=0; y<15; y+=2){
            for(int x=0; x<15; x+=2){
                lvl_example[x][y] = Tile.unbreakable;
            }
        }
        for(int y=1; y<15; y+=2){
            lvl_example[0][y] = Tile.unbreakable;
            lvl_example[15-1][y] = Tile.unbreakable;
        }
        for(int x=1; x<15; x+=2){
            lvl_example[x][0] = Tile.unbreakable;
            lvl_example[x][15-1] = Tile.unbreakable;
        }
        lvl_example[5][5] = Tile.guard;
        for(int x=3; x < 14; x+=3)
            lvl_example[x][9] = Tile.bars;
        lvl_example[3][5] = Tile.army_man;
        lvl_example[3][4] = Tile.swat;
    }

//lvl testowy
    public void generateExample(){
        for(int y=0; y<block.length; y++){
            for(int x=0; x<block.length; x++){
                block[x][y] = new Block(new Rectangle(20 + x * Tile.tileSize, 20+ y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.empty);
                if(x == 0 || y == 0 || x == block.length-1 || y == block[0].length-1){
                    block[x][y].id = Tile.unbreakable;
                }
            }
        }
        for(int y=0; y<block.length; y+=2){
            for(int x=0; x<block.length; x+=2){
                block[x][y].id = Tile.unbreakable;
            }
        }
        for(int y=1; y<block.length; y+=2){
            block[0][y].id = Tile.unbreakable;
            block[block.length-1][y].id = Tile.unbreakable;
        }
        for(int x=1; x<block.length; x+=2){
            block[x][0].id = Tile.unbreakable;
            block[x][block.length-1].id = Tile.unbreakable;
        }
        block[2][7].id = Tile.bars;
        block[2][3].id = Tile.bars;
        block[9][7].id = Tile.bars;
        block[13][13].id = Tile.bars;
    }
    public void tick(){

    }
    public void render(Graphics g){
        for(int y=0; y<block.length; y++){
            for(int x=0; x<block.length; x++){
                block[x][y].render(g);
            }
        }
    }

}
