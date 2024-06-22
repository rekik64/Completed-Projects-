/*
* Author: Rekik Amme 
* Course: COP3503
* Project #: 4
* Title : GUI
* Due Date: 4/28/2024
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomJFrame.
 * Represents the Main JFrame
 * 
 */
public class CustomJFrame extends JFrame {

	//Labels for sections for the form
    /** The dietary label. */
    private JLabel headingLabel, firstNameLabel, lastNameLabel, phoneNumberLabel, emailLabel, dietaryLabel;
    /** The weight label. */
    private JLabel genderLabel, waterLabel, mealLabel, checkBoxLabel, walkLabel, weightLabel;
    
    //Text fields, button, spinner, and check-boxes for user input
    /** The email text field. */
    private JTextField firstNameTextField, lastNameTextField, phoneNumberTextField, emailTextField;
    
    /** The prefer radio button. */
    private JRadioButton maleRadioButton, femaleRadioButton, preferRadioButton;
    
    /** The radio button group. */
    private ButtonGroup radioButtonGroup;
    
    /** The water intake spinner. */
    private JSpinner waterIntakeSpinner;
    
    /** The meal slider. */
    private JSlider mealSlider;
    
    /** The dairy check box. */
    private JCheckBox wheatCheckBox, sugarCheckBox, dairyCheckBox;
    
    /** The walk combo box. */
    private JComboBox<String> walkComboBox;
    
    /** The walk options. */
    private String[] walkOptions;
    
    /** The weight formatted text field. */
    private JFormattedTextField weightFormattedTextField;
    
    /** The clear button. */
    private JButton clearButton;
    
    /** The submit button. */
    private JButton submitButton;
    
    // Instance to manage writing survey results
    /** The file handler. */
    private FileHandler fileHandler;

    /**
     * Instantiates a new custom J frame.
     */
    public CustomJFrame() {

        setTitle("Dietary Survey");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 30, 5, 30);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx = 0;

        //Adding components to JFrame
        headingLabel = new JLabel("Personal Information");
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(headingLabel, gbc);

        //Adding in labels & texts fields for personal info
        gbc.gridwidth = 1;
        gbc.gridy++;

        firstNameLabel = new JLabel("First Name: ");
        firstNameTextField = new JTextField(10);
        gbc.gridy++;
        add(firstNameLabel, gbc);
        gbc.gridy++;
        add(firstNameTextField, gbc);

        lastNameLabel = new JLabel("Last Name: ");
        lastNameTextField = new JTextField(20);
        gbc.gridy++;
        add(lastNameLabel, gbc);
        gbc.gridy++;
        add(lastNameTextField, gbc);

        phoneNumberLabel = new JLabel("Phone Number: ");
        phoneNumberTextField = new JTextField(20);
        gbc.gridy++;
        add(phoneNumberLabel, gbc);
        gbc.gridy++;
        add(phoneNumberTextField, gbc);

        emailLabel = new JLabel("Email: ");
        emailTextField = new JTextField(20);
        gbc.gridy++;
        add(emailLabel, gbc);
        gbc.gridy++;
        add(emailTextField, gbc);

        genderLabel = new JLabel("Sex: ");
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        preferRadioButton = new JRadioButton("Prefer not to say");
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(maleRadioButton);
        radioButtonGroup.add(femaleRadioButton);
        radioButtonGroup.add(preferRadioButton);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        radioPanel.add(maleRadioButton);
        radioPanel.add(femaleRadioButton);
        radioPanel.add(preferRadioButton);
        gbc.gridy++;
        add(genderLabel, gbc);
        gbc.gridy++;
        add(radioPanel, gbc);

        dietaryLabel = new JLabel("Dietary Questions");
        gbc.gridy++;
        add(dietaryLabel, gbc);

        waterLabel = new JLabel("How many cups of water on average do you drink a day?");
        waterIntakeSpinner = new JSpinner(new SpinnerNumberModel(15, 0, 50, 1));
        JPanel waterSpinnerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        waterSpinnerPanel.add(waterIntakeSpinner);
        gbc.gridy++;
        add(waterLabel, gbc);
        gbc.gridy++;
        add(waterSpinnerPanel, gbc);

        mealLabel = new JLabel("How many meals on average do you eat a day?");
        gbc.gridy++;
        add(mealLabel, gbc);

        mealSlider = new JSlider(0, 10, 3);
        mealSlider.setMajorTickSpacing(1);
        mealSlider.setPaintTicks(true);
        mealSlider.setPaintLabels(true);
        mealSlider.setSnapToTicks(true);
        gbc.gridy++;
        add(mealSlider, gbc);

        checkBoxLabel = new JLabel("Do any of these meals regularly contain:");
        gbc.gridy++;
        add(checkBoxLabel, gbc);

        dairyCheckBox = new JCheckBox("Dairy");
        wheatCheckBox = new JCheckBox("Wheat");
        sugarCheckBox = new JCheckBox("Sugar");

        JPanel checkBoxPanel = new JPanel(new GridLayout(1, 3));
        checkBoxPanel.add(dairyCheckBox);
        checkBoxPanel.add(wheatCheckBox);
        checkBoxPanel.add(sugarCheckBox);
        gbc.gridy++;
        add(checkBoxPanel, gbc);

        walkLabel = new JLabel("On average how many miles do you walk in a day?");
        gbc.gridy++;
        add(walkLabel, gbc);

        walkOptions = new String[]{"Less than 1 Mile", "1-2 Miles", "2-3 Miles", "More than 3 Miles"};
        walkComboBox = new JComboBox<>(walkOptions);
        gbc.gridy++;
        add(walkComboBox, gbc);

        weightLabel = new JLabel("How much do you weigh?");
        gbc.gridy++;
        add(weightLabel, gbc);

        weightFormattedTextField = new JFormattedTextField(NumberFormat.getNumberInstance());
        weightFormattedTextField.setColumns(10);
        gbc.gridy++;
        add(weightFormattedTextField, gbc);

        //Adding in buttons and actions
        clearButton = new JButton("Clear");
        submitButton = new JButton("Submit");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.add(clearButton);
        buttonPanel.add(submitButton);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy++;
        add(buttonPanel, gbc);

        InnerActionListener myActListener = new InnerActionListener();
        clearButton.addActionListener(myActListener);
        submitButton.addActionListener(myActListener);

        //FileHandler for managing survey results
        try {
            fileHandler = new FileHandler();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * The listener interface for receiving innerAction events.
     * The class that is interested in processing a innerAction
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addInnerActionListener</code> method. When
     * the innerAction event occurs, that object's appropriate
     * method is invoked.
     *
     * @see InnerActionEvent
     */
    private class InnerActionListener implements ActionListener {

        /**
         * Action performed.
         *
         * @param event the event
         */
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == submitButton) {

                String pressedSexButtonStr = "";
                if (maleRadioButton.isSelected()) {
                    pressedSexButtonStr = "Male";
                } else if (femaleRadioButton.isSelected()) {// Handle submission
                    pressedSexButtonStr = "Female";
                } else if (preferRadioButton.isSelected()) {// Handle clearing the form
                    pressedSexButtonStr = "Prefer not to say";
                }

                String cvsDataString = firstNameTextField.getText() + ", " +
                        lastNameTextField.getText() + ", " +
                        phoneNumberTextField.getText() + ", " +
                        emailTextField.getText() + ", " +
                        pressedSexButtonStr + ", " +
                        waterIntakeSpinner.getValue() + ", " +
                        mealSlider.getValue() + ", " +
                        (dairyCheckBox.isSelected() ? "true" : "false") + ", " +
                        (wheatCheckBox.isSelected() ? "true" : "false") + ", " +
                        (sugarCheckBox.isSelected() ? "true" : "false") + ", " +
                        walkComboBox.getSelectedItem() + ", " +
                        weightFormattedTextField.getText();

                fileHandler.writeResults(cvsDataString);
                clearForm();

            } else if (event.getSource() == clearButton) {
                clearForm();

            }

        }

        /**
         * Clear form.
         */
        private void clearForm() {// Clear all Fields
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            phoneNumberTextField.setText("");
            emailTextField.setText("");
            radioButtonGroup.clearSelection();
            waterIntakeSpinner.setValue(15);
            mealSlider.setValue(3);
            dairyCheckBox.setSelected(false);
            wheatCheckBox.setSelected(false);
            sugarCheckBox.setSelected(false);
            walkComboBox.setSelectedIndex(0);
            weightFormattedTextField.setText("");
        }

    }

    
}
