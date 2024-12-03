package oop.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class User6ClientFSDashboardController {

    // Action methods for buttons

    @FXML
    private void handleSubmitSponsorship(ActionEvent event) {
        // Handle submit sponsorship application action
        System.out.println("Sponsorship application submitted.");
        // You can switch to another scene if needed
        switchScene(event, "SubmitSponsorshipApplication.fxml");
    }

    @FXML
    private void handleTrackSponsorship(ActionEvent event) {
        // Handle track sponsorship status action
        System.out.println("Tracking sponsorship status.");
        // Switch to another scene if necessary
        switchScene(event, "TrackSponsorshipStatus.fxml");
    }

    @FXML
    private void handleUploadDocuments(ActionEvent event) {
        // Handle upload additional documents action
        System.out.println("Uploading additional documents.");
        // Switch to another scene if necessary
        switchScene(event, "UploadDocuments.fxml");
    }

    @FXML
    private void handleScheduleConsultation(ActionEvent event) {
        // Handle schedule consultation action
        System.out.println("Scheduling consultation.");
        // Switch to another scene if necessary
        switchScene(event, "ScheduleConsultation.fxml");
    }

    @FXML
    private void handleDownloadGuidelines(ActionEvent event) {
        // Handle download guidelines action
        System.out.println("Downloading guidelines.");
        // Switch to another scene if necessary
        switchScene(event, "DownloadGuidelines.fxml");
    }

    @FXML
    private void handleSubmitPayment(ActionEvent event) {
        // Handle submit payment action
        System.out.println("Submitting payment.");
        // Switch to another scene if necessary
        switchScene(event, "SubmitPayment.fxml");
    }

    @FXML
    private void handleRequestLegalConsultation(ActionEvent event) {
        // Handle request legal consultation action
        System.out.println("Requesting legal consultation.");
        // Switch to another scene if necessary
        switchScene(event, "RequestLegalConsultation.fxml");
    }

    @FXML
    private void handleUploadFinancialEvidence(ActionEvent event) {
        // Handle upload financial evidence action
        System.out.println("Uploading financial evidence.");
        // Switch to another scene if necessary
        switchScene(event, "UploadFinancialEvidence.fxml");
    }

    // Helper method to switch scenes
    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            // Load the FXML file for the new scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
