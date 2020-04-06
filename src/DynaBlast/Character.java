/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 *  Class representing player's character
 *  class extends class @Creatures
 *
 *  4 different skins for character
 *  each has size of standard @Tile
 *
 *  contains information about lives and score of the player
 */
public class Character extends Creatures {
    /** image of character */
    public static BufferedImage img;
    /** number of player's lives */
    private int lives;
    /** player's score */
    private int score;

    /**
     * creates object of character with skin chosen by player
     * character always start at left top corner of the map (@Level.margin + @Tile.tileSize)
     *
     * @param type
     *      information which skin of character player has chosen
     */
    public Character(char type){
        setBounds(x = Level.margin + Tile.tileSize, y = Level.margin + Tile.tileSize, Tile.tileSize, Tile.tileSize);
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

    /** @return number of player's lives */
    public int getLives(){
        return lives;
    }
    /** @return player's score */
    public int getScore(){
        return score;
    }

    public void tick(){

    }

    /** render character's image on map
     *
     * @param g Graphic to which render images
     */
    public void render(Graphics g){
        g.drawImage(img, (int)x, (int)y, null);
    }

}
