package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class u4g7controller {

    @FXML
    private TextField applicationIdTextField;

    @FXML
    private Label statusLabel;

    /**
     * This method handles the request for an application status update.
     */
    @FXML
    private void handleRequest(ActionEvent event) {
        // Retrieve the application ID entered in the TextField
        String applicationId = applicationIdTextField.getText();

        if (applicationId == null || applicationId.trim().isEmpty()) {
            // Show an alert if the application ID is missing
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Application ID Missing");
            alert.setContentText("Please enter a valid application ID.");
            alert.showAndWait();
            return;
        }

        // Simulate request processing
        System.out.println("Requesting status update for application ID: " + applicationId);

        // Update the status label
        statusLabel.setText("Status update requested for application ID: " + applicationId);

        // Provide user feedback
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Request Sent");
        alert.setHeaderText("Application Status Update");
        alert.setContentText("Your request for a status update on application ID '" + applicationId + "' has been submitted successfully.");
        alert.showAndWait();
    }
}
