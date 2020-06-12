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
    /** frame, on which the window is being created */
    //public static JFrame frame;
    /** specifies constraints for components that are laid out using the GridBagLayout class */
    static GridBagConstraints c;

    public static JFrame frame1;

    JLabel highScoresLabel = new JLabel();

    BestScoresManager bestScoresManager = new BestScoresManager();

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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2,1));
        add(highScoresLabel);
        highScoresLabel.setFont(new Font("TimesRoman", Font.BOLD, 32));
        highScoresLabel.setHorizontalAlignment(JLabel.CENTER);
        highScoresLabel.setVerticalAlignment(JLabel.CENTER);
        BestScores.CreateReturnToMenuButton(this);
        ReturnToMenu.addActionListener(this);
        showScores();
        setVisible(true);
    }

    private void showScores() {
        int i =0;
        bestScoresManager.loadHighScores();
        bestScoresManager.bestScoresList.forEach(record -> {
            highScoresLabel.setText(highScoresLabel.getText() + "<br/>" + (bestScoresManager.bestScoresList.indexOf(record)+1) + ". " + record.getName() + "....." + record.getScore());
        });
        highScoresLabel.setText("<html>" + highScoresLabel.getText() + "</html>");
    }

    /** Function creates the Return to menu button,
     *  First, creates new JButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets its size and makes it response to pressing it
     */
    public static void CreateReturnToMenuButton(JFrame frame){
        JButton ReturnToMenu = new JButton("Return to menu");
        ReturnToMenu.setFont(new Font("font",Font.PLAIN,25));
        BestScores.ReturnToMenu = ReturnToMenu;
        c.gridy = 0;
        c.insets = new Insets(500,0,0,800);
        frame.add(ReturnToMenu);
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
