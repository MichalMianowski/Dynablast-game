/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

/**
 * class to store each record of name and its score
 * it's comparable base on score points
 * it's comparable in descending order
 */
public class Score implements Comparable{
    /** name of scored player */
    String name;
    /**points from this play */
    int score;

    /**
     * constructor
     * write name and score to proper fields
     *
     * @param name - Player's name
     * @param score - Player's score in this game
     */
    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * name getter
     * @return - name of Player
     */
    public String getName() {
        return name;
    }

    /**
     * score getter
     * @return - points gained by Player
     */
    public int getScore() {
        return score;
    }

    /**
     * presentation of score record in String
     * @return - return String with name nad score of player
     */
    public String toString(){
        return getName() + "     " + getScore();
    }

    /**
     * rules of comparing records
     * useful to easier sorting (descending)
     * compare values of (int)points in score
     *
     * @param o - object
     * @return - value for comparetion
     */

    public int compareTo(Object o) {
        int compareScore = ((Score)o).getScore();
        //descending order
        return compareScore - this.score;
    }
}
