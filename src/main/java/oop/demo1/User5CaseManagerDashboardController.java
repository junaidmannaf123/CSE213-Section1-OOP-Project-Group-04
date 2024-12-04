package oop.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class User5CaseManagerDashboardController {

    // Method to handle "Track Client Case Progress" button click
    @FXML
    private void handleTrackClientProgress(ActionEvent event) {
        System.out.println("Tracking Client Case Progress...");
        switchScene(event, "TrackClientProgress.fxml");
    }

    // Method to handle "Assign Case to Legal Adviser" button click
    @FXML
    private void handleAssignCase(ActionEvent event) {
        System.out.println("Assigning Case to Legal Adviser...");
        switchScene(event, "AssignCase.fxml");
    }

    // Method to handle "Case Completion Confirmation" button click
    @FXML
    private void handleCaseCompletion(ActionEvent event) {
        System.out.println("Confirming Case Completion...");
        switchScene(event, "CaseCompletion.fxml");
    }

    // Method to handle "Handle Client Escalations" button click
    @FXML
    private void handleClientEscalations(ActionEvent event) {
        System.out.println("Handling Client Escalations...");
        switchScene(event, "ClientEscalations.fxml");
    }

    // Method to handle "Generate Case Reports" button click
    @FXML
    private void handleGenerateReports(ActionEvent event) {
        System.out.println("Generating Case Reports...");
        switchScene(event, "GenerateReports.fxml");
    }

    // Method to handle "Monitor Case Timelines" button click
    @FXML
    private void handleMonitorTimelines(ActionEvent event) {
        System.out.println("Monitoring Case Timelines...");
        switchScene(event, "MonitorTimelines.fxml");
    }

    // Method to handle "Coordinate Between Departments" button click
    @FXML
    private void handleCoordinateDepartments(ActionEvent event) {
        System.out.println("Coordinating Between Departments...");
        switchScene(event, "CoordinateDepartments.fxml");
    }

    // Method to handle "Archive Completed Cases" button click
    @FXML
    private void handleArchiveCases(ActionEvent event) {
        System.out.println("Archiving Completed Cases...");
        switchScene(event, "ArchiveCases.fxml");
    }

    // Method to handle "Back to Login" button click
    @FXML
    private void handleBackToLogin(ActionEvent event) {
        try {
            // Load the Login scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            stage.setScene(new Scene(root));
            stage.show();

            System.out.println("Navigating back to the Login scene...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while navigating back to Login scene: " + e.getMessage());
        }
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
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
