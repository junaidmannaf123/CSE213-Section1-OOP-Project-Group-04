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

public class u4g3controller {

    @FXML
    private TextField applicationIdTextField; // TextField for entering the application ID

    @FXML
    private Button fetchButton; // Button to fetch the application status

    @FXML
    private Button backButton; // Button to go back to the previous screen

    @FXML
    private Label statusLabel; // Label to display the status

    // Method to handle the fetch action for application status
    @FXML
    private void handleFetchStatus(ActionEvent event) {
        String applicationId = applicationIdTextField.getText();

        if (applicationId == null || applicationId.trim().isEmpty()) {
            // Display an error if the application ID is not provided
            statusLabel.setText("Please enter a valid Application ID.");
        } else {
            // Here you can implement logic to fetch the application status from a backend system
            // For now, it simply displays a mock status message
            String mockStatus = "Status for Application ID " + applicationId + ": Approved"; // Mock status
            statusLabel.setText(mockStatus);
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
