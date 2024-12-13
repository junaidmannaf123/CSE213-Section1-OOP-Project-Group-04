package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class u4g7controller {

    @FXML
    private TextField applicationIdTextField; // TextField to enter Application ID

    @FXML
    private Button requestButton; // Button to request application status update

    @FXML
    private Button backButton; // Button to go back to the previous screen

    @FXML
    private Label statusLabel; // Label to show the status message

    // Method to handle the request button action
    @FXML
    private void handleRequestStatusUpdate(ActionEvent event) {
        String applicationId = applicationIdTextField.getText();

        if (applicationId == null || applicationId.trim().isEmpty()) {
            statusLabel.setText("Please enter a valid Application ID.");
        } else {
            // Logic to process the request for the application status update
            // For now, we simulate the request and show a success message
            statusLabel.setText("Status update request sent for Application ID: " + applicationId);
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
