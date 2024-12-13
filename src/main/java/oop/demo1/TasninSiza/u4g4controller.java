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

public class u4g4controller {

    @FXML
    private ComboBox<String> documentTypeComboBox; // ComboBox for selecting document type

    @FXML
    private Button uploadButton; // Button to upload file

    @FXML
    private Button submitButton; // Button to submit the document

    @FXML
    private Button backButton; // Button to go back to the previous screen

    @FXML
    private Label statusLabel; // Label to show the status of the document upload

    // Method to handle the upload action
    @FXML
    private void handleUploadFile(ActionEvent event) {
        // You can add your file upload logic here
        // For now, it will display a message
        statusLabel.setText("File uploaded successfully.");
    }

    // Method to handle the submit action
    @FXML
    private void handleSubmit(ActionEvent event) {
        String documentType = documentTypeComboBox.getValue();

        if (documentType == null || documentType.trim().isEmpty()) {
            statusLabel.setText("Please select a document type.");
        } else {
            // Handle the submit action with the selected document type
            // For now, it displays a confirmation message
            statusLabel.setText("Document " + documentType + " submitted successfully.");
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
