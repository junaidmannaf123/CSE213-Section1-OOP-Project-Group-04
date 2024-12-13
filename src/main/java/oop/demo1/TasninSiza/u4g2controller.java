package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class u4g2controller {

    @FXML
    private ComboBox<String> timeSlotComboBox; // ComboBox for selecting the time slot

    @FXML
    private DatePicker datePicker; // DatePicker for selecting the appointment date

    @FXML
    private Button confirmButton; // Button to confirm the appointment

    @FXML
    private Button backButton; // Button to go back to the previous screen

    // Method to handle the confirmation of the appointment
    @FXML
    private void handleConfirm(ActionEvent event) {
        // Capture the selected date and time slot
        String selectedTimeSlot = timeSlotComboBox.getValue();
        String selectedDate = datePicker.getValue().toString();

        if (selectedTimeSlot == null || selectedDate == null) {
            // Show an error or warning if the user has not selected a date or time slot
            System.out.println("Please select both a date and a time slot.");
        } else {
            // Logic to confirm the appointment (e.g., save data or notify the user)
            System.out.println("Appointment confirmed on " + selectedDate + " at " + selectedTimeSlot);
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
