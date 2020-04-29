package DynaBlast;

import javax.swing.*;
import java.awt.event.*;

public class ControlModule {
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
                Character.dirX = -Game.character.movementSpeed;
            }
        });
        action.put("right", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Character.isMovingX = true;
                Character.dirX = Game.character.movementSpeed;
            }
        });
        action.put("up", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Character.isMovingY = true;
                Character.dirY = -Game.character.movementSpeed;
            }
        });
        action.put("down", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Character.isMovingY = true;
                Character.dirY = Game.character.movementSpeed;
            }
        });

        //akcje puszczenia klawisza
        action.put("left_released", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(Character.dirX == -Game.character.movementSpeed){
                    Character.dirX = 0;
                    Character.isMovingX = false;
                }
            }
        });
        action.put("right_released", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(Character.dirX == Game.character.movementSpeed){
                    Character.dirX = 0;
                    Character.isMovingX = false;
                }
            }
        });
        action.put("up_released", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(Character.dirY == -Game.character.movementSpeed){
                    Character.dirY = 0;
                    Character.isMovingY = false;
                }
            }
        });
        action.put("down_released", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if(Character.dirY == Game.character.movementSpeed){
                    Character.dirY = 0;
                    Character.isMovingY = false;
                }
            }
        });

        //dodatkowe akcje wcisniecia klawisza
        action.put("place_bomb", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Game.character.placeBomb();
                System.out.println("bomb placed");
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

