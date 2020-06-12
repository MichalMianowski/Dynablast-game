/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


/** class that gets information about the level layout, level difficulty
 * and other important informations, not specified in the code
 */
public class Configurations {
    /**
     * path to the configuration file for "Easy" difficulty
     */
    static File Difficulty1 = new File("res/config/Difficulty/1.Easy.txt");
    /**
     * path to the configuration file for "Medium" difficulty
     */
    static File Difficulty2 = new File("res/config/Difficulty/2.Medium.txt");
    /**
     * path to the configuration file for "Hard" difficulty
     */
    static File Difficulty3 = new File("res/config/Difficulty/3.Hard.txt");

    /**
     * specifies how many times more points killing an enemy gives, depending on difficulty
     */
    static float pointsMultiplier = 0;
    /**
     * specifies how many points should be given for every remaining second on timer while finishing the level
     */
    static int timePoints = 0;
    /**
     * specifies how many seconds there is for finishing the level
     */
    static int time = 0;
    /**
     * specifies how many times faster the enemies are moving from their basic value
     */
    static float speedMultiplier = 0;
    /**
     * specifies the initial value of character's lives
     */
    static int lives = 0;
    /**
     * specifies the color of the background for game screen
     */
    static char color = 'a';
    /**
     * specifies width of level (in blocks)
     */
    static int width;
    /**
     * specifies height of level (in blocks)
     */
    static int height;

    /**
     * function, that reads the level layout from files
     * first it reads the level size (width and height and blocks) and creates accordingly big two dimensional board
     * then sets the type of every block according to the letter that was read from configuration file
     *
     * @param file specifies, from what file the informations should be read
     */
    public static void loadLevelFromFile(File file) {
        width = 0;
        height = 0;
        try {
            Scanner sc = new Scanner(Level.LevelSize1);
            while (sc.hasNext()) {

                width = sc.nextInt();
                height = sc.nextInt();
                Level.blockList = new char[width][height];
            }
            sc = new Scanner(file);
            while (sc.hasNext()) {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        Level.blockList[j][i] = sc.next().charAt(0);
                    }
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Blad wczytywania pliku");
            e.printStackTrace();
        }
    }

    /**
     * function that creates the level structure according to what was read in "LoadLevelFromFile" function
     */
    public static void generateLevel() {
        width = 0;
        height = 0;
        try {
            Scanner sc = new Scanner(Level.LevelSize1);
            while (sc.hasNext()) {
                width = sc.nextInt();
                height = sc.nextInt();
                Level.block = new Block[width][height];
            }
        } catch (Exception e) {
            System.out.println("Błąd wczytywania pliku");
            e.printStackTrace();
        }
        for (int y = 0; y < Level.block.length; y++) {
            for (int x = 0; x < Level.block.length; x++) {
                Level.block[x][y] = new Block(new Rectangle(Level.margin + x * Tile.tileSize, Level.margin + y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.empty);
            }
        }
    }

    /**
     * function that reads all informations about the level difficulty
     * and sets the necessary parameters according to read information
     *
     * @param file specifies from what file the information should be read
     */
    public static void loadDifficulty(File file) {
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                pointsMultiplier = sc.nextInt();
                timePoints = sc.nextInt();
                time = sc.nextInt();
                speedMultiplier = sc.nextInt();
                lives = sc.nextInt();
                color = sc.next().charAt(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Błąd wczytywania pliku");
            e.printStackTrace();
        }

        pointsMultiplier = pointsMultiplier / 100;
        speedMultiplier = speedMultiplier / 100;
        Level.timePoints = timePoints;
        Level.timeLeft = time;

        if (color == 'G') {
            Game.color = 'G';
        } else if (color == 'Y') {
            Game.color = 'Y';
        } else if (color == 'R') {
            Game.color = 'R';
        }
    }
}
