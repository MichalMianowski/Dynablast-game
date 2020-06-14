/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

/** class that is responsible for playing audio files */
public class Sounds extends JFrame {
    /** clip that plays the music or sound */
    static Clip audioClip = null;
    /** file from which the music should be read */
    static File audioFile = null;
    /** audio stream that gets all necessary information about the sound file that is open */
    static AudioInputStream audioStream = null;

    /** location of the menu music sound file */
    static String MenuMusic = "res/Sounds/Menu music.wav";
    /** location of the game music sound file */
    static String GameMusic = "res/Sounds/Game music.wav";
    /** location of the button click sound file */
    static String ButtonClick = "res/Sounds/Button click.wav";

    /** basic constructor of the class */
    public Sounds() { }

    /** function that plays the audio file
     *  First it opens the necessary audio file
     *  then it gets necessary information about this file (format etc.)
     *  then applies that information to audio clip
     *  and at last it plays required audio clip
     *
     * @param soundFile location of audio file, that has to be played
     */
    public static void play(String soundFile) {
        try {
            audioFile = new File(soundFile);
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);

            Thread thread = new Thread(() -> {
                audioClip.start();
                try {
                    audioStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(!(soundFile == ButtonClick)) {
                    audioClip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            });
            thread.start();

        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException e1) {
            System.out.println("Error playing the audio file.");
            e1.printStackTrace();
        }

    }


}
