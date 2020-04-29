<<<<<<< HEAD
/**
 * Michal Mianowski & Piotr Strzaska
 */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
package DynaBlast;

import java.util.ArrayList;

<<<<<<< HEAD
/**
 * class to service collisions
 */
public class CollisionChecker {
    /**
     * is colliding with first cell from left
     *
     * @param cr Creature to check
     * @return boolean yes or no contacting
     */
=======
public class CollisionChecker {

>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    public static boolean isCollidingLeft(Creatures cr){
        int[] cell = cr.getCellsHorizontalMove();
        if(Game.level.block[cell[0]-1][cell[1]].id != Tile.empty){
            if(Game.level.block[cell[0]-1][cell[1]].intersects(cr.getBounds())){
                cr.x += 0.01;
                return true;
            }
        }
        else if(Game.level.block[cell[0]-1][cell[2]].id != Tile.empty){
            if(Game.level.block[cell[0]-1][cell[2]].intersects(cr.getBounds())){
                cr.x += 0.01;
                return true;
            }
        }
        return false;
    }
<<<<<<< HEAD
    /**
     * is colliding with first cell from right
     *
     * @param cr Creature to check
     * @return boolean yes or no contacting
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    public static boolean isCollidingRight(Creatures cr){
        int[] cell = cr.getCellsHorizontalMove();
        if(Game.level.block[cell[0]+1][cell[1]].id != Tile.empty){
            if(Game.level.block[cell[0]+1][cell[1]].intersects(cr.getBounds())){
                cr.x -= 0.01;
                return true;
            }
        }
        else if(Game.level.block[cell[0]+1][cell[2]].id != Tile.empty){
            if(Game.level.block[cell[0]+1][cell[2]].intersects(cr.getBounds())){
                cr.x -= 0.01;
                return true;
            }
        }
        return false;
    }
<<<<<<< HEAD
    /**
     * is colliding with first cell from up
     *
     * @param cr Creature to check
     * @return boolean yes or no contacting
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    public static boolean isCollidingUp(Creatures cr){
        int[] cell = cr.getCellsVerticalMove();
        if(Game.level.block[cell[0]][cell[2]-1].id != Tile.empty){
            if(Game.level.block[cell[0]][cell[2]-1].intersects(cr.getBounds())){
                cr.y += 0.01;
                return true;
            }
        }
        else if(Game.level.block[cell[1]][cell[2]-1].id != Tile.empty){
            if(Game.level.block[cell[1]][cell[2]-1].intersects(cr.getBounds())){
                cr.y += 0.01;
                return true;
            }
        }
        return false;
    }
<<<<<<< HEAD
    /**
     * is colliding with first cell from down
     *
     * @param cr Creature to check
     * @return boolean yes or no contacting
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    public static boolean isCollidingDown(Creatures cr){
        int[] cell = cr.getCellsVerticalMove();
        if(Game.level.block[cell[0]][cell[2]+1].id != Tile.empty){
            if(Game.level.block[cell[0]][cell[2]+1].intersects(cr.getBounds())){
                cr.y -= 0.01;
                return true;
            }
        }
        else if(Game.level.block[cell[1]][cell[2]+1].id != Tile.empty){
            if(Game.level.block[cell[1]][cell[2]+1].intersects(cr.getBounds())){
                cr.y -= 0.01;
                return true;
            }
        }
        return false;
    }

<<<<<<< HEAD
    /**
     * checking contact of main character with enemies
     * if contact is present execute captured procedure
     *
     * @param enemyArrayList list of enemies alive at map
     * @param character main character
     */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    public static void isContactCharacterEnemy(ArrayList<Enemy> enemyArrayList, Character character){
        for(Enemy enemy:enemyArrayList){
            if((enemy.getCellAtMap()[0] == character.getCellAtMap()[0])&&(enemy.getCellAtMap()[1] == character.getCellAtMap()[1])){
                character.captured();
                break;
            }
        }
    }

}
