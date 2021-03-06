/**
 * Michal Mianowski & Piotr Strzaska
 */
package DynaBlast;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * class to adjust actions after closing window
 */
class MyWindowsListener implements WindowListener {
    public void windowClosing(WindowEvent arg0) {
        System.exit(0);
        }

    public void windowOpened(WindowEvent arg0) {}
    public void windowClosed(WindowEvent arg0) {}
    public void windowIconified(WindowEvent arg0) {}
    public void windowDeiconified(WindowEvent arg0) {}
    public void windowActivated(WindowEvent arg0) {}
    public void windowDeactivated(WindowEvent arg0) {}
}
