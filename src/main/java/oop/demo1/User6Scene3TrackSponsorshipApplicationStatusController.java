package oop.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class User6Scene3TrackSponsorshipApplicationStatusController {

    @FXML
    private TextField applicationNumberTextField;

    @FXML
    private Label statusLabel;

    // Handle "Track Status" button click
    @FXML
    private void handleTrackStatus(ActionEvent event) {
        String applicationNumber = applicationNumberTextField.getText();

        if (applicationNumber == null || applicationNumber.isEmpty()) {
            statusLabel.setText("Please enter an application number.");
        } else {
            // Simulate application tracking logic
            if (applicationNumber.equals("12345")) {
                statusLabel.setText("Status: Approved");
            } else if (applicationNumber.equals("67890")) {
                statusLabel.setText("Status: Pending");
            } else {
                statusLabel.setText("Application not found.");
            }
        }
    }

    // Handle "Back" button click
    @FXML
    private void handleBack(ActionEvent event) {
        System.out.println("Navigating back to the previous screen...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6ClientFSDashboard.fxml"); // Replace with the actual FXML file for the dashboard
    }

    // Helper method to switch scenes
    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
