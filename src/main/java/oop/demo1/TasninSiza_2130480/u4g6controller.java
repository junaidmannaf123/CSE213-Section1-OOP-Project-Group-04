package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class u4g6controller {

    @FXML
    private ComboBox<String> sessionComboBox;

    @FXML
    private Label statusLabel;

    @FXML
    private void handleDownload(ActionEvent event) {
        String selectedSession = sessionComboBox.getValue();

        if (selectedSession == null || selectedSession.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Selection");
            alert.setHeaderText("Session Missing");
            alert.setContentText("Please select a session before downloading the consultation notes.");
            alert.showAndWait();
            return;
        }


        System.out.println("Downloading consultation notes for session: " + selectedSession);
        statusLabel.setText("Consultation notes downloaded for session: " + selectedSession);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Download Successful");
        alert.setHeaderText("Consultation Notes Downloaded");
        alert.setContentText("Consultation notes for session '" + selectedSession + "' have been downloaded successfully.");
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        // Populate the ComboBox with session options
        sessionComboBox.getItems().addAll(
                "Session 1: Visa Guidance",
                "Session 2: Document Preparation",
                "Session 3: Legal Advice",
                "Session 4: Appeal Process",
                "Session 5: Other"
        );


        if (statusLabel != null) {
            statusLabel.setText("Please select a session.");
        } else {
            System.err.println("Error: statusLabel is null.");
        }

        System.out.println("Controller initialized and session options loaded.");
    }
}
