package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class u3g8controller {

    @FXML
    private ComboBox<?> topicComboBox; // ComboBox to select workshop topic

    @FXML
    private DatePicker workshopDatePicker; // DatePicker to select the workshop date

    @FXML
    private Button confirmButton; // Button to confirm the workshop details

    @FXML
    private Button backButton; // Button to go back to the previous screen

    @FXML
    private Label statusLabel; // Label to display status or additional info

    // Method to handle confirming the workshop details
    @FXML
    private void handleConfirm(ActionEvent event) {
        String selectedTopic = (String) topicComboBox.getValue();
        String selectedDate = workshopDatePicker.getValue().toString();

        if (selectedTopic != null && !selectedDate.isEmpty()) {
            // Logic to confirm the workshop details
            System.out.println("Workshop Confirmed. Topic: " + selectedTopic + ", Date: " + selectedDate);
            // You can add further logic to save the data or update the UI
        } else {
            System.out.println("Please select a topic and date.");
        }
    }

    // Method to handle going back to the previous screen (login screen)
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
