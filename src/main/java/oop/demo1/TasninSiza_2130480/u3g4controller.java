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

        caseComboBox.getItems().addAll("Case 1: Document Review", "Case 2: Legal Objection", "Case 3: Appeal Submission");


        statusLabel.setText("Select a case to start providing guidance.");
    }


    @FXML
    private void handleCaseSelection() {
        String selectedCase = caseComboBox.getValue();
        if (selectedCase != null) {
            System.out.println("Selected case: " + selectedCase);

            statusLabel.setText("Provide your guidance for the selected case: " + selectedCase);
        } else {

            statusLabel.setText("No case selected. Please choose a case.");
        }
    }


    @FXML
    private void handleNotesChange() {
        String notes = notesTextArea.getText();
        if (notes != null && !notes.trim().isEmpty()) {
            System.out.println("Legal advice entered: " + notes);
        } else {
            System.out.println("Legal advice cleared.");
        }
    }


    @FXML
    private void handleSave(ActionEvent event) {
        String selectedCase = caseComboBox.getValue();
        String notes = notesTextArea.getText();


        if (selectedCase == null || selectedCase.isEmpty()) {
            statusLabel.setText("Error: Please select a case before saving.");
            System.out.println("Error: No case selected.");
            return;
        }


        if (notes == null || notes.trim().isEmpty()) {
            statusLabel.setText("Error: Please enter legal advice before saving.");
            System.out.println("Error: No legal advice provided.");
            return;
        }


        System.out.println("Saving notes for case: " + selectedCase);
        System.out.println("Legal guidance: " + notes);


        statusLabel.setText("Notes saved successfully for " + selectedCase + ".");
        System.out.println("Notes saved successfully.");
    }
}
