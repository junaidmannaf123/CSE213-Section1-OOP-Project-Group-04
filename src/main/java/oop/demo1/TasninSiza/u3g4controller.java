package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class u3g4controller {

    @FXML
    private ComboBox<String> caseComboBox;

    @FXML
    private TextArea notesTextArea;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    // Method to handle saving the notes
    @FXML
    private void handleSave(ActionEvent event) {
        String selectedCase = caseComboBox.getValue();
        String notes = notesTextArea.getText();

        if (selectedCase != null && !notes.isEmpty()) {
            System.out.println("Saving notes for case: " + selectedCase);
            System.out.println("Notes: " + notes);

            // Here you can add the logic to save the notes, e.g., to a database
        } else {
            System.out.println("Please select a case and enter notes.");
        }
    }

    // Method to handle going back to the login screen
    @FXML
    private void handleBackToLogin(ActionEvent event) {
        System.out.println("Navigating back to the login screen.");

        // Switching to the login screen
        switchScene(event, "Login.fxml");
    }

    // Helper method to switch scenes
    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            // Load the FXML file for the target scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
