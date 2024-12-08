package oop.demo1;

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
        switchScene(event, "InitialConsultation.fxml");
    }

    @FXML
    private void handleDocumentPreparation(ActionEvent event) {
        System.out.println("Assist with Document Preparation selected.");
        switchScene(event, "DocumentPreparation.fxml");
    }

    @FXML
    private void handleClientProgress(ActionEvent event) {
        System.out.println("Monitor Client Progress selected.");
        switchScene(event, "ClientProgress.fxml");
    }

    @FXML
    private void handleLegalGuidance(ActionEvent event) {
        System.out.println("Provide Legal Guidance on Complex selected.");
        switchScene(event, "LegalGuidance.fxml");
    }

    @FXML
    private void handleSettlementConsultation(ActionEvent event) {
        System.out.println("Offer Settlement Consultation selected.");
        switchScene(event, "SettlementConsultation.fxml");
    }

    @FXML
    private void handleClientQueries(ActionEvent event) {
        System.out.println("Manage Client Queries and Follow-ups selected.");
        switchScene(event, "ClientQueries.fxml");
    }

    @FXML
    private void handleVisaRefusal(ActionEvent event) {
        System.out.println("Provide Visa Refusal Consultation selected.");
        switchScene(event, "VisaRefusal.fxml");
    }

    @FXML
    private void handleClientWorkshops(ActionEvent event) {
        System.out.println("Organize Client Workshops selected.");
        switchScene(event, "ClientWorkshops.fxml");
    }

    @FXML
    private void handleBackToLogin(ActionEvent event) {
        System.out.println("Navigating back to login.");
        switchScene(event, "Login.fxml");
    }

    // Helper method to switch scenes
    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
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
