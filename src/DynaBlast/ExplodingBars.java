/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.awt.*;

/**
 * class to manage exploding bars
 */
public class ExplodingBars {
    /** index of block in level's table of blocks */
    int x, y;
    /** coordinates of explosioning bars */
    double xd, yd;
    /** if bars are destroyed */
    boolean destroyed = false;
    /** sequence of graphics for animation */
    Animation animation = new Animation(10, Tile.tileset_bars_death);

    /**
     * constructor set xd, yd, x, y
     * @param x - set x coordinate
     * @param y - set y coordinate
     * @param tableX - set x index
     * @param tableY - set y index
     */
    public ExplodingBars(double x, double y, int tableX, int tableY) {
        xd = x;
        yd = y;
        this.x = tableX;
        this.y = tableY;
    }

    public void tick(){
        animation.tickDestroyAnimation(this);
    }

    /**
     * make bars destroyed
     */
    public void destroy() {
        Game.level.block[x][y].destroy();
        destroyed = true;
    }

    /**
     * render animation to Graphics g
     * @param g - destination to render animation
     */
    public void render(Graphics g) {
        animation.drawAnimation(g, xd, yd);
    }
}
