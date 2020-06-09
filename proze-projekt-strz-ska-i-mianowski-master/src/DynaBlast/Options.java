package DynaBlast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** class creating the Options window, with buttons that set toggles the sounds and music on or off
 * extends JFrame and implements ActionListener for reacting to clicking buttons
 */

public class Options extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    /** size of the frame */
    public static Dimension size = new Dimension(810,480);
    /** name of the frame */
    public static String name = "Options";

    /** buttons existing in options window */
    private static JButton ReturnToMenu;
    private static JToggleButton Sound;
    private static JToggleButton Music;

    /** specifies constraints for components that are laid out using the GridBagLayout class */
    static GridBagConstraints c;

    /** basic constructor of the class */
    public Options(){};

    /** Main function of the class
     * sets all important parameters like name, size, default close operation
     * as well as layout type, creates buttons and makes them respond to pressing them.
     * Also sets gridbag parameters
     */
    public void create1(JFrame frame){
        c = new GridBagConstraints();
        c.weightx = 0.5;
        c.fill = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        JLabel sound = new JLabel("Sound");
        JLabel music = new JLabel("Music");
        frame.pack();
        frame.setSize(size);
        frame.setLocation(400, 50);
        frame.setName(name);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.add(sound);
        frame.add(music);
        frame.setVisible(true);
        Options.CreateSoundButton(frame);
        Options.CreateMusicButton(frame);
        Options.CreateReturnToMenuButton(frame);
        ReturnToMenu.addActionListener(this);
        Sound.addActionListener(this);
        Music.addActionListener(this);
    }

    /** Function creates the Return to Menu button,
     *  First, creates new JButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets the relative location to other buttons
     */
    public static void CreateReturnToMenuButton(JFrame frame){
        JButton ReturnToMenu = new JButton("Return to menu");
        ReturnToMenu.setFont(new Font("font",Font.PLAIN,25));
        Options.ReturnToMenu = ReturnToMenu;
        c.gridy = 3;
        c.insets = new Insets(180,0,0,550);
        frame.add(ReturnToMenu,c);
    }

    /** Function creates the Sound button,
     *  First, creates new JToggleButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets the relative location to other buttons
     */
    public static void CreateSoundButton(JFrame frame){
        JToggleButton Sound = new JToggleButton("On");
        Options.Sound = Sound;
        c.gridy = 1;
        c.insets = new Insets(100,100,0,0);
        frame.add(Sound,c);
    }

    /** Function creates the Music button,
     *  First, creates new JToggleButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets the relative location to other buttons
     */
    public static void CreateMusicButton(JFrame frame){
        JToggleButton Music = new JToggleButton("On");
        Options.Music = Music;
        c.gridy = 2;
        c.insets = new Insets(30,100,0,0);
        frame.add(Music,c);
    }

    /** specifies what action are to be performed during pressing specific buttons */
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o == ReturnToMenu){
            if(Menu.sound){
                Sounds.play(Sounds.ButtonClick);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getDefaultCloseOperation();
        }

        else if (o == Sound){
            if(Sound.isSelected()){
                Sound.setText("Off");
                Menu.sound = false;
                Game.sound = false;
            }
            else{
                Sound.setText("On");
                Menu.sound = true;
                Game.sound = true;
                Sounds.play(Sounds.ButtonClick);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Sounds.audioClip.close();
            }
        }
        else if (o == Music){
            Sounds.audioClip.close();
            if(Music.isSelected()){
                Sounds.audioClip.close();
                if (Menu.sound){
                    Sounds.play(Sounds.ButtonClick);
                }
                Music.setText("Off");
                Game.music = false;
                Menu.music = false;
            }
            else{
                if (Menu.sound){
                    Sounds.play(Sounds.ButtonClick);
                }
                Music.setText("On");
                Game.music = true;
                Menu.music = true;
                Sounds.audioClip.close();
                Sounds.play(Sounds.MenuMusic);
            }
        }
    }

}
