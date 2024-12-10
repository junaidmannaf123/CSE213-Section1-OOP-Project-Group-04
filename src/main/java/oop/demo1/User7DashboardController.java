package oop.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class User7DashboardController {

    @FXML
    private void handleReviewComplImmCases(ActionEvent event) {
        System.out.println("Review Complex Immigration Cases button clicked.");
        // Add logic here
    }

    @FXML
    private void handleProvideLegalSupport(ActionEvent event) {
        System.out.println("Provide Legal Support for Visa Appeals button clicked.");
        // Add logic here
    }

    @FXML
    private void handlePrepareSponsorship(ActionEvent event) {
        System.out.println("Prepare Sponsorship Legal Documents button clicked.");
        // Add logic here
    }

    @FXML
    private void handleScheduleLegalConsultation(ActionEvent event) {
        System.out.println("Schedule Legal Consultation with Clients button clicked.");
        // Add logic here
    }

    @FXML
    private void handleUpdateLegalAdvice(ActionEvent event) {
        System.out.println("Update Legal Advice for Ongoing Cases button clicked.");
        // Add logic here
    }

    @FXML
    private void handleDraftVisaAppeals(ActionEvent event) {
        System.out.println("Draft Visa Refusal Appeals button clicked.");
        // Add logic here
    }

    @FXML
    private void handleReviewCompliance(ActionEvent event) {
        System.out.println("Review Legal Compliance for Documents button clicked.");
        // Add logic here
    }

    @FXML
    private void handleConductLegalResearch(ActionEvent event) {
        System.out.println("Conduct Legal Research for Immigration Policy Changes button clicked.");
        // Add logic here
    }
    @FXML
    private void handleBackToLogin(ActionEvent event) {
        try {
            // Load the Login scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("Navigating back to the Login scene...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while navigating back to Login scene: " + e.getMessage());
        }
        System.out.println("Navigating back to Login scene...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/LoginScene.fxml");
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
