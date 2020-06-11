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
    public static Dimension size = new Dimension(1200,660);
    /** name of the frame */
    public static String name = "Options";

    /** buttons existing in options window */
    private static JButton ReturnToMenu;
    private static JToggleButton Sound;
    private static JToggleButton Music;
    private static JRadioButton Skin1;
    private static JRadioButton Skin2;
    private static JRadioButton Skin3;
    private static JRadioButton Skin4;

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
        c.fill = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        frame.setPreferredSize(size);
        JLabel sound = new JLabel("Sound");
        sound.setFont(sound.getFont().deriveFont(24.0f));
        JLabel music = new JLabel("Music");
        music.setFont(sound.getFont().deriveFont(24.0f));
        frame.pack();
        frame.setSize(size);
        frame.setLocation(400, 50);
        frame.setName(name);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.PAGE_START;
        c.insets = new Insets(18,0,0,100);
        c.gridy = 2;
        frame.add(sound,c);
        c.gridy = 3;
        c.insets = new Insets(30,0,0,100);
        frame.add(music,c);
        frame.setVisible(true);

        Options.CreateSkinButtons(frame);
        Options.CreateSoundButton(frame);
        Options.CreateMusicButton(frame);
        //Options.CreateReturnToMenuButton(frame);

        //ReturnToMenu.addActionListener(this);
        //Sound.addActionListener(this);
        //Music.addActionListener(this);
        Skin1.addActionListener(this);
        Skin2.addActionListener(this);
        Skin3.addActionListener(this);
        Skin4.addActionListener(this);
    }

    public static void CreateSkinButtons(JFrame frame){
        c.gridx = 2;
        c.insets = new Insets(10, 50,0,0);

        JRadioButton skin1 = new JRadioButton ("Male orange");
        JRadioButton skin2 = new JRadioButton ("Male stripes");
        JRadioButton skin3 = new JRadioButton ("Female orange");
        JRadioButton skin4 = new JRadioButton ("Female stripes");
        ButtonGroup bg = new ButtonGroup();
        bg.add(skin1);
        bg.add(skin2);
        bg.add(skin3);
        bg.add(skin4);

        skin1.setFont(new Font("font",Font.PLAIN,25));
        skin2.setFont(new Font("font",Font.PLAIN,25));
        skin3.setFont(new Font("font",Font.PLAIN,25));
        skin4.setFont(new Font("font",Font.PLAIN,25));

        Options.Skin1 = skin1;
        Options.Skin2 = skin2;
        Options.Skin3 = skin3;
        Options.Skin4 = skin4;

        c.gridy = 1;
        frame.add(skin1, c);
        c.gridy = 2;
        frame.add(skin2, c);
        c.gridy = 3;
        frame.add(skin3, c);
        c.gridy = 4;
        frame.add(skin4, c);
    }

    /** Function creates the Sound button,
     *  First, creates new JToggleButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets the relative location to other buttons
     */
    public static void CreateSoundButton(JFrame frame){
        c.fill = GridBagConstraints.CENTER;
        JToggleButton Sound = new JToggleButton("On");
        Sound.setPreferredSize(new Dimension(80,40));
        Options.Sound = Sound;
        c.gridy = 2;
        c.gridx = 1;
        c.insets = new Insets(100,10,0,100);
        frame.add(Sound,c);
    }

    /** Function creates the Music button,
     *  First, creates new JToggleButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets the relative location to other buttons
     */
    public static void CreateMusicButton(JFrame frame){
        c.fill = GridBagConstraints.CENTER;
        JToggleButton Music = new JToggleButton("On");
        Music.setPreferredSize(new Dimension(80,40));
        Options.Music = Music;
        c.gridy = 3;
        c.gridx = 1;
        c.insets = new Insets(30,10,0,100);
        frame.add(Music,c);
    }

    /** Function creates the Return to Menu button,
     *  First, creates new JButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets the relative location to other buttons
     */
    public static void CreateReturnToMenuButton(JFrame frame){
        c.fill =GridBagConstraints.PAGE_END;
        JButton ReturnToMenu = new JButton("Return to menu");
        ReturnToMenu.setFont(new Font("font",Font.PLAIN,25));
        Options.ReturnToMenu = ReturnToMenu;
        ReturnToMenu.setPreferredSize(new Dimension(400,100));
        c.gridy = 4;
        c.insets = new Insets(80,0,0,550);
        frame.add(ReturnToMenu,c);
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
