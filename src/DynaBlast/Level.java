package DynaBlast;

import java.awt.*;

public class Level {
    public Block[][] block = new Block[15][15];

    public Level(){
//        zrób coś dla wsz. bloków
        for(int y=0; y<block.length; y++){
            for(int x=0; x<block.length; x++){
                block[x][y] = new Block(new Rectangle(20 + x * Tile.tileSize, 20+ y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.box);
                if(x == 0 || y == 0 || x == block.length-1 || y == block[0].length-1){
                    block[x][y].id = Tile.wall;
                }
            }
        }
        generateLevel();
    }

    public void generateLevel(){
        for(int y=0; y<block.length; y+=2){
            for(int x=0; x<block.length; x+=2){
                block[x][y].id = Tile.wall;
            }
        }

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
