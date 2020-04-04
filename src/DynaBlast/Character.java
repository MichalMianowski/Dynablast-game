package DynaBlast;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Character extends Creatures {
    public static BufferedImage charImg;

    public Character(int width, int height){
        setBounds(x = 40, y = 40, width, height);
        try {
            Character.charImg = ImageIO.read(new File("res/StripesMale.png"));
        } catch (Exception e) { }
    }


    public void tick(){

    }

    public void render(Graphics g){
        g.drawImage(charImg, (int)x, (int)y, null);
//        g.setColor(new Color(200,200,200));
//        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }

}
