/**
 * Michal Mianowski & Piotr Strzaska
 */
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
    public static Dimension size = new Dimension(950,560);
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
    private static JLabel skin;

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
        frame.setPreferredSize(size);
        frame.pack();
        frame.setSize(size);
        frame.setLocation(400, 50);
        frame.setName(name);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        JLabel sound = new JLabel("Sound");
        sound.setFont(sound.getFont().deriveFont(24.0f));
        JLabel music = new JLabel("Music");
        music.setFont(sound.getFont().deriveFont(24.0f));
        panel2.add(sound,c);
        panel3.add(music,c);

        c.gridheight = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        frame.add(panel1,c);

        c.gridheight = 1;
        c.anchor = GridBagConstraints.CENTER;
        frame.add(panel2,c);

        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.RELATIVE;
        frame.add(panel3,c);
        frame.setVisible(true);

        Options.CreateSkinButtons(panel1);
        Options.CreateSoundButton(panel2);
        Options.CreateMusicButton(panel3);
        Options.CreateReturnToMenuButton(frame);

        ReturnToMenu.addActionListener(this);
        Sound.addActionListener(this);
        Music.addActionListener(this);
        Skin1.addActionListener(this);
        Skin2.addActionListener(this);
        Skin3.addActionListener(this);
        Skin4.addActionListener(this);

        if (Boot.character == Tile.male_orange){
            Skin1.setSelected(true);
        }
        if (Boot.character == Tile.male_stripes){
            Skin2.setSelected(true);
        }
        if (Boot.character == Tile.female_orange){
            Skin3.setSelected(true);
        }
        if (Boot.character == Tile.female_stripes){
            Skin4.setSelected(true);
        }
    }

    /**
     * function creating buttons to chose skin of character
     *
     * @param panel - JPanel where buttons will be placed
     */
    public static void CreateSkinButtons(JPanel panel){
        JRadioButton skin1 = new JRadioButton ("Male orange");
        JRadioButton skin2 = new JRadioButton ("Male stripes");
        JRadioButton skin3 = new JRadioButton ("Female orange");
        JRadioButton skin4 = new JRadioButton ("Female stripes");
        skin = new JLabel("Character skin");

        panel.setLayout(new GridBagLayout());
        ButtonGroup bg = new ButtonGroup();
        bg.add(skin1);
        bg.add(skin2);
        bg.add(skin3);
        bg.add(skin4);

        skin1.setFont(new Font("font",Font.PLAIN,25));
        skin2.setFont(new Font("font",Font.PLAIN,25));
        skin3.setFont(new Font("font",Font.PLAIN,25));
        skin4.setFont(new Font("font",Font.PLAIN,25));
        skin.setFont(new Font("font",Font.BOLD, 30));

        Options.Skin1 = skin1;
        Options.Skin2 = skin2;
        Options.Skin3 = skin3;
        Options.Skin4 = skin4;

        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(20,0,0,0);
        panel.add(skin1, c);
        c.gridy = 3;
        panel.add(skin2, c);
        c.gridy = 4;
        panel.add(skin3, c);
        c.gridy = 5;
        panel.add(skin4, c);
        c.gridy = 6;
        panel.add(skin, c);
    }

    /** Function creates the Sound button,
     *  First, creates new JToggleButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets the relative location to other buttons
     */
    public static void CreateSoundButton(JPanel panel){
        JToggleButton Sound = new JToggleButton("On");
        Sound.setPreferredSize(new Dimension(60,30));
        Options.Sound = Sound;
        c.gridy = 1;
        c.gridx = 1;
        c.insets = new Insets(0,10,0,0);
        panel.add(Sound,c);
    }

    /** Function creates the Music button,
     *  First, creates new JToggleButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets the relative location to other buttons
     */
    public static void CreateMusicButton(JPanel panel){
        JToggleButton Music = new JToggleButton("On");
        Music.setPreferredSize(new Dimension(60,30));
        Options.Music = Music;
        c.gridy = 2;
        c.gridx = 1;
        c.insets = new Insets(0,10,0,50);
        panel.add(Music,c);
    }

    /** Function creates the Return to Menu button,
     *  First, creates new JButton with appropiate name and font
     *  Then it adds the button to the window's panel
     *  At last it sets the relative location to other buttons
     */
    public static void CreateReturnToMenuButton(JFrame frame){
        c.anchor = GridBagConstraints.PAGE_END;
        JButton ReturnToMenu = new JButton("Return to menu");
        ReturnToMenu.setFont(new Font("font",Font.PLAIN,25));
        Options.ReturnToMenu = ReturnToMenu;
        ReturnToMenu.setPreferredSize(new Dimension(250,50));
        c.gridy = 5;
        c.gridx = 1;
        c.insets = new Insets(100,0,0,200);
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
            Menu.frame2.dispose();
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
        if (Skin1.isSelected()){
            Boot.character = Tile.male_orange;
        }
        if (Skin2.isSelected()){
            Boot.character = Tile.male_stripes;
        }
        if (Skin3.isSelected()){
            Boot.character = Tile.female_orange;
        }
        if (Skin4.isSelected()){
            Boot.character = Tile.female_stripes;
        }
    }

}
