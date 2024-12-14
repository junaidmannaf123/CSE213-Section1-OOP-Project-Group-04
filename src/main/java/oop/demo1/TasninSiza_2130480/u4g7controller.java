package oop.demo1.TasninSiza_2130480;

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


    @FXML
    private void handleRequest(ActionEvent event) {

        String applicationId = applicationIdTextField.getText();


        if (applicationId == null || applicationId.trim().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Missing Information", "Application ID Missing",
                    "Please enter a valid application ID.");
            return;
        }


        if (!applicationId.matches("\\d{6}")) {
            showAlert(Alert.AlertType.WARNING, "Invalid Application ID", "Invalid Input",
                    "Application ID must be a 6-digit number.");
            return;
        }


        System.out.println("Requesting status update for application ID: " + applicationId);


        statusLabel.setText("Status update requested for Application ID: " + applicationId);


        showAlert(Alert.AlertType.INFORMATION, "Request Sent", "Application Status Update",
                "Your request for a status update on application ID '" + applicationId + "' has been submitted successfully.");
    }


    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
