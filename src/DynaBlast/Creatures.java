/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

/**
 * parent class for all 'alive' objects such as character and enemies
 * stores information about dimensions of creature and his localisation (in double)
 */
public class Creatures {
    /** localisation and dimensions of the creature */
    public double x, y, width, height;

    /**
     * default creator of creature object, all parameters set to 0
     * use @setBounds method
     */
    public Creatures(){
        setBounds(0, 0, 0, 0);
    }

    /**
     * accurate creator of creature object
     *
     * @param x X dimension localisation
     * @param y Y dimension localisation
     * @param width width of the creature
     * @param height height of the creature
     */
    public Creatures(double x, double y, double width, double height){
        setBounds(x, y, width, height);
    }

    /**
     * setting bounds of creature, set localisation and dimensions of the creature
     *
     * @param x X dimension localisation
     * @param y Y dimension localisation
     * @param width width of the creature
     * @param height height of the creature
     */
    public void setBounds(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
