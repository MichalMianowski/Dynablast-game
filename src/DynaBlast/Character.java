package DynaBlast;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Character extends Creatures {
    public static BufferedImage charImg;
    public Character(char type){
        setBounds(x = 40, y = 40, Tile.tileSize, Tile.tileSize);
        if (type == Tile.female_orange){
            charImg = Tile.tileset_fem_orange;
        }
        else if (type == Tile.female_stripes){
            charImg = Tile.tileset_fem_stripes;
        }
        else if (type == Tile.male_orange){
            charImg = Tile.tileset_m_orange;
        }
        else{
            charImg = Tile.tileset_m_stripes;
        }
    }


    public void tick(){

    }

    public void render(Graphics g){
        g.drawImage(charImg, (int)x, (int)y, null);
    }

}
