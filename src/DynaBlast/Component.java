package DynaBlast;

import javax.swing.*;
import java.awt.*;

/** Class that creates gameplay screen
 * class extends JPanel and implements Runnable for gaming performance
 * creates the level layout with all tiles and enemies, then the character model
 */
public class Component extends JPanel implements Runnable{
    private static final long serialVersionUID = 1L;
    /** @param pixelSize size of pixel in-game */
    private static int pixelSize = 2;
    /** @param size size of the game window */
    public static Dimension size = new Dimension(860,680);

    public static Dimension pixel = new Dimension(size.width / pixelSize, size.height / pixelSize);
    /** @param name name of the game window */
    public static String name = "Dyna Blaster - Escape from jail";
    /** @param isRunning specifies whether the game is running or not */
    public static boolean isRunning = false;

    /** On this, the graphics are being drawn */
    private Image screen;

    /** Class instances that are to be co-created along with game window */
    public static Level level;
    public static Character character;

    /** Constructor of class, that also sets size of the window*/
    public Component() {
        setPreferredSize(size);
    }

    /** Function that starts (generates) the game infrastructure along with enemies and character */
    public void start() {
        new Tile();    //load images
        level = new Level();
        character = new Character(Tile.male_stripes);
        isRunning = true;
        new Thread( this).start();
    }

    /** Function that stops the game */
    public void stop() {
        isRunning = false;
    }

    /** Functions that updates the game's state
    */
    public void tick(){}

    /** Function that draws the game objects: background, level layout, enemies and player
     */
    public void render(){
        Graphics g = screen.getGraphics();
        genBackground(g);

        level.render(g);
        character.render(g);
        level.enemies.forEach((en) -> en.render(screen.getGraphics()));

        gameplayInfo(g);
        g = getGraphics();
        g.drawImage(screen, 0, 0, size.width, size.height, 0, 0, pixel.width, pixel.height, null);
        g.dispose();
    }

    /** Function that "runs" the game, makes the updating its state possible */
    public void run(){
        screen = createVolatileImage(pixel.width, pixel.height); //Volatile to give access to GPU

        while(isRunning) {
            tick();
            render();
            try{
                Thread.sleep(5);
            } catch(Exception e) { }
        }
    }

    /** Functions painting the background of gamescreen 
    *   @param 'g' Graphic to which render images
    */
    public void genBackground(Graphics g){
        //general background
        g.setColor(new Color(51,51,51)); //cool grey color 3x51
        g.fillRect(0,0,screen.getWidth(null),screen.getHeight(null));
        //jail floor (platform background)
        g.setColor(new Color(147, 139, 117));
        g.fillRect(20,20,Tile.tileSize * 15,Tile.tileSize * 15);
    }

    /** Function generating and drawing info about game parameters, such as time left, lives left and current score
    *   @param 'g' Graphic to which render images
    */
    public void gameplayInfo(Graphics g){
        g.setColor(new Color(220,220,220));
        g.setFont(new Font("TimesRoman", Font.BOLD, 13));

        g.drawString("Time left:", 330, 40);
        g.drawString(level.timeLeft/60 + ":" + String.format("%02d",level.timeLeft%60), 330, 60);
        g.drawString("Lives left:", 330, 80);
        g.drawString("" + character.getLives(), 330, 100);
        g.drawString("Your score:", 330, 120);
        g.drawString("" + character.getScore() + " points", 330, 140);
    }
   
}
