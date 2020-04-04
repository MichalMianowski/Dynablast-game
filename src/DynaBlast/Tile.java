package DynaBlast;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Tile {
    public static int tileSize = 20;

    public static int[] wall = {-1, -1};
    public static int[] box = {0, 0};

    public static int[] character = {7,7};

    public static BufferedImage tileset;

    public Tile(){
        try {
            Tile.tileset = ImageIO.read(new File("res/box_wood.png"));
        } catch (Exception e) { }
    }
}
