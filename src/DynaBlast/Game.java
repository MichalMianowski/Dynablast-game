package DynaBlast;

import javax.swing.*;
import java.awt.*;

/** Class that creates gameplay screen
 * class extends JPanel and implements Runnable for gaming performance
 * creates the level layout with all tiles and enemies, then the character model
 */
public class Game extends JPanel implements Runnable{
    private static final long serialVersionUID = 1L;
    /** Parameters of the gamescreen
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
    public static Dimension size = new Dimension(860,680);
    public static Dimension pixel = new Dimension(size.width / pixelSize, size.height / pixelSize);
    public static String name = "Dyna Blaster - Escape from jail";
    public static boolean isRunning = false;
    public static boolean music = true;
    public static boolean sound = true;
    int k = 0;

    /** On this, the graphics are being drawn */
    private Image screen;

    /** Class instances that are to be co-created along with game window */
    public static Level level;
    public static Character character;

    /** Constructor of class, that also sets size of the window*/
    public Game(boolean music) {
        if(music){
            Sounds.play(Sounds.GameMusic);
        }
        ControlModule.useKeyboard(this);
        setPreferredSize(size);
    }

    /** Function that starts (generates) the game infrastructure along with enemies and character */
    public void start() {
        new Tile();    //load images
        level = new Level();
        character = new Character(Tile.female_stripes, Configurations.lives);
        isRunning = true;
        new Thread( this).start();
    }


    /** Function that stops the game */
    public void stop() {
        isRunning = false;
    }

    /** function that makes clock tick and therefore change the state of every enemy, character and for the level itself*/
    public void tick(){
        Level.enemies.forEach(Enemy::tick);
        character.tick();
        level.tick();
        k++;
        if (k==122){
            Level.timeLeft -=1;
            k=0;
        }
        if (Level.timeLeft == -1){
            character.TimeRunOut();
            Level.timeLeft = Configurations.time;
        }
    }

    /** Function that draws the game objects: background, level layout, enemies, bombs, explosions and player
     *
     * @param 'g' Graphic to which render images
     */
    public void render(){
        Graphics g = screen.getGraphics();
        genBackground(g);

        level.render(g);
        Level.bombs.forEach((bomb) -> bomb.render(screen.getGraphics()));
        Level.enemies.forEach((en) -> en.render(screen.getGraphics()));
        character.render(g);
        Level.explosions.forEach((explosion) -> explosion.render(screen.getGraphics()));

        gameplayInfo(g);
        g = getGraphics();
        g.drawImage(screen, 0, 0, size.width, size.height, 0, 0, pixel.width, pixel.height, null);
        g.dispose();
    }

    /** Function that "runs" the game, so ticks the clock for every object in-game and renders them*/
    public void run(){
        screen = createVolatileImage(pixel.width, pixel.height); //Volatile to give access to GPU

        while(isRunning) {
            tick();
            render();
            try{
                Thread.sleep(5);
            } catch(Exception ignored) { }
        }
    }

    /** Functions painting the background of gamescreen */
    public void genBackground(Graphics g){
        //general background
        if (color == 'G') {
            g.setColor(new Color(175, 213, 170)); //cool grey color 3x51
        }
        else if (color == 'Y'){
            g.setColor(new Color(108, 145, 194));
        }
        else if (color == 'R'){
            g.setColor(new Color(226, 133, 110));
        }
        g.fillRect(0,0,screen.getWidth(null),screen.getHeight(null));
        //jail floor (platform background)
        g.setColor(new Color(147, 139, 117));
        g.fillRect(20,20,Tile.tileSize * 15,Tile.tileSize * 15);
    }

    /** Function generating and drawing info about game parameters, such as time left, lives left and current score */
    public void gameplayInfo(Graphics g){
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("TimesRoman", Font.BOLD, 13));

        g.drawString("Time left:", 330, 40);
        g.drawString(Level.timeLeft /60 + ":" + String.format("%02d", Level.timeLeft %60), 330, 60);
        g.drawString("Lives left:", 330, 80);
        g.drawString("" + character.getLives(), 330, 100);
        g.drawString("Your score:", 330, 120);
        g.drawString("" + character.getScore() + " points", 330, 140);
    }

}
