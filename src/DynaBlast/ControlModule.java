<<<<<<< HEAD
/**
 * Michal Mianowski & Piotr Strzaska
 */
=======
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
package DynaBlast;

import javax.swing.*;
import java.awt.event.*;

<<<<<<< HEAD
/**
 * class to control main character by keyboard
 * WASD or ARROWS to move
 * SPACEBAR to place a bomb
 */
public class ControlModule {
    /**
     * when key is pressed - start move in this axis
     * when release - stop move in this axis
     * placing bombs react only at pressing
     *
     * @param thisGame game to control
     */
=======
public class ControlModule {
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
    static void useKeyboard(Game thisGame){

        InputMap input = thisGame.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        //przypisanie nazw akcjom klaiwszy (sterowanie strzalkami lub WASD)
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");

        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "left_released");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "right_released");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "up_released");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "down_released");

        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "pause");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "place_bomb");

        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "left");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "right");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "up");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "down");

        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "left_released");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "right_released");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "up_released");
        input.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "down_released");


        ActionMap action = thisGame.getActionMap();

        //akcje wcisniecia klawisza
        action.put("left", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Character.isMovingX = true;
<<<<<<< HEAD
                Character.dirX = -Character.movementSpeed;
=======
                Character.dirX = -Game.character.movementSpeed;
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
            }
        });
        action.put("right", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Character.isMovingX = true;
<<<<<<< HEAD
                Character.dirX = Character.movementSpeed;
=======
                Character.dirX = Game.character.movementSpeed;
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
            }
        });
        action.put("up", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Character.isMovingY = true;
<<<<<<< HEAD
                Character.dirY = -Character.movementSpeed;
=======
                Character.dirY = -Game.character.movementSpeed;
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
            }
        });
        action.put("down", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Character.isMovingY = true;
<<<<<<< HEAD
                Character.dirY = Character.movementSpeed;
=======
                Character.dirY = Game.character.movementSpeed;
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
            }
        });

        //akcje puszczenia klawisza
        action.put("left_released", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                if(Character.dirX == -Character.movementSpeed){
=======
                if(Character.dirX == -Game.character.movementSpeed){
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
                    Character.dirX = 0;
                    Character.isMovingX = false;
                }
            }
        });
        action.put("right_released", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                if(Character.dirX == Character.movementSpeed){
=======
                if(Character.dirX == Game.character.movementSpeed){
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
                    Character.dirX = 0;
                    Character.isMovingX = false;
                }
            }
        });
        action.put("up_released", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                if(Character.dirY == -Character.movementSpeed){
=======
                if(Character.dirY == -Game.character.movementSpeed){
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
                    Character.dirY = 0;
                    Character.isMovingY = false;
                }
            }
        });
        action.put("down_released", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                if(Character.dirY == Character.movementSpeed){
=======
                if(Character.dirY == Game.character.movementSpeed){
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
                    Character.dirY = 0;
                    Character.isMovingY = false;
                }
            }
        });

        //dodatkowe akcje wcisniecia klawisza
        action.put("place_bomb", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Game.character.placeBomb();
<<<<<<< HEAD
=======
                System.out.println("bomb placed");
>>>>>>> 12b87d77863e8f3ea5013a8825599a821b710802
            }
        });

        action.put("pause", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                //pause
                System.out.println("game paused");
            }
        });

    }
}

