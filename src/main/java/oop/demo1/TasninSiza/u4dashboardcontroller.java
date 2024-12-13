package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class u4dashboardcontroller {

    @FXML
    private Button submitImmigrationApplicationButton; // Button for submitting immigration application

    @FXML
    private Button bookConsultationButton; // Button for booking consultation appointment

    @FXML
    private Button trackApplicationStatusButton; // Button for tracking application status

    @FXML
    private Button uploadDocumentsButton; // Button for uploading additional documents

    @FXML
    private Button receiveVisaConsultationButton; // Button for receiving visa refusal consultation

    @FXML
    private Button downloadConsultationNotesButton; // Button for downloading consultation notes

    @FXML
    private Button requestStatusUpdateButton; // Button for requesting application status update

    @FXML
    private Button payConsultationFeesButton; // Button for paying consultation fees

    // Method to handle "Submit Immigration Application" button click
    @FXML
    private void handleSubmitImmigrationApplication(ActionEvent event) {
        // Logic for submitting immigration application
        switchScene(event, "SubmitImmigrationApplication.fxml");
    }

    // Method to handle "Book Consultation Appointment" button click
    @FXML
    private void handleBookConsultationAppointment(ActionEvent event) {
        // Logic for booking consultation appointment
        switchScene(event, "BookConsultation.fxml");
    }

    // Method to handle "Track Application Status" button click
    @FXML
    private void handleTrackApplicationStatus(ActionEvent event) {
        // Logic for tracking application status
        switchScene(event, "TrackApplicationStatus.fxml");
    }

    // Method to handle "Upload Additional Documents" button click
    @FXML
    private void handleUploadAdditionalDocuments(ActionEvent event) {
        // Logic for uploading additional documents
        switchScene(event, "UploadAdditionalDocuments.fxml");
    }

    // Method to handle "Receive Visa Refusal Consultation" button click
    @FXML
    private void handleReceiveVisaRefusalConsultation(ActionEvent event) {
        // Logic for receiving visa refusal consultation
        switchScene(event, "ReceiveVisaConsultation.fxml");
    }

    // Method to handle "Download Consultation Notes" button click
    @FXML
    private void handleDownloadConsultationNotes(ActionEvent event) {
        // Logic for downloading consultation notes
        switchScene(event, "DownloadConsultationNotes.fxml");
    }

    // Method to handle "Request Application Status Update" button click
    @FXML
    private void handleRequestStatusUpdate(ActionEvent event) {
        // Logic for requesting application status update
        switchScene(event, "RequestStatusUpdate.fxml");
    }

    // Method to handle "Pay Consultation Fees" button click
    @FXML
    private void handlePayConsultationFees(ActionEvent event) {
        // Logic for paying consultation fees
        switchScene(event, "PayConsultationFees.fxml");
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
