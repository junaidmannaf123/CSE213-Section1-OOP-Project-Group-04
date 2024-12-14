package oop.demo1.TasninSiza_2130480;

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

    @FXML
    private Label messageLabel;


    @FXML
    private void handleFetch(ActionEvent event) {
        String applicationId = applicationIdTextField.getText().trim();

        if (applicationId.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");
            alert.setHeaderText("Application ID Missing");
            alert.setContentText("Please enter a valid Application ID to fetch the status.");
            alert.showAndWait();
            return;
        }


        String status = fetchApplicationStatus(applicationId);


        statusLabel.setText("Application Status: " + status);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Application Status");
        alert.setHeaderText("Status Retrieved");
        alert.setContentText("Application ID: " + applicationId + "\nStatus: " + status);
        alert.showAndWait();


        messageLabel.setText("Status: " + status);
    }


    private String fetchApplicationStatus(String applicationId) {

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
