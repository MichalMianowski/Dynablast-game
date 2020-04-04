package DynaBlast;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Tile {
    public static int tileSize = 20;

    public static char empty = 'E';
    public static char bars = 'B';
    public static char ladder = 'L';
    public static char unbreakable = 'U';

    public static char female_orange = 'F';
    public static char female_stripes = 'f';
    public static char male_orange = 'M';
    public static char male_stripes = 'm';

    //chyba trzeba wrzucić kilka grafik
    //public static BufferedImage tileset_empty;
    public static BufferedImage tileset_bars;
    public static BufferedImage tileset_ladder;
    public static BufferedImage tileset_unbreakable;

    public static BufferedImage tileset_fem_orange;
    public static BufferedImage tileset_fem_stripes;
    public static BufferedImage tileset_m_orange;
    public static BufferedImage tileset_m_stripes;



    //tu wczytywać wszystkie kafelki
    public Tile(){
        try {
            //Tile.tileset_empty = ImageIO.read(new File("res/empty.png"));
            Tile.tileset_bars = ImageIO.read(new File("res/bars.png"));
            Tile.tileset_ladder = ImageIO.read(new File("res/ladder.png"));
            Tile.tileset_unbreakable = ImageIO.read(new File("res/unbreakable.png"));

            Tile.tileset_fem_orange = ImageIO.read(new File("res/female_orange.png"));
            Tile.tileset_fem_stripes = ImageIO.read(new File("res/female_stripes.png"));
            Tile.tileset_m_orange = ImageIO.read(new File("res/male_orange.png"));
            Tile.tileset_m_stripes = ImageIO.read(new File("res/male_stripes.png"));

        } catch (Exception e) { }
    }
}
