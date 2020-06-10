/**
 * Michal Mianowski & Piotr Strzaska
 */

package DynaBlast;

import java.awt.*;
import java.awt.image.BufferedImage;

/** class that is responsible for running and drawing animations for all moving objects */
public class Graphic{

     /** specifies how fast the frames should change (higher value = frames changing slower) */
    private int speed;
    /** specifies how many frames there are in one animation cycle */
    private int frames;
    /** checks if the frames should be changed */
    private int index = 0;
    /** specifies what frame should be currently displayed */
    static int count = 0;


    /** first image of animation cycle */
    private BufferedImage img1;
    /** second image of animation cycle */
    private BufferedImage img2;
    /** third image of animation cycle */
    private BufferedImage img3;
    /** fourth image of animation cycle */
    private BufferedImage img4;
    /** currently displayed image */
    private BufferedImage currentImg;

    public boolean check = false;

    /** constructor of the class, that sets images for animation cycle as well as its speed and length of animation cycle
     *
     * @param speed specifies how fast animation should be played
     * @param img1 first image of animation cycle
     * @param img2 second image of animation cycle
     * @param img3 third image of animation cycle
     * @param img4 fourth image of animation cycle
     */
    public Graphic(int speed, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4){
        final float FACTOR  = 2f;
        this.speed = speed;
        int ScaleX1 = (int) (img1.getWidth()*FACTOR);
        int ScaleY1 = (int) (img1.getHeight()*FACTOR);
        Image image1 = img1.getScaledInstance(ScaleX1,ScaleY1,Image.SCALE_SMOOTH);
        this.img1 = new BufferedImage(ScaleX1,ScaleY1,BufferedImage.TYPE_INT_ARGB);
        this.img1.getGraphics().drawImage(image1,0,0,null);

        int ScaleX2 = (int) (img2.getWidth()*FACTOR);
        int ScaleY2 = (int) (img2.getHeight()*FACTOR);
        Image image2 = img2.getScaledInstance(ScaleX2,ScaleY2,Image.SCALE_SMOOTH);
        this.img2 = new BufferedImage(ScaleX2,ScaleY2,BufferedImage.TYPE_INT_ARGB);
        this.img2.getGraphics().drawImage(image2,0,0,null);

        int ScaleX3 = (int) (img3.getWidth()*FACTOR);
        int ScaleY3 = (int) (img3.getHeight()*FACTOR);
        Image image3 = img3.getScaledInstance(ScaleX3,ScaleY3,Image.SCALE_SMOOTH);
        this.img3 = new BufferedImage(ScaleX3,ScaleY3,BufferedImage.TYPE_INT_ARGB);
        this.img3.getGraphics().drawImage(image3,0,0,null);

        int ScaleX4 = (int) (img4.getWidth()*FACTOR);
        int ScaleY4 = (int) (img4.getHeight()*FACTOR);
        Image image4 = img4.getScaledInstance(ScaleX4,ScaleY4,Image.SCALE_SMOOTH);
        this.img4 = new BufferedImage(ScaleX4,ScaleY4,BufferedImage.TYPE_INT_ARGB);
        this.img4.getGraphics().drawImage(image4,0,0,null);

        frames = 4;
    }

    /** function that runs the animation, therefore makes it move */
    public void runAnimation(){
        index++;
        if (index > speed){
            index = 0;
            nextFrame();
        }
    }

    /** function that changes information about what image should be displayed */
    public void nextFrame(){
        if (count == 0){
            currentImg = img1;
        }
        if (count == 1){
            currentImg = img2;
        }
        if (count == 2){
            currentImg = img3;
        }
        if (count == 3){
            currentImg = img4;
        }

        count++;

        if (count>frames){
            count = 0;
        }
    }

    /**
     * function that changes information about what image should be displayed
     * @param enemy info which enemy will die
     */
    public void nextFrameOnce(Enemy enemy){
        if (count == 0){
            currentImg = img1;
        }
        else if (count == 1){
            currentImg = img2;
        }
        else if (count == 2){
            currentImg = img3;
        }
        else if (count == 3){
            currentImg = img4;
        }
        else if (count == 4){
            check = true;
        }
        else if (count == 5){
            enemy.dead = true;
            enemy.dying = false;
        }
        count++;
    }

    /** function that runs the animation of enemy death
     *
     * @param enemy which enemy will die
     */
    public void runAnimationOnce(Enemy enemy){
        index++;
        if (index > speed){
            index = 0;
            nextFrameOnce(enemy);
        }
    }

    /**  function that directly draws animation cycle
     *
     * @param g Graphic to which render images
     * @param x x-location of object for which the animation should be drawn
     * @param y y-location of object for which the animation should be drawn
     */
    public void drawAnimation(Graphics g, double x, double y){
        g.drawImage(currentImg, (int) x, (int) y, null);
    }

}
