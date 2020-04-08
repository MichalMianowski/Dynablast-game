package DynaBlast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class creating the initial menu of game
 * class extends JFrame and implements ActionListener for buttons
 * Can also create and run functions of other classes if specific button is pressed
 */
public class Menu extends JFrame implements ActionListener{
    /** Buttons that exist in initial menu */
    private JButton NewGame;
    private JButton Options;
    private JButton BestScores;
    private JButton Exit;

    /** In constructor the menu window is created, its size and location are being set, along with background image
     * along with the panel, on which buttons can be added
     */
    public Menu() {
        super("DynaBlaster");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1080, 640);
        setLocation(400, 150);

        ImageIcon tlo = new ImageIcon("res/background.png");
        setContentPane(new JLabel(tlo));

        JLabel jl = new JLabel("");
        jl.setFont(new Font("font", Font.PLAIN, 30));
        setLayout(new FlowLayout());

        JPanel jpanel = new JPanel();
        jpanel.setPreferredSize(new Dimension(700,470));

        jpanel.setBackground(new Color(0,0,0,0));
        jpanel.add(jl);

        add(jpanel);
        setVisible(true);
    }

    /** Main function of the class, that creates the whole functioning menu, by first creating its parts
     *  and then assembling them together
     */
    public static void main (String args[]){
        Menu menu = new Menu();
        menu.CreateNewGameButton();
        menu.CreateOptionsButton();
        menu.CreateBestScoresButton();
        menu.CreateExitButton();
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
        add(NewGame);

        NewGame.setLocation(450,100);
        NewGame.setPreferredSize(new Dimension(500,50));
        NewGame.addActionListener(this);
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
        add(Options);

        Options.setPreferredSize(new Dimension(500,50));
        Options.addActionListener(this);
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
        add(BestScores);

        BestScores.setPreferredSize(new Dimension(500,50));
        BestScores.addActionListener(this);
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
        add(Exit);

        Exit.setPreferredSize(new Dimension(500,50));
        Exit.addActionListener(this);

    }

    /** Fucntion that specifies what actions are to be performed after pressing specific buttons
    *   If New Game is pressed, create the new instance of the game
    *   If Exit is pressed, exit the game and close all windows
    */
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if(o == NewGame) {
            Component component = new Component();
            JFrame frame = new JFrame(component.name);
            frame.add(component);
            frame.pack();
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            component.start();
        } else if(o == Options) {

        } else if(o == BestScores) {
            
        } else if(o == Exit) {
            System.exit(0);
        }
    }
}