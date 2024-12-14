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

    /**
     * This method handles the action of downloading consultation notes for the selected session.
     */
    @FXML
    private void handleDownload(ActionEvent event) {
        String selectedSession = sessionComboBox.getValue();

        if (selectedSession == null || selectedSession.isEmpty()) {
            // Show an alert if no session is selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Selection");
            alert.setHeaderText("Session Missing");
            alert.setContentText("Please select a session before downloading the consultation notes.");
            alert.showAndWait();
            return;
        }

        // Simulate download logic
        System.out.println("Downloading consultation notes for session: " + selectedSession);

        // Update the status label
        statusLabel.setText("Consultation notes downloaded for session: " + selectedSession);

        // Provide user feedback
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Download Successful");
        alert.setHeaderText("Consultation Notes Downloaded");
        alert.setContentText("Consultation notes for session '" + selectedSession + "' have been downloaded successfully.");
        alert.showAndWait();
    }

    /**
     * Initialize the ComboBox with predefined sessions.
     * This method is called automatically when the controller is loaded.
     */
    @FXML
    public void initialize() {
        // Add predefined sessions to the ComboBox
        sessionComboBox.getItems().addAll(
                "Session 1: Visa Guidance",
                "Session 2: Document Preparation",
                "Session 3: Legal Advice",
                "Session 4: Appeal Process",
                "Session 5: Other"
        );

        System.out.println("Controller initialized and session options loaded.");
    }
}
