/*
* Author: Rekik Amme 
* Course: COP3503
* Project #: 4
* Title : GUI
* Due Date: 4/28/2024
*/
import java.awt.event.ActionEvent;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving action events.
 * The class that is interested in processing a action
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addActionListener</code> method. When
 * the action event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ActionEvent
 */
public interface ActionListener {

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	void actionPerformed(ActionEvent e);
	
	
}
