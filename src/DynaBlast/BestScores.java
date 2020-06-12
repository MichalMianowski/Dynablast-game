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
public class BestScores extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    /** size of the Best scores window */
    public static Dimension size = new Dimension(1080,640);
    /** name of the window */
    public static String name = "Best Scores";

    /** button, that is set on the window */
    private static JButton ReturnToMenu;
    /** specifies constraints for components that are laid out using the GridBagLayout class */
    static GridBagConstraints c;

    public static JFrame frame1;

    /** label to present list of best scores */
    private JLabel highScoresLabel = new JLabel();

    /** manager of best scores*/
    private BestScoresManager bestScoresManager = new BestScoresManager();

    /** basic constructor of the class *
     * sets it's size and location
     */
    public BestScores(JFrame frame){
        setPreferredSize(size);
        setLocation(400, 150);
        BestScores.frame1 = frame;
    };

    /** main function of the class
     * sets all important parameters like name, size, default close operation
     * as well as layout type and creates buttons
     */
    public void go(){
        c = new GridBagConstraints();
        c.weightx = 0.5;
        c.fill = GridBagConstraints.PAGE_END;
        pack();
        setSize(1080,640);
        setLocation(400, 150);
        setName(name);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new GridBagLayout());

        showScores();
        BestScores.CreateReturnToMenuButton(this);
        ReturnToMenu.addActionListener(this);

        setVisible(true);
    }

    /**
     * Function to present best scores in label highScoresLabel
     * presentation format use html structure to make text with new lines
     */
    private void showScores() {
        c.anchor = GridBagConstraints.PAGE_START;
        highScoresLabel.setFont(new Font("TimesRoman", Font.BOLD, 28));
        highScoresLabel.setHorizontalAlignment(JLabel.CENTER);
        c.gridwidth = 3;
        c.gridheight = 5;
        c.gridy = 1;
        c.gridx = 1;
        c.insets = new Insets(0,0,0,0);
        add(highScoresLabel, c);

        bestScoresManager.loadHighScores();
        highScoresLabel.setText("&nbsp;&nbsp;&nbsp;&nbsp; High Scores<br/>");
        bestScoresManager.bestScoresList.forEach(record -> {
            highScoresLabel.setText(highScoresLabel.getText() + "<br/>" + (bestScoresManager.bestScoresList.indexOf(record)+1) + ". " + record.getName() + "....." + record.getScore());
        });
        highScoresLabel.setText("<html>" + highScoresLabel.getText() + "</html>");
    }

    /** Function creates the Return to menu button,
     *  First, creates new JButton with appropriate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets its size and makes it response to pressing it
     */
    public static void CreateReturnToMenuButton(JFrame frame){
        c.anchor = GridBagConstraints.PAGE_END;
        JButton ReturnToMenu = new JButton("Return to menu");
        ReturnToMenu.setFont(new Font("font",Font.PLAIN,25));
        BestScores.ReturnToMenu = ReturnToMenu;
        ReturnToMenu.setPreferredSize(new Dimension(250,30));
        c.gridy = 9;
        c.gridx = 3;
        c.insets = new Insets(100,0,0,0);
        frame.add(ReturnToMenu,c);
    }

    /** specifies what actions are to be performed after pressing buttons */
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o == ReturnToMenu){
            this.dispose();
            frame1.setVisible(true);
        }
    }
}
