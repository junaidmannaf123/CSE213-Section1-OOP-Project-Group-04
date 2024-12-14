package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class u3dashboardcontroller {

    @FXML
    private void handleInitialConsultation(ActionEvent event) {
        System.out.println("Provide Initial Consultation for Immigration Applicants selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g1.fxml");
    }

    @FXML
    private void handleDocumentPreparation(ActionEvent event) {
        System.out.println("Assist with Document Preparation selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g2.fxml");
    }

    @FXML
    private void handleClientProgress(ActionEvent event) {
        System.out.println("Monitor Client Progress selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g3.fxml");
    }

    @FXML
    private void handleLegalGuidance(ActionEvent event) {
        System.out.println("Provide Legal Guidance on Complex selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g4.fxml");
    }

    @FXML
    private void handleSettlementConsultation(ActionEvent event) {
        System.out.println("Offer Settlement Consultation selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g5.fxml");
    }

    @FXML
    private void handleClientQueries(ActionEvent event) {
        System.out.println("Manage Client Queries and Follow-ups selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g6.fxml");
    }

    @FXML
    private void handleVisaRefusal(ActionEvent event) {
        System.out.println("Provide Visa Refusal Consultation selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g7.fxml");
    }

    @FXML
    private void handleClientWorkshops(ActionEvent event) {
        System.out.println("Organize Client Workshops selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g8.fxml");
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
        System.out.println("Navigating back to Login scene...");
        switchScene(event, "/oop/demo1/Tasnin Siza/LoginScene.fxml");
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
