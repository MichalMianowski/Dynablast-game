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

    /** name getter */
    public String getName() {
        return name;
    }

    /** name setter */
    public void setName(String name) {
        this.name = name;
    }

    /** score getter */
    public int getScore() {
        return score;
    }

    /** score setter */
    public void setScore(int score) {
        this.score = score;
    }

    /** presentation of score record in String */
    public String toString(){
        return getName() + "     " + getScore();
    }

    /**
     * rules of comparing records
     * useful to easier sorting (descending)
     * compare values of (int)points in score
     */

    public int compareTo(Object o) {
        int compareScore = ((Score)o).getScore();
        //descending order
        return compareScore - this.score;
    }
}
