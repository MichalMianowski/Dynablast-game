package DynaBlast;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Level {
    int margin = 20;
    int timeLeft; //in seconds
    public Block[][] block = new Block[15][15];
    public char[][] blockList = new char[15][15];
    public File fileLocation1 = new File("Levels/Poziom_5.txt");
    public Scanner sc;

    ArrayList<Enemy> enemies = new ArrayList();

    //lvl testowy
    //char[][] lvl_example = new char[15][15];


    public Level() {
        timeLeft = 242;
        generateLevel();
        //lvl testowy
        loadLevelFromFile();
        //createLevel();
        loadLevel(blockList);

    }

    public void generateLevel() {
        for (int y = 0; y < block.length; y++) {
            for (int x = 0; x < block.length; x++) {
                block[x][y] = new Block(new Rectangle(margin + x * Tile.tileSize, margin + y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.empty);
            }
        }
    }

    public void loadLevelFromFile() {
        int n = 0;
        try {
            sc = new Scanner(fileLocation1);
            while (sc.hasNext()) {
                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 15; j++) {
                        blockList[i][j] = sc.next().charAt(0);
                        System.out.println(blockList[i][j]);
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

//    public void createLevel() {
//        for (int i = 0; i < 15; i++) {
//            for (int j = 0; j < 15; j++) {
//                if (blockList[i][j] == 'U') {
//                    lvl_example[j][i] = Tile.unbreakable;
//                } else if (blockList[i][j] == 'B') {
//                    lvl_example[j][i] = Tile.bars;
//                } else if (blockList[i][j] == 'L') {
//                    lvl_example[j][i] = Tile.ladder;
//                } else if (blockList[i][j] == 'G') {
//                    lvl_example[j][i] = Tile.guard;
//                } else if (blockList[i][j] == 'S') {
//                    lvl_example[j][i] = Tile.swat;
//                } else {
//                    lvl_example[j][i] = Tile.empty;
//                }
//            }
//        }
//    }

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

    public void render(Graphics g) {
        for (int y = 0; y < block.length; y++) {
            for (int x = 0; x < block.length; x++) {
                block[x][y].render(g);
            }
        }
    }
}
