/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.awt.*;
import java.util.ArrayList;
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
    static int timeLeft = 0; //in seconds
    static int timePoints;
    /** should the level will be restarted */
    public boolean restart = false;
    /** should be begin win procedure */
    public boolean win = false;

    /** two dimensions table of @Block containing all level blocks */
    public static Block[][] block;
    /**
     * two dimensions table of chars containing coded data about level plan
     * receive data from external file by @loadLevelFromFile method
     * */
    public static char[][] blockList;
    /** int table with information where will be escape cell */
    public int[] cellOfEscape = new int[2];
    /** flag of escape visible stage
     * 0 -not, 1 - ready to destroy, 2 - ready to escape
     */
    public int escapeVisible = 0;



    static File LevelSize1 = new File("res/config/Levels/Poziom rozmiar.txt");
    static File LevelLocation1 = new File("res/config/Levels/Poziom_1.txt");
    static File LevelLocation2 = new File("res/config/Levels/Poziom_2.txt");
    static File LevelLocation3 = new File("res/config/Levels/Poziom_3.txt");
    static File LevelLocation4 = new File("res/config/Levels/Poziom_4.txt");
    static File LevelLocation5 = new File("res/config/Levels/Poziom_5.txt");
    static File level;

    /** ArrayList containing all enemies at this level */
    static ArrayList<Enemy> enemies = new ArrayList();
    /** ArrayList containing all bombs unexploded */
    static ArrayList<Bomb> bombs = new ArrayList();
    /** ArrayList containing all present explosions */
    static ArrayList<Explosion> explosions = new ArrayList();

    /** Creates object of Level */
    public Level() {
        Configurations.generateLevel();
        Configurations.loadLevelFromFile(level);
        loadLevel(blockList);
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
                } else if (lvl[x][y] == Tile.escape_2) {
                    System.out.println("wczytano drabinę");
                    cellOfEscape[0] = x;
                    cellOfEscape[1] = y;
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
        if(restart){ restart();}
        CollisionChecker.isContactCharacterEnemy(enemies, Game.character);

        bombs.removeIf(bomb -> bomb.stage < -1);
        bombs.forEach(Bomb::tick);

        explosions.removeIf(explosion -> explosion.done);
        explosions.forEach(Explosion::tick);

        enemies.removeIf(enemy -> enemy.dead);
        escapeVisibility();
    }

    /**
     * adding bomb to list of bombs at map
     * @param cell in which cell bomb should be placed
     */
    public void addBomb(int[] cell){
        bombs.add(new Bomb(cell));
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
        if(escapeVisible == 1){
            block[cellOfEscape[0]][cellOfEscape[1]].render(g, Tile.escape_1);
        }
        else if(escapeVisible == 2){
            block[cellOfEscape[0]][cellOfEscape[1]].render(g, Tile.escape_2);
        }
    }

    /**
     * restart procedure
     * cleaning enemies, bombs
     * and reloading level
     */
    public void restart(){
        restart = false;
        escapeVisible = 0;
        bombs.clear();
        Level.enemies.clear();
        Configurations.generateLevel();
        Configurations.loadLevelFromFile(level);
        loadLevel(blockList);
    }

    /**control visibility of escape place image */
    private void escapeVisibility() {
        if((enemies.size() == 0)&&(escapeVisible == 0)){
            escapeVisible = 1;
        }
    }

    /** procedure after winning the level*/
    public void win() {
        if (!win) {
            System.out.println("tadaaa");
            win = true;
        }
    }


}
