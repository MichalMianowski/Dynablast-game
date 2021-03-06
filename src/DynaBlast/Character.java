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

    static boolean scaled1 = false;
    static boolean scaled2 = false;

    /** graphics needed to animations */
    Animation walkFront, walkBack, walkRight, walkLeft;

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
        final float FACTOR  = 2f;
        this.type = type;
        setBounds(x = Level.margin + Tile.tileSize, y = Level.margin + Tile.tileSize, Tile.tileSize, Tile.tileSize);
        loadSkin(FACTOR);

        Character.lives = lives;
        Character.score = 0;
    }

    /** @return number of player's lives */
    public int getLives(){
        return lives;
    }

    public void setLives(int LIVE){
        lives = LIVE;
    }

    /** @return player's score */
    public int getScore(){
        return score;
    }

    @Override
    public void loadSkin(float FACTOR) {
        if (type == Tile.female_orange){
            walkFront = new Animation(15, Tile.tileset_fem_orange_front);
            walkBack = new Animation(15, Tile.tileset_fem_orange_back);
            walkRight = new Animation(15, Tile.tileset_fem_orange_right);
            walkLeft = new Animation(15, Tile.tileset_fem_orange_left);
            img = Tile.tileset_fem_orange_front[0];
            int ScaleX1 = (int) (img.getWidth()*FACTOR);
            int ScaleY1 = (int) (img.getHeight()*FACTOR);
            Image img1 = img.getScaledInstance(ScaleX1,ScaleY1,Image.SCALE_SMOOTH);
            img = new BufferedImage(ScaleX1,ScaleY1,BufferedImage.TYPE_INT_ARGB);
            img.getGraphics().drawImage(img1,0,0,null);
        }
        else if (type == Tile.female_stripes){
            walkFront = new Animation(15, Tile.tileset_fem_stripes_front);
            walkBack = new Animation(15, Tile.tileset_fem_stripes_back);
            walkRight = new Animation(15, Tile.tileset_fem_stripes_right);
            walkLeft = new Animation(15, Tile.tileset_fem_stripes_left);
            img = Tile.tileset_fem_stripes_front[0];
            int ScaleX1 = (int) (img.getWidth()*FACTOR);
            int ScaleY1 = (int) (img.getHeight()*FACTOR);
            Image img1 = img.getScaledInstance(ScaleX1,ScaleY1,Image.SCALE_SMOOTH);
            img = new BufferedImage(ScaleX1,ScaleY1,BufferedImage.TYPE_INT_ARGB);
            img.getGraphics().drawImage(img1,0,0,null);
        }
        else if (type == Tile.male_orange){
            walkFront = new Animation(15, Tile.tileset_m_orange_front);
            walkBack = new Animation(15, Tile.tileset_m_orange_back);
            walkRight = new Animation(15, Tile.tileset_m_orange_right);
            walkLeft = new Animation(15, Tile.tileset_m_orange_left);
            img = Tile.tileset_m_orange_front[0];
            int ScaleX1 = (int) (img.getWidth()*FACTOR);
            int ScaleY1 = (int) (img.getHeight()*FACTOR);
            Image img1 = img.getScaledInstance(ScaleX1,ScaleY1,Image.SCALE_SMOOTH);
            img = new BufferedImage(ScaleX1,ScaleY1,BufferedImage.TYPE_INT_ARGB);
            img.getGraphics().drawImage(img1,0,0,null);
        }
        else if (type == Tile.male_stripes){
            walkFront = new Animation(15, Tile.tileset_m_stripes_front);
            walkBack = new Animation(15, Tile.tileset_m_stripes_back);
            walkRight = new Animation(15, Tile.tileset_m_stripes_right);
            walkLeft = new Animation(15, Tile.tileset_m_stripes_left);
            img = Tile.tileset_m_stripes_front[0];
            int ScaleX1 = (int) (img.getWidth()*FACTOR);
            int ScaleY1 = (int) (img.getHeight()*FACTOR);
            Image img1 = img.getScaledInstance(ScaleX1,ScaleY1,Image.SCALE_SMOOTH);
            img = new BufferedImage(ScaleX1,ScaleY1,BufferedImage.TYPE_INT_ARGB);
            img.getGraphics().drawImage(img1,0,0,null);
        }
    }

    /** function that updates the character,
     *  therefore moves him/her and sets according aniamtion depending on the movement direction */
    public void tick(){
        move();
    }

    /**
     * moving main character according to typed keyboard key
     */
    private void move() {
        moveAnimation();
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

        if(Game.level.escapeVisible == 2){
            if((getCellAtMap()[0] == Game.level.cellOfEscape[0])&&(getCellAtMap()[1] == Game.level.cellOfEscape[1])){
                Game.level.win();
            }
        }
    }

    /**
     * instruction after contact with enemy
     */
    public void captured(){
        System.out.println("You're captured! Exterminate!");
        die();
    }

    /**
     * instruction after contact with explosion
     */
    public void exploded(){
        System.out.println("You're not fireproof!");
        die();
    }

    /**
     * instruction after end of time
     */
    public void TimeRunOut(){
        System.out.println("You didn't manage to escape in time");
        die();
    }

    /**
     * instruction of death
     * common to exploded and captured
     */
    public void die(){
        if (lives == 1){
            Game.death = true;
            Level.timeLeft = -2;
        }
        else {
            Game.level.restart = true;
            Character.score = Game.BeginPoints;
        }
        restartPosition();
    }

    /** restart position of character to original one */
    public void restartPosition(){
        x = Level.margin + Tile.tileSize;
        y = Level.margin + Tile.tileSize;
        dirX = 0;
        dirY = 0;
    }

    /** reduce number of player's lives by on */
    public void reduceLives() {
        lives--;
    }

    /**
     * placing bomb at current cell
     */
    public void placeBomb() {
        Game.level.addBomb(getCellAtMap());
        if (!scaled1){
            scaled1 = true;
        }
    }

    /** render character's image on map
     *
     * @param g Graphic to which render images and draw animations
     */
    public void render(Graphics g){
            if (dirY == 0 && dirX == 0){
                g.drawImage(img, (int) x, (int) y, null);
            }
            else if (dirY > 0) {
                walkFront.drawAnimation(g, x, y);
            }
            else if (dirY < 0) {
                walkBack.drawAnimation(g, x, y);
            }
            else if (dirX > 0) {
                walkRight.drawAnimation(g, x, y);
            }
            else if (dirX < 0) {
                walkLeft.drawAnimation(g, x, y);
            }
        }

    /**
     * instructions of moving the character
     */
    private void moveAnimation(){
        if (dirY > 0) {
            walkFront.tickAnimation(this);
        }
        else if (dirY < 0){
            walkBack.tickAnimation(this);
        }
        else if (dirX > 0){
            walkRight.tickAnimation(this);
        }
        else if (dirX < 0){
            walkLeft.tickAnimation(this);
        }
    }
}
