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

        refusalCaseComboBox.getItems().addAll(
                "Case 1: Missing Documents",
                "Case 2: Insufficient Funds",
                "Case 3: Invalid Application",
                "Case 4: Rejected Visa Interview"
        );


        statusLabel.setText("Select a case and add notes.");
    }


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


    @FXML
    private void handleNotesChange() {
        String notes = notesTextArea.getText();
        if (notes != null && !notes.trim().isEmpty()) {
            statusLabel.setText("Notes are ready to be saved.");
        } else {
            statusLabel.setText("Enter consultation notes here...");
        }
    }


    @FXML
    private void handleSaveNotes(ActionEvent event) {
        String selectedCase = refusalCaseComboBox.getSelectionModel().getSelectedItem();
        String notes = notesTextArea.getText();


        if (selectedCase == null || selectedCase.isEmpty()) {
            statusLabel.setText("Error: No case selected.");
            System.out.println("Error: No case selected.");
            return;
        }


        if (notes == null || notes.trim().isEmpty()) {
            statusLabel.setText("Error: Notes cannot be empty.");
            System.out.println("Error: Notes are empty.");
            return;
        }


        System.out.println("Saving notes for: " + selectedCase);
        System.out.println("Notes: " + notes);


        statusLabel.setText("Notes for " + selectedCase + " saved successfully.");


        notesTextArea.clear();
    }
}
