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

    @FXML
    private void initialize() {
        // Populate the ComboBox with refusal cases (could be dynamic or static values)
        refusalCaseComboBox.getItems().addAll("Case 1", "Case 2", "Case 3", "Case 4");

        // Default status label
        statusLabel.setText("Select a case and add notes.");
    }

    /**
     * Handle the selection of a refusal case from the ComboBox.
     */
    @FXML
    private void handleRefusalCaseSelection() {
        String selectedCase = refusalCaseComboBox.getSelectionModel().getSelectedItem();
        if (selectedCase != null && !selectedCase.isEmpty()) {
            statusLabel.setText("Notes for " + selectedCase + " selected.");
        }
    }

    /**
     * Handles the change in notes text area.
     * Updates status label when text is entered.
     */
    @FXML
    private void handleNotesChange() {
        String notes = notesTextArea.getText();
        if (!notes.isEmpty()) {
            statusLabel.setText("Notes ready to be saved.");
        } else {
            statusLabel.setText("Enter consultation notes here...");
        }
    }

    /**
     * Handles the saving of consultation notes.
     * Updates the status label when notes are saved.
     */
    @FXML
    private void handleSaveNotes(ActionEvent event) {
        String selectedCase = refusalCaseComboBox.getSelectionModel().getSelectedItem();
        String notes = notesTextArea.getText();

        if (selectedCase != null && !selectedCase.isEmpty() && !notes.isEmpty()) {
            // Save the notes (this could involve storing them in a database or file)
            // For now, just print the notes to console as a placeholder for saving logic.
            System.out.println("Saving notes for: " + selectedCase);
            System.out.println("Notes: " + notes);

            // Update the status label to reflect the save
            statusLabel.setText("Notes for " + selectedCase + " saved successfully.");

            // Optionally, clear the notes text area after saving
            notesTextArea.clear();
        } else {
            // If the case or notes are missing, show an error message
            statusLabel.setText("Please select a case and enter valid notes.");
        }
    }
}
