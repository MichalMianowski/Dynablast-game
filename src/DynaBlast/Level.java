package DynaBlast;

import java.awt.*;

public class Level {
    public Block[][] block = new Block[15][15];

    public Level(){
//        zrób coś dla wsz. bloków
        for(int y=0; y<block.length; y++){
            for(int x=0; x<block.length; x++){
                block[x][y] = new Block(new Rectangle(20 + x * Tile.tileSize, 20+ y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.empty);
                if(x == 0 || y == 0 || x == block.length-1 || y == block[0].length-1){
                    block[x][y].id = Tile.unbreakable;
                }
            }
        }
        generateLevel();
    }

    public void generateLevel(){
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
