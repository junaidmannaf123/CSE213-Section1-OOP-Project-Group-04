package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class u4g3controller {

    @FXML
    private TextField applicationIdTextField;

    @FXML
    private Label statusLabel;

    /**
     * This method handles the action of fetching the application status.
     */
    @FXML
    private void handleFetch(ActionEvent event) {
        String applicationId = applicationIdTextField.getText().trim();

        if (applicationId.isEmpty()) {
            // Show an alert if the Application ID is not entered
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Application ID Missing");
            alert.setContentText("Please enter a valid Application ID to fetch the status.");
            alert.showAndWait();
            return;
        }

        // Example: Simulate fetching application status
        String status = fetchApplicationStatus(applicationId);

        // Update the status label
        statusLabel.setText("Application Status: " + status);

        // Optional: Show the status in an alert dialog
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Application Status");
        alert.setHeaderText("Status Retrieved");
        alert.setContentText("Application ID: " + applicationId + "\nStatus: " + status);
        alert.showAndWait();
    }

    /**
     * Simulate fetching application status.
     * Replace this method with real logic to fetch status from a database or server.
     *
     * @param applicationId The ID of the application.
     * @return The status of the application.
     */
    private String fetchApplicationStatus(String applicationId) {
        // Simulated statuses for demonstration purposes
        switch (applicationId) {
            case "12345":
                return "Pending Review";
            case "67890":
                return "Approved";
            case "11223":
                return "Rejected";
            default:
                return "Application Not Found";
        }
    }
}
