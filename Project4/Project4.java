/*
* Author: Rekik Amme 
* Course: COP3503
* Project #: 4
* Title : GUI
* Due Date: 4/28/2024
*
* Three Java files (Project4, FileHandler, and CustomJFrame) must be created for this project.
* Project4 initializes and displays a GUI window (CustomJFrame), and FileHandler is in charge 
* of writing survey data to a CSV file while making sure the file's format complies with a 
* predetermined header and sample CSV file.
* 
*/
import javax.swing.SwingUtilities;


// TODO: Auto-generated Javadoc
/**
 * The Class Project4.
 */
public class Project4 {
    
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomJFrame());// "Invoke" CustomJFrame constructor on the event- thread 
    }
}
