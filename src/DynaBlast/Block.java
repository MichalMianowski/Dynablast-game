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
    /** contains information about type of the block */
    public char id = Tile.empty;

    /**
     * creates elementary object of map, such as unbreakable walls
     *
     * @param size size of block, mostly @Tile size
     * @param id type of the block
     */
    public Block(Rectangle size, char id){
        setBounds(size);
        this.id = id;
    }

    /**
     * render blocks of level's infrastructure
     *
     * @param g Graphic to which render images
     */
    public void render(Graphics g){
        if(id == Tile.empty) { }
        else if(id == Tile.unbreakable) {
            g.drawImage(Tile.tileset_unbreakable, x, y, width, height, null);
        }
        else if(id == Tile.bars){
            g.drawImage(Tile.tileset_bars, x, y, width, height, null);
        }
        else if(id == Tile.ladder){
            g.drawImage(Tile.tileset_ladder, x, y, width, height, null);
        }
    }

}