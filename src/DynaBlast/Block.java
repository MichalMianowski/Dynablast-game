/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import  java.awt.*;

/**
 * Class of block building infrastructure of level, such as unbreakable walls
 * types stored in @id field
 * class extends Rectangle class
 * default type of block is empty block
 *
 * Block almost always have @Tile size
 */
public class Block extends Rectangle {
    private static final long serialVersionUID = 1L;
    /**
     * contains information about type of the block
     */
    public char id;

    /** are bars exploding */
    public boolean destroying = false;


    /**
     * creates elementary object of map, such as unbreakable walls
     *
     * @param size size of block, mostly @Tile size
     * @param id   type of the block
     */
    public Block(Rectangle size, char id) {
        setBounds(size);
        this.id = id;
    }

    /**
     * function that starts exploding of bars
     *
     * @param tableX - index x in table of blocks
     * @param tableY - index y in table of blocks
     */
    public void explode(int tableX, int tableY) {
        destroying = true;
        Game.level.explodingBars.add(new ExplodingBars(x, y, tableX, tableY));
    }
    /** function that "destroys" the block, therefore changes its type to empty */
    public void destroy() {
        id = Tile.empty;
    }

    /**
     * render blocks of level's infrastructure
     *
     * @param g Graphic to which render images
     */
    public void render(Graphics g) {
        if (id == Tile.empty) {
        }
        else if (id == Tile.unbreakable) {
            g.drawImage(Tile.tileset_unbreakable, x, y, width, height, null);
        }
        else if (id == Tile.bars) {
            if (!destroying){
                g.drawImage(Tile.tileset_bars, x, y, width, height, null);
            }
        }
    }
    /**
     * render escape cell image
     * ready to break depends on escapeType
     *
     * @param g Graphic to which render images
     * @param escapeType ('l') escape_1 - ready to break, ('L') escape_2 - ready to escape
     */
    public void render(Graphics g, char escapeType) {
        if (escapeType == Tile.escape_1) {
            g.drawImage(Tile.tileset_escape_1, x, y, width, height, null);
        } else if (escapeType == Tile.escape_2) {
            g.drawImage(Tile.tileset_escape_2, x, y, width, height, null);
        }
    }
}