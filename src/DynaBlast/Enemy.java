/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.awt.*;

/**
 * Class of enemy mobs
 * class extends class @Creatures
 *
 * 3 different types of enemies
 * each has size of standard @Tile
 */
public class Enemy extends Creatures {
    /** contain information about type of the enemy */
    char type;
    /** speed or vertical move can be changed by speed factor */
    double VerticalSpeed;
    /** speed or horizontal move can be changed by speed factor */
    double HorizontalSpeed;
    /** number of lives of enemy
     * -> some enemies would be killed only after few explosion contacts
     */
    int lives;
    /** basic ammount of points gained by killing this enemy
     * may be eddited by points factor depending of difficulty level
      */
    float points;
    /** should he change direction (because of collision with wall) */
    boolean turn = false;

    /** graphics needed to animations */

    Animation animAlive, animDying;

    /**
     *  creates object of the enemy with @Tile size
     *  sets the parameters of the enemy depending on its type and difficulty level
     *  as well as creating animation frames
     *
     * @param type
     *      type of enemy {guard, army man, swat}
     * @param x0
     *      coordinate x of starting enemy
     * @param y0
     *      coordinate y of starting enemy
     */
    public Enemy(char type, int x0, int y0){
        setBounds(x0, y0, Tile.tileSize, Tile.tileSize);
        this.type = type;
        loadSkin(2f);
        loadSpeed();
        x = x0;
        y = y0;
    }

    private void loadSpeed() {
        if (this.type == Tile.army_man){
            this.HorizontalSpeed = 0.5 * Configurations.speedMultiplier;
            this.VerticalSpeed = 0.5 * Configurations.speedMultiplier;
            this.lives = 1;
            this.points = 200;
        }
        else if (this.type == Tile.swat){
            this.HorizontalSpeed = 0.43 * Configurations.speedMultiplier;
            this.VerticalSpeed = 0.43 * Configurations.speedMultiplier;
            this.lives = 1;
            this.points = 150;
        }
        else if (this.type == Tile.guard){
            this.HorizontalSpeed = 0.35 * Configurations.speedMultiplier;
            this.VerticalSpeed = 0.35 * Configurations.speedMultiplier;
            this.lives = 1;
            this.points = 100;
        }
    }


    @Override
    public void loadSkin(float FACTOR) {
        if(type == Tile.guard) {
            animAlive = new Animation(10, Tile.tileset_guard);
            animDying = new Animation(10, Tile.tileset_guard_death);
        }
        else if(type == Tile.swat) {
            animAlive = new Animation(10, Tile.tileset_swat);
            animDying = new Animation(10, Tile.tileset_swat_death);
        }
        else if(type == Tile.army_man) {
            animAlive = new Animation(10, Tile.tileset_army_man);
            animDying = new Animation(10, Tile.tileset_army_man_death);
        }
    }

    /** changes the location of every enemy depending on its type
     * as well as making the animation for every type change with every clock tick
     */
    public void tick(){
        if (dying){
            animDying.tickDeathAnimation(this);
        }
        else if (!dead) {
            animAlive.tickAnimation(this);
        }

        if (this.type == Tile.guard) {
            y += this.VerticalSpeed;
            if(VerticalSpeed > 0){
                turn = CollisionChecker.isCollidingDown(this);
            }
            else{
                turn = CollisionChecker.isCollidingUp(this);
            }
            if (turn){
                this.VerticalSpeed = -this.VerticalSpeed;
            }
        }

        else if (this.type == Tile.swat){
            x += this.HorizontalSpeed;
            if(HorizontalSpeed > 0){
                turn = CollisionChecker.isCollidingRight(this);
            }
            else{
                turn = CollisionChecker.isCollidingLeft(this);
            }
            if (turn){
                    this.HorizontalSpeed = - this.HorizontalSpeed;
            }
        }

        else if (this.type == Tile.army_man){
            x += this.HorizontalSpeed;
            if(HorizontalSpeed > 0){
                turn = CollisionChecker.isCollidingRight(this);
            }
            else{
                turn = CollisionChecker.isCollidingLeft(this);
            }
            if (turn){
                this.HorizontalSpeed = - this.HorizontalSpeed;
            }
            y += this.VerticalSpeed;
            if(VerticalSpeed > 0){
                turn = CollisionChecker.isCollidingDown(this);
            }
            else{
                turn = CollisionChecker.isCollidingUp(this);
            }
            if (turn){
                this.VerticalSpeed = -this.VerticalSpeed;
            }
        }
    }

    public void die() {
        dead = true;
    }


    /** render image of enemy depending on his type
     * @param g Graphic to which render images and draw animations
     */
    public void render(Graphics g){
        if (dying) {
            animDying.drawAnimation(g, x, y);
        }
        else if (!dead) {
            animAlive.drawAnimation(g, x, y);
        }
    }

    /**
     * grant points for killing enemy
     *
     * @param enemy - which is killed
     */
    public static void grantPoints(Enemy enemy) {
        if (enemy.dead) {
            if (enemy.type == Tile.army_man) {
                Character.score += enemy.points * Configurations.pointsMultiplier;
            } else if (enemy.type == Tile.swat) {
                Character.score += enemy.points * Configurations.pointsMultiplier;
            } else if (enemy.type == Tile.guard) {
                Character.score += enemy.points * Configurations.pointsMultiplier;
            }
        }
    }
}
