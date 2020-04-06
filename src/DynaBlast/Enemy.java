/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Class of enemy mobs
 * class extends class @Creatures
 *
 * 3 different types of enemies
 * each has size of standard @Tile
 */
public class Enemy extends Creatures {
    /** contain information about type of the enemy */
    char type;

    /**
     *  creates object of the enemy with @Tile size
     *
     * @param type
     *      type of enemy {guard, army man, swat}
     * @param x0
     *      coordinate x of starting enemy
     * @param y0
     *      coordinate y of starting enemy
     */
    public Enemy(char type, int x0, int y0){
        setBounds(x0, y0, Tile.tileSize, Tile.tileSize);
        this.type = type;
        x = x0;
        y = y0;
    }

    public void tick(){

    }

    /** render image of enemy depending on his type
     * @param g Graphic to which render images
     */
    public void render(Graphics g){
        if (type == Tile.army_man){
            g.drawImage(Tile.tileset_army_man, (int)x, (int)y, null);
        }
        else if (type == Tile.swat){
            g.drawImage(Tile.tileset_swat, (int)x, (int)y, null);
        }
        else if (type == Tile.guard){
            g.drawImage(Tile.tileset_guard, (int)x, (int)y, null);
        }
    }

}
