package DynaBlast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/** Class that creates gameplay screen
 * class extends JPanel and implements Runnable for gaming performance
 * creates the level layout with all tiles and enemies, then the character model
 */
public class Game extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    /**
     * Parameters of the gamescreen
     *
     * @param pixelSize size of pixel in-game
     * @param size size of the game window
     * @param pixel
     * @param name name of the game window
     * @param isRunning specifies whether the game is running or not
     * @param music specifies whether the game music should be played or not
     * @param sound specifies whether the game sounds should be played or not
     */
    private static int pixelSize = 2;
    static char color;
    public static Dimension size = new Dimension(860, 680);
    public static Dimension pixel = new Dimension(size.width / pixelSize, size.height / pixelSize);
    public static String name = "Dyna Blaster - Escape from jail";
    public static volatile boolean isRunning = false;
    public static boolean music = true;
    public static boolean sound = true;
    int counter = 0;
    static int BeginPoints;
    static Graphics g;
    static boolean game = true;
    int WhichLevel;
    String WhatDifficulty;
    static boolean Prologue = true;
    static boolean Restart = false;
    static boolean death = false;
    GridBagConstraints c;
    static Thread thread;

    /**
     * On this, the graphics are being drawn
     */
    private BufferedImage screen;

    /**
     * Class instances that are to be co-created along with game window
     */
    public static Level level;
    public static Character character;

    /**
     * Constructor of class, that also sets size of the window
     */
    public Game(boolean music) {
        if (music) {
            Sounds.play(Sounds.GameMusic);
        }
        ControlModule.useKeyboard(this);
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Function that starts (generates) the game infrastructure along with enemies and character
     */
    public void start() {
        new Tile();    //load images
        level = new Level();
        character = new Character(Tile.male_orange, Configurations.lives);
        isRunning = true;
        BeginPoints = Character.score;
        game = true;
    }


    /**
     * Function that stops the game
     */
    public static void stop() {
        isRunning = !isRunning;
    }

    /**
     * function that makes clock tick and therefore change the state of every enemy, character and for the level itself
     */
    public void tick() {
        Level.enemies.forEach(Enemy::tick);
        character.tick();
        level.tick();
        counter++;
        if (counter == 175) {
            Level.timeLeft -= 1;
            counter = 0;
        }
        if (Level.timeLeft == Configurations.time - 3) {
            Prologue = false;
            Restart = false;
        }
        if (Level.timeLeft == -1) {
            character.TimeRunOut();
            Level.timeLeft = Configurations.time;
        }
    }

    /**
     * Function that draws the game objects: background, level layout, enemies, bombs, explosions and player
     *
     * @param 'g' Graphic to which render images
     */
    public void render(Graphics2D g) {
        g.clearRect(0,0,size.width,size.height);
        float sx =(1f+(getSize().width-size.width)/(float)size.width);
        float sy =(1f+(getSize().height-size.height)/(float)size.height);
        g.scale(sx,sy);
        genBackground(g);
        if (!Prologue && !Restart && !death) {
            level.render(g);
            Level.bombs.forEach((bomb) -> bomb.render(g));
            Level.enemies.forEach((en) -> en.render(g));
            character.render(g);
            Level.explosions.forEach((explosion) -> explosion.render(g));
        }

        gameplayInfo(g);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        render((Graphics2D)(g));
        g.dispose();
    }

    @Override
    public void addNotify(){
        super.addNotify();
    }
    /**
     * Function that "runs" the game, so ticks the clock for every object in-game and renders them
     */
    @Override
    public void run() {
        while (game) {
            if (isRunning) {
                tick();
                repaint();
                try {
                    Thread.sleep(5);
                } catch (Exception ignored) {
                }
            }
        }
    }

    /**
     * Functions painting the background of gamescreen
     */
    public void genBackground(Graphics g) {
        //general background
        if (Prologue) {
            if (Level.level == Level.LevelLocation1) {
                WhichLevel = 1;
            } else if (Level.level == Level.LevelLocation2) {
                WhichLevel = 2;
            } else if (Level.level == Level.LevelLocation3) {
                WhichLevel = 3;
            } else if (Level.level == Level.LevelLocation4) {
                WhichLevel = 4;
            } else if (Level.level == Level.LevelLocation5) {
                WhichLevel = 5;
            }

            if (Configurations.timePoints == 3) {
                WhatDifficulty = "Easy";
            } else if (Configurations.timePoints == 6) {
                WhatDifficulty = "Medium";
            } else if (Configurations.timePoints == 10) {
                WhatDifficulty = "Hard";
            }

            g.setColor(new Color(0, 0, 0));
            g.fillRect(0, 0, size.width, size.height);
            g.setColor(new Color(255, 255, 255));
            g.setFont(new Font("TimesRoman", Font.BOLD, 16));
            g.drawString("Level " + String.format("%01d", WhichLevel), 190, 160);
            g.drawString(WhatDifficulty, 197, 180);
        }
        else if (Restart) {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(0, 0, size.width, size.height);
            g.setColor(new Color(255, 255, 255));
            g.setFont(new Font("TimesRoman", Font.BOLD, 16));
            g.drawString("Remaining lives: " + String.format("%01d", character.getLives()), 150, 180);
        }
        else if (death) {
            g.setColor(new Color(0, 0, 0));
            g.fillRect(0, 0, size.width, size.height);
            g.setColor(new Color(255, 255, 255));
            g.setFont(new Font("TimesRoman", Font.BOLD, 16));
            g.drawString("This was your last chance,", 125, 180);
            g.drawString("criminal scum", 160, 200);
            if (Level.timeLeft <= -6) {
                submitScore();
            }
        }
        else {
            if (color == 'G') {
                g.setColor(new Color(175, 213, 170)); //cool grey color 3x51
            } else if (color == 'Y') {
                g.setColor(new Color(108, 145, 194));
            } else if (color == 'R') {
                g.setColor(new Color(226, 133, 110));
            }
            g.fillRect(0, 0, size.width, size.height);
            //jail floor (platform background)
            g.setColor(new Color(147, 139, 117));
            g.fillRect(20, 20, Tile.tileSize * 15, Tile.tileSize * 15);
        }
    }


    /** Function generating and drawing info about game parameters, such as time left, lives left and current score */
    public void gameplayInfo (Graphics g){
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("TimesRoman", Font.BOLD, 26));
        g.drawString("Time left:", 660, 80);
        g.drawString(Level.timeLeft / 60 + ":" + String.format("%02d", Level.timeLeft % 60), 660, 120);
        g.drawString("Lives left:", 660, 160);
        g.drawString("" + character.getLives(), 660, 200);
        g.drawString("Your score:", 660, 240);
        g.drawString("" + character.getScore() + " points", 660, 280);
    }

    public void submitScore(){
        game = false;
        Menu.frame1.dispose();
        c = new GridBagConstraints();
        c.weightx = 0.5;
        c.fill = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel label = new JLabel("Enter your name to be remembered at Best Scores");
        c.gridy = 1;
        c.insets = new Insets(100,0,0,0);
        panel.add(label);

        JTextField field = new JTextField();
        field.setBounds(50,100, 200,30);
        c.gridy = 2;
        c.insets = new Insets(150,0,0,0);
        panel.add(field);

        JButton button = new JButton();
        button.setText("Submit");
        c.gridy = 3;
        c.insets = new Insets(200,0,0,0);
        panel.add(button);

        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
    }
}

