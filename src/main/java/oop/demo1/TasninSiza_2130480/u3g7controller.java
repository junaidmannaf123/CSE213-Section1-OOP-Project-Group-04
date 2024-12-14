package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class u3g7controller {

    @FXML
    private ComboBox<String> refusalCaseComboBox;

    @FXML
    private TextArea notesTextArea;

    @FXML
    private Button saveButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Label notesLabel;

    /**
     * Initializes the ComboBox and sets up default messages.
     */
    @FXML
    private void initialize() {
        // Populate the ComboBox with refusal cases
        refusalCaseComboBox.getItems().addAll(
                "Case 1: Missing Documents",
                "Case 2: Insufficient Funds",
                "Case 3: Invalid Application",
                "Case 4: Rejected Visa Interview"
        );

        // Set the default status message
        statusLabel.setText("Select a case and add notes.");
    }

    /**
     * Handles the selection of a refusal case from the ComboBox.
     */
    @FXML
    private void handleRefusalCaseSelection() {
        String selectedCase = refusalCaseComboBox.getSelectionModel().getSelectedItem();
        if (selectedCase != null && !selectedCase.isEmpty()) {
            System.out.println("Selected case: " + selectedCase);
            statusLabel.setText("Provide notes for: " + selectedCase);
        } else {
            statusLabel.setText("Please select a valid case.");
        }
    }

    /**
     * Handles changes in the notes TextArea and updates the status label.
     */
    @FXML
    private void handleNotesChange() {
        String notes = notesTextArea.getText();
        if (notes != null && !notes.trim().isEmpty()) {
            statusLabel.setText("Notes are ready to be saved.");
        } else {
            statusLabel.setText("Enter consultation notes here...");
        }
    }

    /**
     * Handles the saving of consultation notes.
     * Validates inputs and updates the status label on success or failure.
     */
    @FXML
    private void handleSaveNotes(ActionEvent event) {
        String selectedCase = refusalCaseComboBox.getSelectionModel().getSelectedItem();
        String notes = notesTextArea.getText();

        // Validate the selected case
        if (selectedCase == null || selectedCase.isEmpty()) {
            statusLabel.setText("Error: No case selected.");
            System.out.println("Error: No case selected.");
            return;
        }

        // Validate the entered notes
        if (notes == null || notes.trim().isEmpty()) {
            statusLabel.setText("Error: Notes cannot be empty.");
            System.out.println("Error: Notes are empty.");
            return;
        }

        // Simulate saving the notes (e.g., save to a database or file)
        System.out.println("Saving notes for: " + selectedCase);
        System.out.println("Notes: " + notes);

        // Update the status label to reflect the save
        statusLabel.setText("Notes for " + selectedCase + " saved successfully.");

        // Clear the notes TextArea after saving
        notesTextArea.clear();
    }
}
