package oop.demo1.JunaidMannaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class User6ClientFSDashboardController {

    @FXML
    private void handleSubmitSponsorship(ActionEvent event) {
        System.out.println("Sponsorship application submitted.");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6Scene2.fxml");
    }

    @FXML
    private void handleTrackSponsorship(ActionEvent event) {
        System.out.println("Tracking sponsorship status.");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6Scene3.fxml");
    }

    @FXML
    private void handleUploadDocuments(ActionEvent event) {
        System.out.println("Uploading additional documents.");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6Scene4.fxml");
    }

    @FXML
    private void handleScheduleConsultation(ActionEvent event) {
        System.out.println("Scheduling consultation.");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6Scene6.fxml");
    }

    @FXML
    private void handleDownloadGuidelines(ActionEvent event) {
        System.out.println("Downloading guidelines.");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6Scene5.fxml");
    }

    @FXML
    private void handleSubmitPayment(ActionEvent event) {
        System.out.println("Submitting payment.");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6Scene7.fxml");
    }

    @FXML
    private void handleRequestLegalConsultation(ActionEvent event) {
        System.out.println("Requesting legal consultation.");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6Scene8.fxml");
    }

    @FXML
    private void handleUploadFinancialEvidence(ActionEvent event) {
        System.out.println("Uploading financial evidence.");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6Scene9.fxml");
    }
    @FXML
    private void handleBackToLogin(ActionEvent event) {
        try {
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

            Scene newScene = new Scene(root);
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
