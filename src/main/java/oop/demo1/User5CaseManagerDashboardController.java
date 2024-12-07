package oop.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class User5CaseManagerDashboardController {

    @FXML
    private void handleTrackClientProgress(ActionEvent event) {
        System.out.println("Navigating to Track Client Case Progress...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User5Scene2.fxml");
    }

    @FXML
    private void handleAssignCase(ActionEvent event) {
        System.out.println("Assigning Case to Legal Adviser...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/AssignCase.fxml");
    }

    @FXML
    private void handleCaseCompletion(ActionEvent event) {
        System.out.println("Confirming Case Completion...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/CaseCompletion.fxml");
    }

    @FXML
    private void handleClientEscalations(ActionEvent event) {
        System.out.println("Handling Client Escalations...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/ClientEscalations.fxml");
    }

    @FXML
    private void handleGenerateReports(ActionEvent event) {
        System.out.println("Generating Case Reports...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/GenerateReports.fxml");
    }

    @FXML
    private void handleMonitorTimelines(ActionEvent event) {
        System.out.println("Monitoring Case Timelines...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/MonitorTimelines.fxml");
    }

    @FXML
    private void handleCoordinateDepartments(ActionEvent event) {
        System.out.println("Coordinating Between Departments...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/CoordinateDepartments.fxml");
    }

    @FXML
    private void handleArchiveCases(ActionEvent event) {
        System.out.println("Archiving Completed Cases...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/ArchiveCases.fxml");
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
