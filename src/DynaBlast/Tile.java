package DynaBlast;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Tile {
    public static int tileSize = 20;

    public static char empty = 'E';
    public static char unbreakable = 'U';
    public static char bars = 'B';
    public static char ladder = 'L';

    public static char female_orange = 'F';
    public static char female_stripes = 'f';
    public static char male_orange = 'M';
    public static char male_stripes = 'm';

    public static char guard = 'G';
    public static char army_man = 'A';
    public static char swat = 'S';

    public static char power = 'P';

    public static BufferedImage tileset_bars;
    public static BufferedImage tileset_ladder;
    public static BufferedImage tileset_unbreakable;

    public static BufferedImage tileset_fem_orange;
    public static BufferedImage tileset_fem_stripes;
    public static BufferedImage tileset_m_orange;
    public static BufferedImage tileset_m_stripes;

    public static BufferedImage tileset_guard;
    public static BufferedImage tileset_army_man;
    public static BufferedImage tileset_swat;


    //load all Tiles
    public Tile(){
        //blocks
        try {
            Tile.tileset_bars = ImageIO.read(new File("res/bars.png"));
        } catch (Exception e) { }
        try {
            Tile.tileset_ladder = ImageIO.read(new File("res/ladder.png"));
        } catch (Exception e) { }
        try {
            Tile.tileset_unbreakable = ImageIO.read(new File("res/unbreakable.png"));
        } catch (Exception e) { }

        //characters
        try {
            Tile.tileset_fem_orange = ImageIO.read(new File("res/female_orange.png"));
        } catch (Exception e) { }
        try {
            Tile.tileset_fem_stripes = ImageIO.read(new File("res/female_stripes.png"));
        } catch (Exception e) { }
        try {
            Tile.tileset_m_orange = ImageIO.read(new File("res/male_orange.png"));
        } catch (Exception e) { }
        try{
            Tile.tileset_m_stripes = ImageIO.read(new File("res/male_stripes.png"));
        } catch (Exception e) { }

        //enemies
        try{
            Tile.tileset_guard = ImageIO.read(new File("res/guard.png"));
        } catch (Exception e) { }
        try{
            Tile.tileset_army_man = ImageIO.read(new File("res/army_man.png"));
        } catch (Exception e) { }
        try{
            Tile.tileset_swat = ImageIO.read(new File("res/swat.png"));
        } catch (Exception e) { }

    }
}
