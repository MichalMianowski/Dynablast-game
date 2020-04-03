package DynaBlast;

import java.awt.*;

public class Block extends Rectangle {
    private static final long serialVersionUID = 1L;

    public int[] id = {-1,-1};

    public Block(Rectangle size, int[] id){
        setBounds(size);
        this.id = id;
    }

    public void render(Graphics g){
        if(id != Tile.box) {
            g.fillRect(x, y, width, height);
        }
    }
}
