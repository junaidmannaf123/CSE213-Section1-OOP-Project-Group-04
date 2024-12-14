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
        System.out.println("Submit Immigration Application selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g1.fxml");
    }

    @FXML
    private void handleBookConsultation(ActionEvent event) {
        System.out.println("Book Consultation Appointment with Immigration Consultant selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g2.fxml");
    }

    @FXML
    private void handleTrackApplication(ActionEvent event) {
        System.out.println("Track Application Status selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g3.fxml");
    }

    @FXML
    private void handleUploadDocuments(ActionEvent event) {
        System.out.println("Upload Additional Documents for Ongoing Application selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g4.fxml");
    }

    @FXML
    private void handleVisaConsultation(ActionEvent event) {
        System.out.println("Receive Visa Refusal Consultation selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g5.fxml");
    }

    @FXML
    private void handleDownloadNotes(ActionEvent event) {
        System.out.println("Download Consultation Notes selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g6.fxml");
    }

    @FXML
    private void handleRequestStatusUpdate(ActionEvent event) {
        System.out.println("Request for Application Status Update selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g7.fxml");
    }

    @FXML
    private void handlePayConsultationFees(ActionEvent event) {
        System.out.println("Pay Consultation Fees selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g8.fxml");
    }

    @FXML
    private void handleBackToLogin(ActionEvent event) {
        try {
            // Load the Login scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/oop/demo1/LoginScene.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("Navigating back to the Login scene...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while navigating back to Login scene: " + e.getMessage());
        }
    }

    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
