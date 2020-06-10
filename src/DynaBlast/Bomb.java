/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.awt.*;
import java.awt.image.BufferedImage;
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
        final float FACTOR  = 2f;

        if(!Character.scaled1) {
            int ScaleX1 = (int) (Tile.tileset_bomb[0].getWidth() * FACTOR);
            int ScaleY1 = (int) (Tile.tileset_bomb[0].getHeight() * FACTOR);
            Image img1 = Tile.tileset_bomb[0].getScaledInstance(ScaleX1, ScaleY1, Image.SCALE_SMOOTH);
            Tile.tileset_bomb[0] = new BufferedImage(ScaleX1, ScaleY1, BufferedImage.TYPE_INT_ARGB);
            Tile.tileset_bomb[0].getGraphics().drawImage(img1, 0, 0, null);

            int ScaleX2 = (int) (Tile.tileset_bomb[1].getWidth() * FACTOR);
            int ScaleY2 = (int) (Tile.tileset_bomb[1].getHeight() * FACTOR);
            Image img2 = Tile.tileset_bomb[1].getScaledInstance(ScaleX2, ScaleY2, Image.SCALE_SMOOTH);
            Tile.tileset_bomb[1] = new BufferedImage(ScaleX2, ScaleY2, BufferedImage.TYPE_INT_ARGB);
            Tile.tileset_bomb[1].getGraphics().drawImage(img2, 0, 0, null);

            int ScaleX3 = (int) (Tile.tileset_bomb[2].getWidth() * FACTOR);
            int ScaleY3 = (int) (Tile.tileset_bomb[2].getHeight() * FACTOR);
            Image img3 = Tile.tileset_bomb[2].getScaledInstance(ScaleX3, ScaleY3, Image.SCALE_SMOOTH);
            Tile.tileset_bomb[2] = new BufferedImage(ScaleX3, ScaleY3, BufferedImage.TYPE_INT_ARGB);
            Tile.tileset_bomb[2].getGraphics().drawImage(img3, 0, 0, null);

            int ScaleX4 = (int) (Tile.tileset_bomb[3].getWidth() * FACTOR);
            int ScaleY4 = (int) (Tile.tileset_bomb[3].getHeight() * FACTOR);
            Image img4 = Tile.tileset_bomb[3].getScaledInstance(ScaleX4, ScaleY4, Image.SCALE_SMOOTH);
            Tile.tileset_bomb[3] = new BufferedImage(ScaleX4, ScaleY4, BufferedImage.TYPE_INT_ARGB);
            Tile.tileset_bomb[3].getGraphics().drawImage(img4, 0, 0, null);
        }
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
        if (!Character.scaled2){
            Character.scaled2 = true;
        }
    }
}

