/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 * Class of bombs created by main character
 * contains coordinates x & y
 * stage of counting before explosion
 * counter counting time between stages
 * cellLoc table of index in the map table
 *
 * Block almost always have @Tile size
 */

public class Bomb {
    int x;
    int y;
    int stage = 4;
    int counter;
    int[] cellLoc;

    /**
     * creates bomb in given cell
     * @param cell cell at map where to place bomb
     */

    public Bomb(int[] cell) {
        this.x = Level.margin + cell[0] * Tile.tileSize;
        this.y = Level.margin + cell[1] * Tile.tileSize;
        this.cellLoc = cell.clone();
    }

    /**
     * render bomb image
     * @param g Graphic to which render images
     */

    public void render(Graphics g) {
        if (this.stage == 4) {
            g.drawImage(Tile.tileset_bomb[3], this.x, this.y, (ImageObserver)null);
        } else if (this.stage == 3) {
            g.drawImage(Tile.tileset_bomb[2], this.x, this.y, (ImageObserver)null);
        } else if (this.stage == 2) {
            g.drawImage(Tile.tileset_bomb[1], this.x, this.y, (ImageObserver)null);
        } else if (this.stage == 1) {
            g.drawImage(Tile.tileset_bomb[0], this.x, this.y, (ImageObserver)null);
        }
    }



    public void tick() {
        this.countDown();
    }

    /**
     * counting down to explosion
     */
    private void countDown() {
        ++this.counter;
        if (this.stage != 0) {
            if (this.counter == 100) {
                --this.stage;
                this.counter = 0;
            }
        } else if (this.stage == 0) {
            this.explode();
            --this.stage;
        }

    }

    /**
     * initiate explosion
     */
    private void explode() {
        Level.explosions.add(new Explosion(cellLoc));
    }
}

