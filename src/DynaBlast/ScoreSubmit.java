/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JFrame class to add Player's name and submit score
 */
public class ScoreSubmit extends JFrame implements ActionListener {
    /** GridBagConstraints to order elements */
    static GridBagConstraints c;
    /** store name of Player */
    static String name;

    /** Jbutton to submit Player's name */
    private static JButton button;
    /** field to write down Player's name */
    static JTextField field;

    /** store points of score */
    int score;
    /** boolean "is score good enough to be added to high scores" */
    boolean isRanked;
    /** manager of best scores */
    BestScoresManager bestScoresManager;

    /**
     * constructor of this JFrame
     * creates best scores manager
     *
     * @param newScore - new score to check and eventually add
     */
    public ScoreSubmit(int newScore){
        bestScoresManager = new BestScoresManager();
        bestScoresManager.loadHighScores();
        score = newScore;
    }

    /**
     * manage submitting new score
     *
     * @param frame
     */
    public void submitScore(JFrame frame) {
        Game.game = false;
        Menu.frame1.dispose();
        c = new GridBagConstraints();
        c.weightx = 0.5;
        c.fill = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel label1 = new JLabel("Enter your name to be remembered at Best Scores");
        c.gridy = 1;
        c.insets = new Insets(10, 0, 0, 0);
        panel.add(label1, c);

        JLabel label2 = new JLabel("Your score: " + Character.score);
        c.gridy = 2;
        c.insets = new Insets(10, 0, 0, 0);
        panel.add(label2, c);

        field = new JTextField(20);
        field.setBounds(50, 100, 200, 30);
        c.gridy = 3;
        c.insets = new Insets(15, 0, 0, 0);
        panel.add(field, c);

        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(panel);
        createButton(panel);
        button.addActionListener(this);
        frame.setVisible(true);
    }

    /** create button to submit */
    public void createButton(JPanel panel){
        button = new JButton();
        button.setText("Submit");
        c.gridy = 4;
        c.insets = new Insets(20, 0, 0, 0);
        panel.add(button,c);
    }

    /**
     * manage reaction to click submit button
     * check the score and eventually add it to high scores
     */
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o == button) {
            if (Menu.sound) {
                Sounds.play(Sounds.ButtonClick);
            }
            name = field.getText();
            Score newScore = new Score(name, score);
            isRanked = bestScoresManager.isScoreRanked(newScore);
            if(isRanked) {
                bestScoresManager.addNewHighScore(newScore);
                this.setVisible(false);
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            BestScores endGameBestScores = new BestScores(this);
//                BestScores.frame = this;
            endGameBestScores.go();
        }
    }
}
