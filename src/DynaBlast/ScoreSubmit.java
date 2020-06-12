package DynaBlast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreSubmit extends JFrame implements ActionListener {
    static GridBagConstraints c;
    static String name;

    private static JButton button;
    static JTextField field;

    int score;
    boolean isRanked;
    BestScoresManager bestScoresManager = new BestScoresManager();


    public ScoreSubmit(int newScore){
        BestScoresManager bestScoresManager = new BestScoresManager();
        bestScoresManager.loadHighScores();
        score = newScore;
    }

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

    public void createButton(JPanel panel){
        button = new JButton();
        button.setText("Submit");
        c.gridy = 4;
        c.insets = new Insets(20, 0, 0, 0);
        panel.add(button,c);
    }

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
                BestScores endGameBestScores = new BestScores();
                endGameBestScores.frame = this;
                endGameBestScores.go();
                //System.exit(1);
            }

            //Configurations.SubmitScore();
            //System.exit(1);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
