package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class u3g4controller {

    @FXML
    private ComboBox<String> caseComboBox;

    @FXML
    private TextArea notesTextArea;

    @FXML
    private Label statusLabel;

    /**
     * Initializes the ComboBox and status label.
     */
    @FXML
    private void initialize() {
        // Sample data for ComboBox
        caseComboBox.getItems().addAll("Case 1: Document Review", "Case 2: Legal Objection", "Case 3: Appeal Submission");

        // Set default status message
        statusLabel.setText("Select a case to start providing guidance.");
    }

    /**
     * Handles the selection of a case from the ComboBox.
     */
    @FXML
    private void handleCaseSelection() {
        String selectedCase = caseComboBox.getValue();
        if (selectedCase != null) {
            System.out.println("Selected case: " + selectedCase);
            // Update the status label to guide the user
            statusLabel.setText("Provide your guidance for the selected case: " + selectedCase);
        } else {
            // If no case is selected
            statusLabel.setText("No case selected. Please choose a case.");
        }
    }

    /**
     * Handles real-time changes in the notes TextArea.
     */
    @FXML
    private void handleNotesChange() {
        String notes = notesTextArea.getText();
        if (notes != null && !notes.trim().isEmpty()) {
            System.out.println("Legal advice entered: " + notes);
        } else {
            System.out.println("Legal advice cleared.");
        }
    }

    /**
     * Handles the Save button click action.
     */
    @FXML
    private void handleSave(ActionEvent event) {
        String selectedCase = caseComboBox.getValue();
        String notes = notesTextArea.getText();

        // Validate case selection
        if (selectedCase == null || selectedCase.isEmpty()) {
            statusLabel.setText("Error: Please select a case before saving.");
            System.out.println("Error: No case selected.");
            return;
        }

        // Validate notes input
        if (notes == null || notes.trim().isEmpty()) {
            statusLabel.setText("Error: Please enter legal advice before saving.");
            System.out.println("Error: No legal advice provided.");
            return;
        }

        // Simulate saving the legal guidance (e.g., save to a database or a file)
        System.out.println("Saving notes for case: " + selectedCase);
        System.out.println("Legal guidance: " + notes);

        // Provide feedback to the user
        statusLabel.setText("Notes saved successfully for " + selectedCase + ".");
        System.out.println("Notes saved successfully.");
    }
}
