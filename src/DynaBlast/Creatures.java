/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.awt.*;

/**
 * parent class for all 'alive' objects such as character and enemies
 * stores information about dimensions of creature and his localisation (in double)
 */
public abstract class Creatures {
    double margin = 1;
    /** localisation and dimensions of the creature */
    public double x, y, width, height;
    /** is this creature dying if yes play animation of death and turn dead to value true */
    boolean dying = false;
    /** is this creature dead if yes he will be removed from enemies list */
    boolean dead = false;

    /**
     * default creator of creature object, all parameters set to 0
     * use @setBounds method
     */
    public Creatures(){
        setBounds(0, 0, 0, 0);
    }

    /**
     * accurate creator of creature object
     *
     * @param x X dimension localisation
     * @param y Y dimension localisation
     * @param width width of the creature
     * @param height height of the creature
     */
    public Creatures(double x, double y, double width, double height){
        setBounds(x, y, width, height);
    }

    /**
     * setting bounds of creature, set localisation and dimensions of the creature
     *
     * @param x X dimension localisation
     * @param y Y dimension localisation
     * @param width width of the creature
     * @param height height of the creature
     */
    public void setBounds(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * getting rectangle to collision check
     * rectangle is a little bit smaller than game cell
     *
     * @return rectangle of smaller bounds of creature
     */

    public Rectangle getBounds() {
        return new Rectangle((int)(x + margin), (int)(y + margin), (int)(width - 2*margin), (int)(height-2*margin));
    }

    /**
     * getting cells index where is middle point of the creature
     *
     * @return - index of level table's position
     */
    public int[] getCellAtMap(){
        int x = (int) (((this.x - Level.margin) + width/2)/Tile.tileSize);
        int y = (int) (((this.y - Level.margin) + width/2)/Tile.tileSize);

        return new int[] {x, y};
    }

    /**
     * getting 2 points of creature to collision detection in horizontal move
     *
     * @return int table with coordinates x, y1, y2 (because x is the same for both points)
     */

    public int[] getCellsHorizontalMove(){
        int x = (int) (((this.x - Level.margin) + width/2)/Tile.tileSize);
        int y1 = (int) (((this.y - Level.margin) + width/2 - width/3)/Tile.tileSize);
        int y2 = (int) (((this.y - Level.margin) + width/2 + width/3)/Tile.tileSize);

        return new int[] {x, y1, y2};
    }

    /**
     * getting 2 points of creature to collision detection in vertical move
     *
     * @return int table with coordinates x1, x2, y (because y is the same for both points)
     */

    public int[] getCellsVerticalMove(){
        int x1 = (int) (((this.x - Level.margin) + width/2 - width/5)/Tile.tileSize);
        int x2 = (int) (((this.x - Level.margin) + width/2 + width/5)/Tile.tileSize);
        int y = (int) (((this.y - Level.margin) + width/2)/Tile.tileSize);

        return new int[] {x1, x2, y};
    }

    /**
     * abstract class to load skin of creature
     *
     * @param FACTOR - factor
     */
    public abstract void loadSkin(float FACTOR);

}
