package DynaBlast;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends Creatures {
    char type;

    public Enemy(char type, int x0, int y0){
        setBounds(x0, y0, Tile.tileSize, Tile.tileSize);
        this.type = type;
        x = x0;
        y = y0;
    }

    public void tick(){

    }

    public void render(Graphics g){
        if (type == Tile.army_man){
            g.drawImage(Tile.tileset_army_man, (int)x, (int)y, null);
        }
        else if (type == Tile.swat){
            g.drawImage(Tile.tileset_swat, (int)x, (int)y, null);
        }
        else{
            g.drawImage(Tile.tileset_guard, (int)x, (int)y, null);
        }
    }

}
