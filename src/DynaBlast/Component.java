package DynaBlast;

import java.applet.*;
import javax.swing.*;
import java.awt.*;

public class Component extends Applet implements Runnable{
    private static final long serialVersionUID = 1L;
    private static int pixelSize = 2;

    public static Dimension size = new Dimension(860,680);
    public static Dimension pixel = new Dimension(size.width / pixelSize, size.height / pixelSize);
    public static String name = "Dyna Blaster - Escape from jail";
    public static boolean isRunning = false;

    private Image screen;

    public static Level level;
    public static Character character;

    public Component() {
        setPreferredSize(size);
    }

    public void start() {
        new Tile();    //load images
        level = new Level();
        character = new Character(Tile.male_stripes);

        isRunning = true;
        new Thread(this).start();
    }

    public void stop() {
        isRunning = false;
    }

    public static void main(String args[]){
        Component component = new Component();

        JFrame frame = new JFrame(name);
        frame.add(component);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        component.start();
    }

    public void tick(){

    }
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

    public void genBackground(Graphics g){
        //general background
        g.setColor(new Color(51,51,51)); //cool grey color 3x51
        g.fillRect(0,0,screen.getWidth(null),screen.getHeight(null));
        //jail floor (platform background)
        g.setColor(new Color(147, 139, 117));
        g.fillRect(20,20,Tile.tileSize * 15,Tile.tileSize * 15);
    }
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
