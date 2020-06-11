/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

/**
 * Class storing coded names of blocks, character's skins and other items
 * also stores size of standard tile in game
 * also stores buffered images of each item in game loaded from .png files in "/res/Images/..." folder
 *
 */
public class Tile {
    public static int tileSize = 40;

    public static char empty = 'E';
    public static char unbreakable = 'U';
    public static char bars = 'B';
    public static char escape_1 = 'l';
    public static char escape_2 = 'L';

    public static char female_orange = 'F';
    public static char female_stripes = 'f';
    public static char male_orange = 'M';
    public static char male_stripes = 'm';

    public static char guard = 'G';
    public static char army_man = 'A';
    public static char swat = 'S';

    public static BufferedImage tileset_bars;
    public static BufferedImage[] tileset_bars_death = new BufferedImage[4];
    public static BufferedImage tileset_escape_1;
    public static BufferedImage tileset_escape_2;
    public static BufferedImage tileset_unbreakable;

    public static BufferedImage[] tileset_fem_orange_front = new BufferedImage[4];
    public static BufferedImage[] tileset_fem_orange_back = new BufferedImage[4];
    public static BufferedImage[] tileset_fem_orange_left = new BufferedImage[4];
    public static BufferedImage[] tileset_fem_orange_right = new BufferedImage[4];
    public static BufferedImage[] tileset_fem_orange_death = new BufferedImage[4];
    public static BufferedImage[] tileset_fem_orange_found = new BufferedImage[4];

    public static BufferedImage[] tileset_fem_stripes_front = new BufferedImage[4];
    public static BufferedImage[] tileset_fem_stripes_back = new BufferedImage[4];
    public static BufferedImage[] tileset_fem_stripes_left = new BufferedImage[4];
    public static BufferedImage[] tileset_fem_stripes_right = new BufferedImage[4];
    public static BufferedImage[] tileset_fem_stripes_death = new BufferedImage[4];
    public static BufferedImage[] tileset_fem_stripes_found = new BufferedImage[4];

    public static BufferedImage[] tileset_m_stripes_front = new BufferedImage[4];
    public static BufferedImage[] tileset_m_stripes_back = new BufferedImage[4];
    public static BufferedImage[] tileset_m_stripes_left = new BufferedImage[4];
    public static BufferedImage[] tileset_m_stripes_right = new BufferedImage[4];
    public static BufferedImage[] tileset_m_stripes_death = new BufferedImage[4];
    public static BufferedImage[] tileset_m_stripes_found = new BufferedImage[4];

    public static BufferedImage[] tileset_m_orange_front = new BufferedImage[4];
    public static BufferedImage[] tileset_m_orange_back = new BufferedImage[4];
    public static BufferedImage[] tileset_m_orange_left = new BufferedImage[4];
    public static BufferedImage[] tileset_m_orange_right = new BufferedImage[4];
    public static BufferedImage[] tileset_m_orange_death = new BufferedImage[4];
    public static BufferedImage[] tileset_m_orange_found = new BufferedImage[4];


    public static BufferedImage[] tileset_guard = new BufferedImage[4];
    public static BufferedImage[] tileset_guard_death = new BufferedImage[4];
    public static BufferedImage[] tileset_army_man = new BufferedImage[4];
    public static BufferedImage[] tileset_army_man_death = new BufferedImage[4];
    public static BufferedImage[] tileset_swat = new BufferedImage[4];
    public static BufferedImage[] tileset_swat_death = new BufferedImage[4];

    public static BufferedImage[] tileset_bomb = new BufferedImage[4];
    public static BufferedImage tileset_explosion_core;
    public static BufferedImage tileset_explosion_horizontal;
    public static BufferedImage tileset_explosion_vertical;


    /**
     * create object storing all buffered game's images
     */
    public Tile(){
        try {
            Tile.tileset_unbreakable = ImageIO.read(new File("res/Images/unbreakable.png"));
        } catch (Exception e) { }
        try {
            Tile.tileset_bars = ImageIO.read(new File("res/Images/bars.png"));
        } catch (Exception e) { }
        try {
            Tile.tileset_bars_death[0] = ImageIO.read(new File("res/Images/bars_death1.png"));
            Tile.tileset_bars_death[1] = ImageIO.read(new File("res/Images/bars_death2.png"));
            Tile.tileset_bars_death[2] = ImageIO.read(new File("res/Images/bars_death3.png"));
            Tile.tileset_bars_death[3] = ImageIO.read(new File("res/Images/bars_death4.png"));
        } catch (Exception e) { }
        try {
            Tile.tileset_escape_1 = ImageIO.read(new File("res/Images/escape_1.png"));
        } catch (Exception e) { }
        try {
            Tile.tileset_escape_2 = ImageIO.read(new File("res/Images/escape_2.png"));
        } catch (Exception e) {}

        //characters
        try {
            Tile.tileset_fem_orange_front[0] = ImageIO.read(new File("res/Images/female_orange_front2.png"));
            Tile.tileset_fem_orange_front[1] = ImageIO.read(new File("res/Images/female_orange_front1.png"));
            Tile.tileset_fem_orange_front[2] = ImageIO.read(new File("res/Images/female_orange_front2.png"));
            Tile.tileset_fem_orange_front[3] = ImageIO.read(new File("res/Images/female_orange_front3.png"));

            Tile.tileset_fem_orange_back[0] = ImageIO.read(new File("res/Images/female_orange_back2.png"));
            Tile.tileset_fem_orange_back[1] = ImageIO.read(new File("res/Images/female_orange_back1.png"));
            Tile.tileset_fem_orange_back[2] = ImageIO.read(new File("res/Images/female_orange_back2.png"));
            Tile.tileset_fem_orange_back[3] = ImageIO.read(new File("res/Images/female_orange_back3.png"));

            Tile.tileset_fem_orange_left[0] = ImageIO.read(new File("res/Images/female_orange_left2.png"));
            Tile.tileset_fem_orange_left[1] = ImageIO.read(new File("res/Images/female_orange_left1.png"));
            Tile.tileset_fem_orange_left[2] = ImageIO.read(new File("res/Images/female_orange_left2.png"));
            Tile.tileset_fem_orange_left[3] = ImageIO.read(new File("res/Images/female_orange_left3.png"));

            Tile.tileset_fem_orange_right[0] = ImageIO.read(new File("res/Images/female_orange_right2.png"));
            Tile.tileset_fem_orange_right[1] = ImageIO.read(new File("res/Images/female_orange_right1.png"));
            Tile.tileset_fem_orange_right[2] = ImageIO.read(new File("res/Images/female_orange_right2.png"));
            Tile.tileset_fem_orange_right[3] = ImageIO.read(new File("res/Images/female_orange_right3.png"));

            Tile.tileset_fem_orange_death[0] = ImageIO.read(new File("res/Images/female_orange_death1.png"));
            Tile.tileset_fem_orange_death[1] = ImageIO.read(new File("res/Images/female_orange_death2.png"));
            Tile.tileset_fem_orange_death[2] = ImageIO.read(new File("res/Images/female_orange_death3oops.png"));
            Tile.tileset_fem_orange_death[3] = ImageIO.read(new File("res/Images/female_orange_death3oops.png"));

            Tile.tileset_fem_orange_found[0] = ImageIO.read(new File("res/Images/female_orange_death1.png"));
            Tile.tileset_fem_orange_found[1] = ImageIO.read(new File("res/Images/female_orange_death2.png"));
            Tile.tileset_fem_orange_found[2] = ImageIO.read(new File("res/Images/female_orange_death3found.png"));
            Tile.tileset_fem_orange_found[3] = ImageIO.read(new File("res/Images/female_orange_death3found.png"));
        } catch (Exception e) { }
        try {
            Tile.tileset_fem_stripes_front[0] = ImageIO.read(new File("res/Images/female_stripes_front2.png"));
            Tile.tileset_fem_stripes_front[1] = ImageIO.read(new File("res/Images/female_stripes_front1.png"));
            Tile.tileset_fem_stripes_front[2] = ImageIO.read(new File("res/Images/female_stripes_front2.png"));
            Tile.tileset_fem_stripes_front[3] = ImageIO.read(new File("res/Images/female_stripes_front3.png"));

            Tile.tileset_fem_stripes_back[0] = ImageIO.read(new File("res/Images/female_stripes_back2.png"));
            Tile.tileset_fem_stripes_back[1] = ImageIO.read(new File("res/Images/female_stripes_back1.png"));
            Tile.tileset_fem_stripes_back[2] = ImageIO.read(new File("res/Images/female_stripes_back2.png"));
            Tile.tileset_fem_stripes_back[3] = ImageIO.read(new File("res/Images/female_stripes_back3.png"));

            Tile.tileset_fem_stripes_left[0] = ImageIO.read(new File("res/Images/female_stripes_left2.png"));
            Tile.tileset_fem_stripes_left[1] = ImageIO.read(new File("res/Images/female_stripes_left1.png"));
            Tile.tileset_fem_stripes_left[2] = ImageIO.read(new File("res/Images/female_stripes_left2.png"));
            Tile.tileset_fem_stripes_left[3] = ImageIO.read(new File("res/Images/female_stripes_left3.png"));

            Tile.tileset_fem_stripes_right[0] = ImageIO.read(new File("res/Images/female_stripes_right2.png"));
            Tile.tileset_fem_stripes_right[1] = ImageIO.read(new File("res/Images/female_stripes_right1.png"));
            Tile.tileset_fem_stripes_right[2] = ImageIO.read(new File("res/Images/female_stripes_right2.png"));
            Tile.tileset_fem_stripes_right[3] = ImageIO.read(new File("res/Images/female_stripes_right3.png"));

            Tile.tileset_fem_stripes_death[0] = ImageIO.read(new File("res/Images/female_stripes_death1.png"));
            Tile.tileset_fem_stripes_death[1] = ImageIO.read(new File("res/Images/female_stripes_death2.png"));
            Tile.tileset_fem_stripes_death[2] = ImageIO.read(new File("res/Images/female_stripes_death3oops.png"));
            Tile.tileset_fem_stripes_death[3] = ImageIO.read(new File("res/Images/female_stripes_death3oops.png"));

            Tile.tileset_fem_stripes_found[0] = ImageIO.read(new File("res/Images/female_stripes_death1.png"));
            Tile.tileset_fem_stripes_found[1] = ImageIO.read(new File("res/Images/female_stripes_death2.png"));
            Tile.tileset_fem_stripes_found[2] = ImageIO.read(new File("res/Images/female_stripes_death3found.png"));
            Tile.tileset_fem_stripes_found[3] = ImageIO.read(new File("res/Images/female_stripes_death3found.png"));
        } catch (Exception e) { }
        try {
            Tile.tileset_m_orange_front[0] = ImageIO.read(new File("res/Images/male_orange_front2.png"));
            Tile.tileset_m_orange_front[1] = ImageIO.read(new File("res/Images/male_orange_front1.png"));
            Tile.tileset_m_orange_front[2] = ImageIO.read(new File("res/Images/male_orange_front2.png"));
            Tile.tileset_m_orange_front[3] = ImageIO.read(new File("res/Images/male_orange_front3.png"));

            Tile.tileset_m_orange_back[0] = ImageIO.read(new File("res/Images/male_orange_back2.png"));
            Tile.tileset_m_orange_back[1] = ImageIO.read(new File("res/Images/male_orange_back1.png"));
            Tile.tileset_m_orange_back[2] = ImageIO.read(new File("res/Images/male_orange_back2.png"));
            Tile.tileset_m_orange_back[3] = ImageIO.read(new File("res/Images/male_orange_back3.png"));

            Tile.tileset_m_orange_left[0] = ImageIO.read(new File("res/Images/male_orange_left2.png"));
            Tile.tileset_m_orange_left[1] = ImageIO.read(new File("res/Images/male_orange_left1.png"));
            Tile.tileset_m_orange_left[2] = ImageIO.read(new File("res/Images/male_orange_left2.png"));
            Tile.tileset_m_orange_left[3] = ImageIO.read(new File("res/Images/male_orange_left3.png"));

            Tile.tileset_m_orange_right[0] = ImageIO.read(new File("res/Images/male_orange_right2.png"));
            Tile.tileset_m_orange_right[1] = ImageIO.read(new File("res/Images/male_orange_right1.png"));
            Tile.tileset_m_orange_right[2] = ImageIO.read(new File("res/Images/male_orange_right2.png"));
            Tile.tileset_m_orange_right[3] = ImageIO.read(new File("res/Images/male_orange_right3.png"));

            Tile.tileset_m_orange_death[0] = ImageIO.read(new File("res/Images/male_orange_death1.png"));
            Tile.tileset_m_orange_death[1] = ImageIO.read(new File("res/Images/male_orange_death2.png"));
            Tile.tileset_m_orange_death[2] = ImageIO.read(new File("res/Images/male_orange_death3oops.png"));
            Tile.tileset_m_orange_death[3] = ImageIO.read(new File("res/Images/male_orange_death3oops.png"));

            Tile.tileset_m_orange_found[0] = ImageIO.read(new File("res/Images/male_orange_death1.png"));
            Tile.tileset_m_orange_found[1] = ImageIO.read(new File("res/Images/male_orange_death2.png"));
            Tile.tileset_m_orange_found[2] = ImageIO.read(new File("res/Images/male_orange_death3found.png"));
            Tile.tileset_m_orange_found[3] = ImageIO.read(new File("res/Images/male_orange_death3found.png"));
        } catch (Exception e) { }
        try{
            Tile.tileset_m_stripes_front[0] = ImageIO.read(new File("res/Images/male_stripes_front2.png"));
            Tile.tileset_m_stripes_front[1] = ImageIO.read(new File("res/Images/male_stripes_front1.png"));
            Tile.tileset_m_stripes_front[2] = ImageIO.read(new File("res/Images/male_stripes_front2.png"));
            Tile.tileset_m_stripes_front[3] = ImageIO.read(new File("res/Images/male_stripes_front3.png"));

            Tile.tileset_m_stripes_back[0] = ImageIO.read(new File("res/Images/male_stripes_back2.png"));
            Tile.tileset_m_stripes_back[1] = ImageIO.read(new File("res/Images/male_stripes_back1.png"));
            Tile.tileset_m_stripes_back[2] = ImageIO.read(new File("res/Images/male_stripes_back2.png"));
            Tile.tileset_m_stripes_back[3] = ImageIO.read(new File("res/Images/male_stripes_back3.png"));

            Tile.tileset_m_stripes_left[0] = ImageIO.read(new File("res/Images/male_stripes_left2.png"));
            Tile.tileset_m_stripes_left[1] = ImageIO.read(new File("res/Images/male_stripes_left1.png"));
            Tile.tileset_m_stripes_left[2] = ImageIO.read(new File("res/Images/male_stripes_left2.png"));
            Tile.tileset_m_stripes_left[3] = ImageIO.read(new File("res/Images/male_stripes_left3.png"));

            Tile.tileset_m_stripes_right[0] = ImageIO.read(new File("res/Images/male_stripes_right2.png"));
            Tile.tileset_m_stripes_right[1] = ImageIO.read(new File("res/Images/male_stripes_right1.png"));
            Tile.tileset_m_stripes_right[2] = ImageIO.read(new File("res/Images/male_stripes_right2.png"));
            Tile.tileset_m_stripes_right[3] = ImageIO.read(new File("res/Images/male_stripes_right3.png"));

            Tile.tileset_m_stripes_death[0] = ImageIO.read(new File("res/Images/male_stripes_death1.png"));
            Tile.tileset_m_stripes_death[1] = ImageIO.read(new File("res/Images/male_stripes_death2.png"));
            Tile.tileset_m_stripes_death[2] = ImageIO.read(new File("res/Images/male_stripes_death3oops.png"));
            Tile.tileset_m_stripes_death[3] = ImageIO.read(new File("res/Images/male_stripes_death3oops.png"));

            Tile.tileset_m_stripes_found[0] = ImageIO.read(new File("res/Images/male_stripes_death1.png"));
            Tile.tileset_m_stripes_found[1] = ImageIO.read(new File("res/Images/male_stripes_death2.png"));
            Tile.tileset_m_stripes_found[2] = ImageIO.read(new File("res/Images/male_stripes_death3found.png"));
            Tile.tileset_m_stripes_found[3] = ImageIO.read(new File("res/Images/male_stripes_death3found.png"));
        } catch (Exception e) { }

        //enemies
        try{
            Tile.tileset_guard[0] = ImageIO.read(new File("res/Images/guard_front1.png"));
            Tile.tileset_guard[1] = ImageIO.read(new File("res/Images/guard_front2.png"));
            Tile.tileset_guard[2] = ImageIO.read(new File("res/Images/guard_front1.png"));
            Tile.tileset_guard[3] = ImageIO.read(new File("res/Images/guard_front3.png"));

        } catch (Exception e) { }
        try{
            Tile.tileset_guard_death[0] = ImageIO.read(new File("res/Images/guard_death1.png"));
            Tile.tileset_guard_death[1] = ImageIO.read(new File("res/Images/guard_death2.png"));
            Tile.tileset_guard_death[2] = ImageIO.read(new File("res/Images/guard_death3.png"));
            Tile.tileset_guard_death[3] = ImageIO.read(new File("res/Images/guard_death4.png"));

        } catch (Exception e) { }
        try{
            Tile.tileset_army_man[0] = ImageIO.read(new File("res/Images/army_man_front1.png"));
            Tile.tileset_army_man[1] = ImageIO.read(new File("res/Images/army_man_front2.png"));
            Tile.tileset_army_man[2] = ImageIO.read(new File("res/Images/army_man_front1.png"));
            Tile.tileset_army_man[3] = ImageIO.read(new File("res/Images/army_man_front3.png"));
        } catch (Exception e) { }
        try{
            Tile.tileset_army_man_death[0] = ImageIO.read(new File("res/Images/army_man_death1.png"));
            Tile.tileset_army_man_death[1] = ImageIO.read(new File("res/Images/army_man_death2.png"));
            Tile.tileset_army_man_death[2] = ImageIO.read(new File("res/Images/army_man_death3.png"));
            Tile.tileset_army_man_death[3] = ImageIO.read(new File("res/Images/army_man_death4.png"));

        } catch (Exception e) { }
        try{
            Tile.tileset_swat[0] = ImageIO.read(new File("res/Images/swat_front2.png"));
            Tile.tileset_swat[1] = ImageIO.read(new File("res/Images/swat_front1.png"));
            Tile.tileset_swat[2] = ImageIO.read(new File("res/Images/swat_front2.png"));
            Tile.tileset_swat[3] = ImageIO.read(new File("res/Images/swat_front3.png"));
        } catch (Exception e) { }
        try{
            Tile.tileset_swat_death[0] = ImageIO.read(new File("res/Images/swat_death1.png"));
            Tile.tileset_swat_death[1] = ImageIO.read(new File("res/Images/swat_death2.png"));
            Tile.tileset_swat_death[2] = ImageIO.read(new File("res/Images/swat_death3.png"));
            Tile.tileset_swat_death[3] = ImageIO.read(new File("res/Images/swat_death4.png"));
        } catch (Exception e) { }
        try{
            Tile.tileset_bomb[0] = ImageIO.read(new File("res/Images/C4_4.png"));
            Tile.tileset_bomb[1] = ImageIO.read(new File("res/Images/C4_3.png"));
            Tile.tileset_bomb[2] = ImageIO.read(new File("res/Images/C4_2.png"));
            Tile.tileset_bomb[3] = ImageIO.read(new File("res/Images/C4_1.png"));
        } catch (Exception e) { }
        try{
            Tile.tileset_explosion_core = ImageIO.read(new File("res/Images/explosion_core.png"));
            Tile.tileset_explosion_horizontal = ImageIO.read(new File("res/Images/explosion_horizontal.png"));
            Tile.tileset_explosion_vertical = ImageIO.read(new File("res/Images/explosion_vertical.png"));
        } catch (Exception e) { }
    }
}

