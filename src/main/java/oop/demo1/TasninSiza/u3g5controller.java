package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class u3g5controller {

    @FXML
    private ComboBox<String> serviceComboBox;

    @FXML
    private DatePicker followUpDatePicker;

    @FXML
    private Button confirmButton;

    @FXML
    private Button backButton;

    // Method to handle confirming the settlement consultation
    @FXML
    private void handleConfirm(ActionEvent event) {
        String selectedService = serviceComboBox.getValue();
        String followUpDate = followUpDatePicker.getValue() != null ? followUpDatePicker.getValue().toString() : "";

        if (selectedService != null && !followUpDate.isEmpty()) {
            System.out.println("Confirming settlement for service: " + selectedService);
            System.out.println("Follow-up date: " + followUpDate);

            // Add logic to save this information or process the confirmation
        } else {
            System.out.println("Please select a service and provide a follow-up date.");
        }
    }

    // Method to handle going back to the login screen
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
