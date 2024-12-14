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
        System.out.println("Initial Consultation selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g1.fxml");
    }

    @FXML
    private void handleDocumentPreparation(ActionEvent event) {
        System.out.println("Document Preparation selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g2.fxml");
    }

    @FXML
    private void handleClientProgress(ActionEvent event) {
        System.out.println("Monitor Progress selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g3.fxml");
    }

    @FXML
    private void handleLegalGuidance(ActionEvent event) {
        System.out.println("Legal Guidance selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g4.fxml");
    }

    @FXML
    private void handleSettlementConsultation(ActionEvent event) {
        System.out.println("Settlement Consultation selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g5.fxml");
    }

    @FXML
    private void handleClientQueries(ActionEvent event) {
        System.out.println("Client Queries selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g6.fxml");
    }

    @FXML
    private void handleVisaRefusal(ActionEvent event) {
        System.out.println("Visa Refusal selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g7.fxml");
    }

    @FXML
    private void handleClientWorkshops(ActionEvent event) {
        System.out.println("Organize Workshops selected.");
        switchScene(event, "/oop/demo1/Tasnin Siza/u3g8.fxml");
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
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
