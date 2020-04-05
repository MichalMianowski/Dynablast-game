package DynaBlast;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Character extends Creatures {
    public static BufferedImage img;
    private int lives;
    private int score;

    public Character(char type){
        setBounds(x = 40, y = 40, Tile.tileSize, Tile.tileSize);
        lives = 3;
        if (type == Tile.female_orange){
            img = Tile.tileset_fem_orange;
        }
        else if (type == Tile.female_stripes){
            img = Tile.tileset_fem_stripes;
        }
        else if (type == Tile.male_orange){
            img = Tile.tileset_m_orange;
        }
        else{
            img = Tile.tileset_m_stripes;
        }
    }

    public int getLives(){
        return lives;
    }
    public int getScore(){
        return score;
    }

    public void tick(){

    }

    public void render(Graphics g){
        g.drawImage(img, (int)x, (int)y, null);
    }

}
