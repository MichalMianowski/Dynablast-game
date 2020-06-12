package DynaBlast;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class BestScoresManager {
    static ArrayList<Score> bestScoresList = new ArrayList();
    static File highScores = new File("res/config/High_Scores.txt");

    void loadHighScores(){
        String name;
        int score;

        try {
            Scanner sc = new Scanner(highScores);
            while (sc.hasNext()) {
                name = sc.nextLine();
                score = sc.nextInt();
                sc.nextLine();
                bestScoresList.add(new Score(name, score));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Blad wczytywania pliku High_Scores.txt");
            e.printStackTrace();
        }
    }
    void saveHighScores() throws IOException {
        FileWriter fileWriter = new FileWriter(highScores);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        bestScoresList.forEach(score -> {
            printWriter.println(score.getName());
            printWriter.println(score.getScore());
        });
        printWriter.close();
    }

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


