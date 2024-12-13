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

public class u4g6controller {

    @FXML
    private ComboBox<String> sessionComboBox; // ComboBox to select the session

    @FXML
    private Button downloadButton; // Button to download the consultation notes

    @FXML
    private Button backButton; // Button to go back to the previous screen

    @FXML
    private Label statusLabel; // Label to show the status of the download

    // Method to handle the download button action
    @FXML
    private void handleDownloadNotes(ActionEvent event) {
        String selectedSession = sessionComboBox.getValue();

        if (selectedSession == null || selectedSession.trim().isEmpty()) {
            statusLabel.setText("Please select a session to download the notes.");
        } else {
            // Logic for downloading the consultation notes
            // For now, we simulate the download by showing a success message
            statusLabel.setText("Consultation notes for session " + selectedSession + " downloaded.");
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
