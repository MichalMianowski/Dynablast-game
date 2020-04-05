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
        frame. setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        component.start();
    }

    public void tick(){

    }
    public void render(){
        Graphics g = screen.getGraphics();
        g.setColor(new Color(51,51,51)); //cool grey color 3x51
        g.fillRect(0,0,screen.getWidth(null),screen.getHeight(null));
        g.setColor(new Color(197, 206, 205)); //cool grey color 3x51
        g.fillRect(20,20,Tile.tileSize * 15,Tile.tileSize * 15);

//        g.setColor(new Color(204,255,255)); //cool grey color 3x51
        level.render(g);
        character.render(g);
        level.enemies.forEach((en) -> en.render(screen.getGraphics()));

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
}
