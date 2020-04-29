package DynaBlast;

import java.util.ArrayList;

public class CollisionChecker {

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

    public static void isContactCharacterEnemy(ArrayList<Enemy> enemyArrayList, Character character){
        for(Enemy enemy:enemyArrayList){
            if((enemy.getCellAtMap()[0] == character.getCellAtMap()[0])&&(enemy.getCellAtMap()[1] == character.getCellAtMap()[1])){
                character.captured();
                break;
            }
        }
    }

}
