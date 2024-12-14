package oop.demo1.TasninSiza_2130480;

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
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g1.fxml");
    }

    @FXML
    private void handleBookConsultation(ActionEvent event) {
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g2.fxml");
    }

    @FXML
    private void handleTrackApplication(ActionEvent event) {
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g3.fxml");
    }

    @FXML
    private void handleUploadDocuments(ActionEvent event) {
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g4.fxml");
    }

    @FXML
    private void handleVisaConsultation(ActionEvent event) {
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g5.fxml");
    }

    @FXML
    private void handleDownloadNotes(ActionEvent event) {
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g6.fxml");
    }

    @FXML
    private void handleRequestStatusUpdate(ActionEvent event) {
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g7.fxml");
    }

    @FXML
    private void handlePayConsultationFees(ActionEvent event) {
        switchScene(event, "/oop/demo1/Tasnin Siza/u4g8.fxml");
    }

    @FXML
    private void handleBackToLogin(ActionEvent event) {
        switchScene(event, "/oop/demo1/LoginScene.fxml");
    }

    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            System.out.println("Switched to: " + fxmlFile);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error switching scene to: " + fxmlFile + "\n" + e.getMessage());
        }
    }
}
