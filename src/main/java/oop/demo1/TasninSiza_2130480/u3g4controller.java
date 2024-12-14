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

    @FXML
    private void initialize() {
        // Sample data for ComboBox
        caseComboBox.getItems().addAll("Case 1", "Case 2", "Case 3");

        // Initialize labels or other UI components if needed
        statusLabel.setText("Select a case to start providing guidance.");
    }

    /**
     * Handles the case selection from the ComboBox.
     */
    @FXML
    private void handleCaseSelection() {
        String selectedCase = caseComboBox.getValue();
        if (selectedCase != null) {
            System.out.println("Selected case: " + selectedCase);
            statusLabel.setText("Provide your guidance for the selected case.");
        } else {
            statusLabel.setText("No case selected.");
        }
    }

    /**
     * Handles the notes change in the TextArea (e.g., as the user types).
     */
    @FXML
    private void handleNotesChange() {
        String notes = notesTextArea.getText();
        System.out.println("Legal advice entered: " + notes);
    }

    /**
     * Handles the Save button click action.
     */
    @FXML
    private void handleSave(ActionEvent event) {
        String selectedCase = caseComboBox.getValue();
        String notes = notesTextArea.getText();

        if (selectedCase == null || selectedCase.isEmpty()) {
            statusLabel.setText("Please select a case before saving.");
            return;
        }

        if (notes == null || notes.isEmpty()) {
            statusLabel.setText("Please enter legal advice before saving.");
            return;
        }

        // Logic to save the notes (e.g., save to database or file)
        System.out.println("Saving notes for case: " + selectedCase);
        System.out.println("Legal guidance: " + notes);

        // Update the status label
        statusLabel.setText("Notes saved successfully.");
    }
}
