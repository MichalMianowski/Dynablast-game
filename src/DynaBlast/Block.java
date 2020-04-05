package DynaBlast;

import  java.awt.*;


public class Block extends Rectangle {
    private static final long serialVersionUID = 1L;

    public char id = 'E';


    public Block(Rectangle size, char id){
        setBounds(size);
        this.id = id;
    }

    public void render(Graphics g){
        if(id == Tile.empty) {
            //g.drawImage(Tile.tileset_empty, x, y, width, height, null);
        }
        else if(id == Tile.unbreakable) {
            g.drawImage(Tile.tileset_unbreakable, x, y, width, height, null);
        }
        else if(id == Tile.bars){
            g.drawImage(Tile.tileset_bars, x, y, width, height, null);
        }
        else if(id == Tile.ladder){
            g.drawImage(Tile.tileset_ladder, x, y, width, height, null);
        }

    }
}


//import java.awt.*;
//
//public class Block extends Rectangle {
//    private static final long serialVersionUID = 1L;
//
//    public int[] id = {-1,-1};
//
//    public Block(Rectangle size, int[] id){
//        setBounds(size);
//        this.id = id;
//    }
//
//    public void render(Graphics g){
//        if(id != Tile.box) {
//            g.drawImage(Tile.tileset, x, y, width, height, null);
//        }
//    }
//}
