/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.awt.*;
import java.awt.image.BufferedImage;

/** class that is responsible for running and drawing animations for all moving objects */
public class Animation {

     /** specifies how fast the frames should change (higher value = frames changing slower) */
    private int speed;
    /** checks if the frames should be changed */
    private int index = 100;
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

    /** constructor of the class, that sets images for animation cycle as well as its speed and length of animation cycle
     *
     * @param speed specifies how fast animation should be played
     * @param imgSet set of animation cycle's images
     */
    public Animation(int speed, BufferedImage[] imgSet){
        final float FACTOR  = 2f;
        this.speed = speed;
        int ScaleX1 = (int) (imgSet[0].getWidth()*FACTOR);
        int ScaleY1 = (int) (imgSet[0].getHeight()*FACTOR);
        Image image1 = imgSet[0].getScaledInstance(ScaleX1,ScaleY1,Image.SCALE_SMOOTH);
        this.img1 = new BufferedImage(ScaleX1,ScaleY1,BufferedImage.TYPE_INT_ARGB);
        this.img1.getGraphics().drawImage(image1,0,0,null);

        int ScaleX2 = (int) (imgSet[1].getWidth()*FACTOR);
        int ScaleY2 = (int) (imgSet[1].getHeight()*FACTOR);
        Image image2 = imgSet[1].getScaledInstance(ScaleX2,ScaleY2,Image.SCALE_SMOOTH);
        this.img2 = new BufferedImage(ScaleX2,ScaleY2,BufferedImage.TYPE_INT_ARGB);
        this.img2.getGraphics().drawImage(image2,0,0,null);

        int ScaleX3 = (int) (imgSet[2].getWidth()*FACTOR);
        int ScaleY3 = (int) (imgSet[2].getHeight()*FACTOR);
        Image image3 = imgSet[2].getScaledInstance(ScaleX3,ScaleY3,Image.SCALE_SMOOTH);
        this.img3 = new BufferedImage(ScaleX3,ScaleY3,BufferedImage.TYPE_INT_ARGB);
        this.img3.getGraphics().drawImage(image3,0,0,null);

        int ScaleX4 = (int) (imgSet[3].getWidth()*FACTOR);
        int ScaleY4 = (int) (imgSet[3].getHeight()*FACTOR);
        Image image4 = imgSet[3].getScaledInstance(ScaleX4,ScaleY4,Image.SCALE_SMOOTH);
        this.img4 = new BufferedImage(ScaleX4,ScaleY4,BufferedImage.TYPE_INT_ARGB);
        this.img4.getGraphics().drawImage(image4,0,0,null);
    }

    /**
     * function that runs the animation, therefore makes it move
     *
     * @param creature - affected creature
     */
    public void tickAnimation(Creatures creature){
        index++;
        if (index > speed){
            index = 0;
            nextFrame(creature);
        }
    }

    /**
     * function that changes information about what image should be displayed
     * @param creature - affected creature
     */
    public void nextFrame(Creatures creature){
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
        else{
            count = -1;
        }

        count++;
    }

    /**
     * function that changes information about what image should be displayed
     * @param enemy info which enemy will die
     */
    public void nextDeathFrame(Enemy enemy){
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
        else {
            enemy.die();
            enemy.dying = false;
        }
        count++;
    }

    /** function that runs the animation of enemy death
     *
     * @param enemy which enemy will die
     */
    public void tickDeathAnimation(Enemy enemy){
        index++;
        if (index > speed){
            index = 0;
            nextDeathFrame(enemy);
        }
    }

    /**
     * function that changes information about what image should be displayed
     * @param explodingBars info which  are destroying
     */
    public void nextDestroyFrame(ExplodingBars explodingBars){
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
        else {
            explodingBars.destroy();
        }
        count++;
    }

    /** function that runs the animation of destroying bars
     *
     * @param explodingBars which are destroying
     */
    public void tickDestroyAnimation(ExplodingBars explodingBars){
        index++;
        if (index > speed){
            index = 0;
            nextDestroyFrame(explodingBars);
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
