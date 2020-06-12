package DynaBlast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class creating the initial menu of game
 * class extends JFrame and implements ActionListener for buttons
 * Can also create and run functions of other classes if specific button is pressed
 */
public class Menu extends JFrame implements ActionListener{
    /** specifies whether menu sounds (button clicks) should be played */
    public static boolean sound;
    /** specifies whether menu music should be played */
    public static boolean music;

    /** Buttons that exist in initial menu */
    private JButton NewGame;
    private JButton Options;
    private JButton BestScores;
    private JButton Exit;
    static Game game;
    static JFrame frame1;
    static JFrame frame2;
    static int levelNumber;
    static int Difficulty;


    /** specifies constraints for components that are laid out using the GridBagLayout class */
    GridBagConstraints c;

    /** In constructor the menu window is created, its size and location are being set, along with background image
     * along with the panel, on which buttons can be added, as well as
     */
    public Menu() {
        super("DynaBlaster");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setPreferredSize(new Dimension(1080, 640));
        setSize(1080,640);
        setLocation(400, 150);
        setResizable(true);

        ImageIcon tlo = new ImageIcon("res/Images/background.png");
        setContentPane(new JLabel(tlo));
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        music = true;
        Sounds.play(Sounds.MenuMusic);
    }

    /** Function creates the NEW GAME button,
     *  First, creates new JButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets its size and makes it response to pressing it
     */
    public void CreateNewGameButton(){
        JButton NewGame = new JButton("New game");
        NewGame.setFont(new Font("font",Font.PLAIN,25));
        this.NewGame = NewGame;
        NewGame.addActionListener(this);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(180,0,0,0);
        add(NewGame, c);
    }

    /** Function creates the OPTIONS button,
     *  First, creates new JButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets its size and makes it response to pressing it
     */
    public void CreateOptionsButton(){
        JButton Options = new JButton("Options");
        Options.setFont(new Font("font",Font.PLAIN,25));
        this.Options = Options;
        Options.addActionListener(this);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(50,0,0,0);
        add(Options, c);
    }

    /** Function creates the BEST SCORES button,
     *  First, creates new JButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets its size and makes it response to pressing it
     */
    public void CreateBestScoresButton(){
        JButton BestScores = new JButton("Best scores");
        BestScores.setFont(new Font("font",Font.PLAIN,25));
        this.BestScores = BestScores;
        BestScores.addActionListener(this);
        c.weightx = 0.5;
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 2;
        add(BestScores, c);
    }

    /** Function creates the EXIT button,
     *  First, creates new JButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets its size and makes it response to pressing it
     */
    public void CreateExitButton(){
        JButton Exit = new JButton("Exit");
        Exit.setFont(new Font("font",Font.PLAIN,25));
        this.Exit = Exit;
        Exit.addActionListener(this);
        c.weightx = 1;
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 3;
        add(Exit, c);
    }

    /** fucntion that specifies what actions are to be performed after pressing specific buttons */
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        frame1 = new JFrame();
        frame2 = new JFrame();
        /** if "New game" is pressed, create gameplay screen */
        if (o == NewGame) {
            if (Menu.sound) {
                Sounds.play(Sounds.ButtonClick);
            }
            setVisible(false);
            Sounds.audioClip.close();
            game = new Game(Game.music);
            frame1 = new JFrame(Game.name);
            JFrame finalFrame = frame1;
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Do(finalFrame);
                }
            });
            frame1.setLayout(new BorderLayout());
            frame1.add(game);
            frame1.setSize(Game.size);
            frame1.setResizable(true);
            frame1.setLocationRelativeTo(null);
            frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            if (Menu.sound) {
                Sounds.play(Sounds.ButtonClick);
            }
            Object[] difficulty = {"Easy",
                    "Medium",
                    "Hard"};
            int a = JOptionPane.showOptionDialog(frame1,
                    "Choose difficulty level",
                    "Difficulty",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    difficulty,
                    difficulty[2]);
            levelNumber = 1;
            Level.enemies.clear();
            Level.level = Level.LevelLocation1;
            if (a == JOptionPane.YES_OPTION) {
                Configurations.loadDifficulty(Configurations.Difficulty1);
                Difficulty = 1;
            }
            else if (a == JOptionPane.NO_OPTION) {
                Configurations.loadDifficulty(Configurations.Difficulty2);
                Difficulty = 2;
            }
            else if (a == JOptionPane.CANCEL_OPTION) {
                Configurations.loadDifficulty(Configurations.Difficulty3);
                Difficulty = 3;
            }
            game.start();
            frame1.setVisible(true);
            frame1.addWindowListener(new MyWindowsListener());
        }
        else if (o == Options) {
            if (Menu.sound) {
                Sounds.play(Sounds.ButtonClick);
            }
            setVisible(false);
            JFrame finalFrame = frame2;
            SwingUtilities.invokeLater(() -> Do(finalFrame));
            Options options = new Options();
            options.create1(frame2);
        }
        else if (o == BestScores) {
            if (Menu.sound) {
                Sounds.play(Sounds.ButtonClick);
            }
            setVisible(false);
            JFrame finalFrame = frame2;
            SwingUtilities.invokeLater(() -> Do(finalFrame));
            BestScores bestScores = new BestScores();
            bestScores.frame = frame2;
            bestScores.go();
        }
        /** if "Exit" is pressed, close all windows and exit game */
        else if (o == Exit) {
            frame1 = new JFrame();
            if (Menu.sound) {
                Sounds.play(Sounds.ButtonClick);
            }
            int a = JOptionPane.showConfirmDialog(frame1, "            Are you sure?", "Exit", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                if (Menu.sound) {
                    Sounds.play(Sounds.ButtonClick);
                }
            }
        }
    }

    /** function that changes default window closing action for desired one
     *
     * @param frame frame to which the action should be applied
     */
    private void Do(JFrame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(true);
            }
        });
    }

    public void ReturnToMenu(){
        setVisible(true);
    }
}