/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class manage high scores
 * update high scores list with new record if score is good enough
 * read and write it to .txt file
 * sort scores from best to worse
 * keep the high scores number up to 10
 */
public class BestScoresManager {
    /**
     * Array list containing high scores loaded from .txt file
     * and updating during work on high scores list
     */
    static ArrayList<Score> bestScoresList = new ArrayList();
    /** path to .txt file with high scores */
    static File highScores = new File("res/config/High_Scores.txt");

    /**
     * function to load high scores from .txt file
     * high scores in file must be ordered this way:
     * (String)name1
     * (int)score1
     * (String)name2
     * (int)score2 [etc.]
     */
    void loadHighScores(){
        String name;
        int score;
        bestScoresList.clear();

        try {
            Scanner sc = new Scanner(highScores);
            while (sc.hasNext()) {
                name = sc.nextLine();
                score = sc.nextInt();
                sc. nextLine();
                bestScoresList.add(new Score(name, score));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Blad wczytywania pliku High_Scores.txt");
            e.printStackTrace();
        }
    }

    /**
     * function to write high scores to file
     * file is the same which is to load
     * to write is used printWriter
     *
     * @throws IOException
     */
    void saveHighScores() throws IOException {
        FileWriter fileWriter = new FileWriter(highScores);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        bestScoresList.forEach(score -> {
            printWriter.println(score.getName());
            printWriter.println(score.getScore());
        });
        printWriter.close();
    }

    /**
     * function to check if the score is good enough to be high score
     * it checks number of present high scores
     * and if there is more than 10 the value od new high score
     *
     * @param score - in class Score containing name and number of points of record
     * @return boolean - if the score is good enough to be high score
     */
    public boolean isScoreRanked(Score score) {
        if (bestScoresList.size() >= 10) {    //if (!bestScoresList.isEmpty()) {
            if (score.getScore() > bestScoresList.get(bestScoresList.size() - 1).getScore()) {//read last score in list
                for (int i = 0; i < bestScoresList.size(); i++) {
                    if (bestScoresList.get(i).getScore() < score.getScore()) {
                        return true;
                    }
                }
            }
        } else{
            return true;
        }
        return false;
    }

    /**
     * function adding new score to list of high scores
     * sort the list from the best to the worse
     * and delete from list scores above 10. position on the list
     * (that means index 9)
     *
     * @param score - in class Score containing name and number of points of record
     */
    void addNewHighScore(Score score) {
        bestScoresList.add(score);
        Collections.sort(bestScoresList);

        if (bestScoresList.size() > 10) {
            for (int i = bestScoresList.size()-1; i > 9; i--) {
                bestScoresList.remove(i);
            }
        }

        try {
            saveHighScores();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


