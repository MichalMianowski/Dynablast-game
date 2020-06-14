/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

/** Main class of the project, that begins all necessary actions */
public class Boot {
    static char character = Tile.male_orange;
    /**
     * Main function of the class, that creates the whole functioning menu, by first creating its parts
     * and then assembling them together
     * @param args - arg for main
     */
    public static void main (String args[]){
        Menu menu = new Menu();
        menu.CreateNewGameButton();
        menu.CreateOptionsButton();
        menu.CreateBestScoresButton();
        menu.CreateExitButton();
        menu.setVisible(true);
    }
}
