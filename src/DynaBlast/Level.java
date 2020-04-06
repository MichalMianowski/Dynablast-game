/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * Class loads level from file to two dimensions char table
 * and from this table loads level to two dimensions Block table.
 * Contains render method.
 *
 * @author Michal Mianowski, Piotr Strzaska
 */
public class Level {
    /** margin from left and top of the window */
    public static int margin = 20;
    /** timer for level in seconds */
    int timeLeft; //in seconds
    /** two dimensions table of @Block containing all level blocks */
    public Block[][] block = new Block[15][15];
    /**
     * two dimensions table of chars containing coded data about level plan
     * receive data from external file by @loadLevelFromFile method
     * */
    public char[][] blockList = new char[15][15];

    /** information about path to .txt file with level data */
    public File fileLocation1 = new File("Levels/Poziom_1.txt");
    /** scanner to read chars from .txt file */
    public Scanner sc;

    /** ArrayList containing all enemies at this level */
    ArrayList<Enemy> enemies = new ArrayList();


    /** Creates object of Level */
    public Level() {
        timeLeft = 242;
        generateLevel();
        loadLevelFromFile();
        loadLevel(blockList);
    }

    /** generates block in each cell of @Block table and set appropriate X and Y location */
    public void generateLevel() {
        for (int y = 0; y < block.length; y++) {
            for (int x = 0; x < block.length; x++) {
                block[x][y] = new Block(new Rectangle(margin + x * Tile.tileSize, margin + y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.empty);
            }
        }
    }

    /**
     * loads level data from txt file
     * loads to two dimensions char table @blockList
     */
    public void loadLevelFromFile() {
        int n = 0;
        try {
            sc = new Scanner(fileLocation1);
            while (sc.hasNext()) {
                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 15; j++) {
                        blockList[j][i] = sc.next().charAt(0);
                    }
                }
                n++;
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Blad wczytywania pliku");
            e.printStackTrace();
        }
    }

    /**
     * according to blockList set appropriate Block type to each level's block
     *
     * @param lvl two dimensions table containing data about level coded in chars
     */
    public void loadLevel(char[][] lvl) {
        for (int y = 0; y < block.length; y++) {
            for (int x = 0; x < block.length; x++) {
                if (lvl[x][y] == Tile.empty) {
                } else if (lvl[x][y] == Tile.unbreakable) {
                    block[x][y].id = Tile.unbreakable;
                } else if (lvl[x][y] == Tile.bars) {
                    block[x][y].id = Tile.bars;
                } else if (lvl[x][y] == Tile.ladder) {
                    block[x][y].id = Tile.ladder;
                } else if (lvl[x][y] == Tile.guard) {
                    enemies.add(new Enemy(Tile.guard, margin + x * Tile.tileSize, margin + y * Tile.tileSize));
                } else if (lvl[x][y] == Tile.army_man) {
                    enemies.add(new Enemy(Tile.army_man, margin + x * Tile.tileSize, margin + y * Tile.tileSize));
                } else if (lvl[x][y] == Tile.swat) {
                    enemies.add(new Enemy(Tile.swat, margin + x * Tile.tileSize, margin + y * Tile.tileSize));
                }
            }
        }
    }


    public void tick() {

    }

    /** render each block in two dimensions block table
     *
     * @param g Graphic to which render images
     */
    public void render(Graphics g) {
        for (int y = 0; y < block.length; y++) {
            for (int x = 0; x < block.length; x++) {
                block[x][y].render(g);
            }
        }
    }

}
