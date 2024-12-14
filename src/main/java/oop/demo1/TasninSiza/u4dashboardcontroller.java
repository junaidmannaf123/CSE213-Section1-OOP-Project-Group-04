package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class u4dashboardcontroller {

    @FXML
    private void handleSubmitApplication(ActionEvent event) {
        System.out.println("Navigating to Submit Immigration Application...");
        switchScene(event, "SubmitApplication.fxml");
    }

    @FXML
    private void handleBookConsultation(ActionEvent event) {
        System.out.println("Navigating to Book Consultation Appointment...");
        switchScene(event, "BookConsultation.fxml");
    }

    @FXML
    private void handleTrackApplication(ActionEvent event) {
        System.out.println("Navigating to Track Application Status...");
        switchScene(event, "TrackApplication.fxml");
    }

    @FXML
    private void handleUploadDocuments(ActionEvent event) {
        System.out.println("Navigating to Upload Additional Documents...");
        switchScene(event, "UploadDocuments.fxml");
    }

    @FXML
    private void handleVisaConsultation(ActionEvent event) {
        System.out.println("Navigating to Receive Visa Refusal Consultation...");
        switchScene(event, "VisaConsultation.fxml");
    }

    @FXML
    private void handleDownloadNotes(ActionEvent event) {
        System.out.println("Navigating to Download Consultation Notes...");
        switchScene(event, "DownloadNotes.fxml");
    }

    @FXML
    private void handleRequestStatusUpdate(ActionEvent event) {
        System.out.println("Navigating to Request for Application Status Update...");
        switchScene(event, "RequestStatusUpdate.fxml");
    }

    @FXML
    private void handlePayConsultationFees(ActionEvent event) {
        System.out.println("Navigating to Pay Consultation Fees...");
        switchScene(event, "PayConsultationFees.fxml");
    }

    /**
     * Helper method to switch scenes.
     * @param event the action event triggering the scene change
     * @param fxmlFile the name of the FXML file to load
     */
    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
