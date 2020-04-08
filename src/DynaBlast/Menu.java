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

    /** classes that have to be created after pressing specific buttons */
    Component component;

    /** In constructor, menu window is created along with the buttons */
    public Menu() {
        /** setting basic actions of window such as: exitting on close
         * as well as parameters, such as size and background image of window
         * Also creates panel, to which the buttons have to be added
         */
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

        /** Creating and setting "New game" button */
        JButton NewGame = new JButton("New game");
        NewGame.setFont(new Font("font",Font.PLAIN,25));
        this.NewGame = NewGame;
        add(NewGame);

        NewGame.setLocation(450,100);
        NewGame.setPreferredSize(new Dimension(500,50));
        NewGame.addActionListener(this);


        /** Creating and setting "Options" button */
        JButton Options = new JButton("Options");
        Options.setFont(new Font("font",Font.PLAIN,25));
        this.Options = Options;
        add(Options);

        Options.setPreferredSize(new Dimension(500,50));
        Options.addActionListener(this);

        /** Creating and setting "Best scores" button */
        JButton BestScores = new JButton("Best scores");
        BestScores.setFont(new Font("font",Font.PLAIN,25));
        this.BestScores = BestScores;
        add(BestScores);

        BestScores.setPreferredSize(new Dimension(500,50));
        BestScores.addActionListener(this);

        /** Creating and setting "Exit" button */
        JButton Exit = new JButton("Exit");
        Exit.setFont(new Font("font",Font.PLAIN,25));
        this.Exit = Exit;
        add(Exit);

        Exit.setPreferredSize(new Dimension(500,50));
        Exit.addActionListener(this);

        setVisible(true);
    }

    /** fucntion that specifies what actions are to be performed after pressing specific buttons */
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        /** if "New game" is pressed, create gameplay screen */
        if(o == NewGame) {
            component = new Component();
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
        /** if "Exit" is pressed, close all windows and exit game */
        } else if(o == Exit) {
            System.exit(0);
        }
    }
}