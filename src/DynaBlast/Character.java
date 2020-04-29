/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *  Class representing player's character
 *  class extends class @Creatures
 *
 *  4 different skins for character
 *  each has size of standard @Tile
 *
 *  contains information about lives and score of the player
 */
public class Character extends Creatures {
    /** image of character */
    public static BufferedImage img;
    /** number of player's lives */
    private static int lives;
    /** player's score */
    static int score;
<<<<<<< HEAD
    /** type of character */
    char type;
    /** basic movement speed may be edited by factor from config */
    public static double movementSpeed = 1;
    /** contains info about horizontal move */
    public static boolean isMovingX = false;
    /** contains info about vertical move */
    public static boolean isMovingY = false;
    /** amount of distance to move horizontal */
    public static double dirX = 0;
    /** amount of distance to move vertical */
    public static double dirY = 0;

    /** graphics needed to animations */
=======
    char type;
    public static double movementSpeed = 1;
    public static boolean isMovingX = false;
    public static boolean isMovingY = false;
    public static double dirX = 0;
    public static double dirY = 0;

>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    Graphic graph1, graph2, graph3, graph4;

    /**
     * creates object of character with skin chosen by player
     * character always start at left top corner of the map (@Level.margin + @Tile.tileSize)
     *
     * @param type
     *      information which skin of character player has chosen
     * @param lives
     *      information about remaining lives of the player
     */
    public Character(char type, int lives){
        this.type = type;
        setBounds(x = Level.margin + Tile.tileSize, y = Level.margin + Tile.tileSize, Tile.tileSize, Tile.tileSize);

        if (type == Tile.female_orange){
            img = Tile.tileset_fem_orange;
        }
        else if (type == Tile.female_stripes){
            img = Tile.tileset_fem_stripes;
        }
        else if (type == Tile.male_orange){
            graph1 = new Graphic(15, Tile.tileset_m_orange_front[0], Tile.tileset_m_orange_front[1], Tile.tileset_m_orange_front[2], Tile.tileset_m_orange_front[3]);
            graph2 = new Graphic(15, Tile.tileset_m_orange_back[0], Tile.tileset_m_orange_back[1], Tile.tileset_m_orange_back[2], Tile.tileset_m_orange_back[3]);
            graph3 = new Graphic(15, Tile.tileset_m_orange_right[0], Tile.tileset_m_orange_right[1], Tile.tileset_m_orange_right[2], Tile.tileset_m_orange_right[3]);
            graph4 = new Graphic(15, Tile.tileset_m_orange_left[0], Tile.tileset_m_orange_left[1], Tile.tileset_m_orange_left[2], Tile.tileset_m_orange_left[3]);
            img = Tile.tileset_m_orange_front[0];
        }
        else{
            img = Tile.tileset_m_stripes;
        }

        Character.lives = lives;
    }

    /** @return number of player's lives */
    public int getLives(){
        return lives;
    }

    /** @return player's score */
    public int getScore(){
        return score;
    }

    /** function that updates the character,
     *  therefore moves him/her and sets according aniamtion depending on the movement direction */
    public void tick(){
        move();
    }

<<<<<<< HEAD
    /**
     * moving main character according to typed keyboard key
     */
=======

>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    private void move() {
        if (isMovingX) {
            boolean cantMove = false;
            if(dirX == movementSpeed){
                cantMove = CollisionChecker.isCollidingRight(this);
            }
            if(dirX == -movementSpeed){
                cantMove = CollisionChecker.isCollidingLeft(this);
            }

            if(!cantMove){
                x += dirX;
            }
        }

        if (isMovingY) {
            boolean cantMove = false;
            if(dirY == movementSpeed){
                cantMove = CollisionChecker.isCollidingDown(this);
            }
            if(dirY == -movementSpeed){
                cantMove = CollisionChecker.isCollidingUp(this);
            }

            if(!cantMove){
                y += dirY;
            }
        }
        moveAnimation();

        if(Game.level.escapeVisible == 2){
            if((getCellAtMap()[0] == Game.level.cellOfEscape[0])&&(getCellAtMap()[1] == Game.level.cellOfEscape[1])){
                Game.level.win();
            }
        }
    }

<<<<<<< HEAD
    /**
     * instruction after contact with enemy
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    public void captured(){
        System.out.println("You're captured! Exterminate!");
        die();
    }
<<<<<<< HEAD

    /**
     * instruction after contact with explosion
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    public void exploded(){
        System.out.println("You're not fireproof!");
        die();
    }

<<<<<<< HEAD
    /**
     * instruction of death
     * common to exploded and captured
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    public void die(){
        x = Level.margin + Tile.tileSize;
        y = Level.margin + Tile.tileSize;
        lives--;
        Game.level.restart = true;
    }

<<<<<<< HEAD
    /**
     * placing bomb at current cell
     */
=======

>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    public void placeBomb() {
        Game.level.addBomb(getCellAtMap());
    }


    /** render character's image on map
     *
     * @param g Graphic to which render images and draw animations
     */
    public void render(Graphics g){
        if (this.type == Tile.male_orange) {
            if (dirY == 0 && dirX == 0){
                g.drawImage(img, (int) x, (int) y, null);
            }
            else if (dirY > 0) {
                graph1.drawAnimation(g, x, y);
            }
            else if (dirY < 0) {
                graph2.drawAnimation(g, x, y);
            }
            else if (dirX > 0) {
                graph3.drawAnimation(g, x, y);
            }
            else if (dirX < 0) {
                graph4.drawAnimation(g, x, y);
            }
        }
        else
            g.drawImage(img, (int) x, (int) y, null);
    }
<<<<<<< HEAD

    /**
     * instructions of moving the character
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    private void moveAnimation(){
        if (dirY > 0) {
            graph1.runAnimation();
        }
        else if (dirY < 0){
            graph2.runAnimation();
        }
        else if (dirX > 0){
            graph3.runAnimation();
        }
        else if (dirX < 0){
            graph4.runAnimation();
        }
    }

}
