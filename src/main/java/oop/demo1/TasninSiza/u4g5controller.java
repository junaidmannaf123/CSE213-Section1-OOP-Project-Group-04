package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class u4g5controller {

    @FXML
    private ComboBox<String> caseComboBox; // ComboBox for selecting the case type

    @FXML
    private Button scheduleButton; // Button to schedule the consultation

    @FXML
    private Button backButton; // Button to go back to the previous screen

    @FXML
    private Label statusLabel; // Label to show the status of the scheduling

    // Method to handle the scheduling action
    @FXML
    private void handleScheduleConsultation(ActionEvent event) {
        String selectedCase = caseComboBox.getValue();

        if (selectedCase == null || selectedCase.trim().isEmpty()) {
            statusLabel.setText("Please select a case to schedule the consultation.");
        } else {
            // Handle the consultation scheduling logic here
            // For now, we show a confirmation message
            statusLabel.setText("Consultation for case " + selectedCase + " scheduled.");
        }
    }

    // Method to handle going back to the previous screen (e.g., login screen)
    @FXML
    private void handleBackToLogin(ActionEvent event) {
        System.out.println("Navigating back to the login screen.");

        // Switch to the login screen
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
