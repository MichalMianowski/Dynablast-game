/**
 * Michal Mianowski & Piotr Strzaska
 */

package DynaBlast;

import java.util.ArrayList;

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
    public static boolean isCollidingLeft(Creatures cr){
        int[] cell = cr.getCellsHorizontalMove();
        if(Level.block[cell[0]-1][cell[1]].id != Tile.empty){
            if(Level.block[cell[0]-1][cell[1]].intersects(cr.getBounds())){
                cr.x += 0.01;
                return true;
            }
        }
        else if(Level.block[cell[0]-1][cell[2]].id != Tile.empty){
            if(Level.block[cell[0]-1][cell[2]].intersects(cr.getBounds())){
                cr.x += 0.01;
                return true;
            }
        }
        return false;
    }

    /**
     * is colliding with first cell from right
     *
     * @param cr Creature to check
     * @return boolean yes or no contacting
     */
    public static boolean isCollidingRight(Creatures cr){
        int[] cell = cr.getCellsHorizontalMove();
        if(Level.block[cell[0]+1][cell[1]].id != Tile.empty){
            if(Level.block[cell[0]+1][cell[1]].intersects(cr.getBounds())){
                cr.x -= 0.01;
                return true;
            }
        }
        else if(Level.block[cell[0]+1][cell[2]].id != Tile.empty){
            if(Level.block[cell[0]+1][cell[2]].intersects(cr.getBounds())){
                cr.x -= 0.01;
                return true;
            }
        }
        return false;
    }

    /**
     * is colliding with first cell from up
     *
     * @param cr Creature to check
     * @return boolean yes or no contacting
     */
    public static boolean isCollidingUp(Creatures cr){
        int[] cell = cr.getCellsVerticalMove();
        if(Level.block[cell[0]][cell[2]-1].id != Tile.empty){
            if(Level.block[cell[0]][cell[2]-1].intersects(cr.getBounds())){
                cr.y += 0.01;
                return true;
            }
        }
        else if(Level.block[cell[1]][cell[2]-1].id != Tile.empty){
            if(Level.block[cell[1]][cell[2]-1].intersects(cr.getBounds())){
                cr.y += 0.01;
                return true;
            }
        }
        return false;
    }

    /**
     * is colliding with first cell from down
     *
     * @param cr Creature to check
     * @return boolean yes or no contacting
     */
    public static boolean isCollidingDown(Creatures cr){
        int[] cell = cr.getCellsVerticalMove();
        if(Level.block[cell[0]][cell[2]+1].id != Tile.empty){
            if(Level.block[cell[0]][cell[2]+1].intersects(cr.getBounds())){
                cr.y -= 0.01;
                return true;
            }
        }
        else if(Level.block[cell[1]][cell[2]+1].id != Tile.empty){
            if(Level.block[cell[1]][cell[2]+1].intersects(cr.getBounds())){
                cr.y -= 0.01;
                return true;
            }
        }
        return false;
    }

    /**
     * checking contact of main character with enemies
     * if contact is present execute captured procedure
     *
     * @param enemyArrayList list of enemies alive at map
     * @param character main character
     */
    public static void isContactCharacterEnemy(ArrayList<Enemy> enemyArrayList, Character character){
        for(Enemy enemy:enemyArrayList){
            if((enemy.getCellAtMap()[0] == character.getCellAtMap()[0])&&(enemy.getCellAtMap()[1] == character.getCellAtMap()[1])){
                character.captured();

                break;
            }
        }
    }

}
