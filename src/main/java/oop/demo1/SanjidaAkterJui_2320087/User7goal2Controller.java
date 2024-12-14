package oop.demo1.SanjidaAkterJui_2320087;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class User7goal2Controller {

    @FXML
    private ComboBox<String> lvaccombobox;

    @FXML
    private TextArea providelegaladvctextarea;

    @FXML
    private Button subnotesupdtstatusbutton;

    @FXML
    private Button backButton;

    // Method to handle "Submit Notes and Update Status" button click
    @FXML
    private void handleSubmitNotesAndUpdateStatus() {
        // Example logic for processing legal advice and updating status
        String selectedCase = lvaccombobox.getValue();
        String legalAdvice = providelegaladvctextarea.getText();

        System.out.println("Selected Case: " + selectedCase);
        System.out.println("Provided Legal Advice: " + legalAdvice);
        // Add logic to save notes and update the status
    }

    // Method to handle "Back" button click
    @FXML
    private void handleBackToDashboard() {
        System.out.println("Navigating back to the dashboard.");
        // Add logic for navigation
    }
}

