package DynaBlast;

public class Score implements Comparable{
    String name;
    int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString(){
        return getName() + "     " + getScore();
    }

    public int compareTo(Object o) {
        int compareScore = ((Score)o).getScore();
        //descending order
        return compareScore - this.score;
    }
}
