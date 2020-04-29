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
<<<<<<< HEAD
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
    int points;
    /** is this enemy dead if yes he will be removed from enemies list */
    boolean dead = false;
    /** is he dying if yes play animation of death and turn dead to value true */
    boolean dying = false;
    /** should he change direction (because of collision with wall) */
    boolean turn = false;

    /** graphics needed to animations */
=======
    double VerticalSpeed;
    double HorizontalSpeed;
    int lives;
    int points;
    boolean dead = false;
    boolean turn = false;

>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    Graphic graph1, graph2, graph3;

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
        if (this.type == Tile.army_man){
            this.HorizontalSpeed = 0.5 * Configurations.speedMultiplier;
            this.VerticalSpeed = 0.5 * Configurations.speedMultiplier;
            this.lives = 2;
            this.points = 200;
        }
        else if (this.type == Tile.swat){
            this.HorizontalSpeed = 0.4 * Configurations.speedMultiplier;
            this.VerticalSpeed = 0.4 * Configurations.speedMultiplier;
            this.lives = 1;
            this.points = 150;
        }
        else {
            this.HorizontalSpeed = 0.35 * Configurations.speedMultiplier;
            this.VerticalSpeed = 0.35 * Configurations.speedMultiplier;
            this.lives = 1;
            this.points = 100;
        }
        x = x0;
        y = y0;

        graph1 = new Graphic(10, Tile.tileset_guard[0], Tile.tileset_guard[1], Tile.tileset_guard[2], Tile.tileset_guard[3]);
        graph2 = new Graphic(10, Tile.tileset_swat[0], Tile.tileset_swat[1], Tile.tileset_swat[2], Tile.tileset_swat[3]);
        graph3 = new Graphic(10, Tile.tileset_army_man[0], Tile.tileset_army_man[1], Tile.tileset_army_man[2], Tile.tileset_army_man[3]);
<<<<<<< HEAD

=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    }

    /** changes the location of every enemy depending on its type
     * as well as making the animation for every type change with every clock tick
     */
    public void tick(){
<<<<<<< HEAD
        if (!dying) {
            graph1.runAnimation();
            graph2.runAnimation();
            graph3.runAnimation();
        }
        else if (dying){
            graph1.runAnimationOnce(this);
            graph2.runAnimationOnce(this);
            graph3.runAnimationOnce(this);
        }
=======
        graph1.runAnimation();
        graph2.runAnimation();
        graph3.runAnimation();
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802

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

<<<<<<< HEAD
=======
    public void die() {
        dead = true;
    }


>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    /** render image of enemy depending on his type
     * @param g Graphic to which render images and draw animations
     */
    public void render(Graphics g){
        if (type == Tile.army_man){
            graph3.drawAnimation(g, x, y);
        }
        else if (type == Tile.swat){
            graph2.drawAnimation(g, x, y);
        }
<<<<<<< HEAD
        else if (type == Tile.guard) {
=======
        else if (type == Tile.guard){
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
            graph1.drawAnimation(g, x, y);
        }
    }
}
<<<<<<< HEAD

=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
