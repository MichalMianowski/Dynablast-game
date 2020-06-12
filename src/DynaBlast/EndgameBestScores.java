/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Class creating the Best Scores window, where it's possible
 *  to see up to 10 best scores achieved in the game.
 *  Class extends JFrame and implements ActionListener, to react
 *  to pressing buttons.
 */
public class EndgameBestScores extends BestScoresTableAbs {

    /**
     * basic constructor of the class *
     * sets it's size and location
     *
     * @param frame
     */
    public EndgameBestScores(JFrame frame) {
        super(frame);
    }

    /** Function creates the Return to menu button,
     *  First, creates new JButton with appropriate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets its size and makes it response to pressing it
     */
    public void CreateExitButton(JFrame frame){
        buttonText = "End Game";
        super.CreateExitButton(frame);
    }

    /** specifies what actions are to be performed after pressing buttons */
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o == ReturnToMenu){
            System.exit(0);
        }
    }
}