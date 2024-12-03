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
        // Logic for tracking client case progress
        System.out.println("Tracking Client Case Progress...");

        // Switch to the 'TrackClientProgress.fxml' scene
        switchScene(event, "TrackClientProgress.fxml");
    }

    // Method to handle "Assign Case to Legal Adviser" button click
    @FXML
    private void handleAssignCase(ActionEvent event) {
        // Logic for assigning the case
        System.out.println("Assigning Case to Legal Adviser...");

        // Switch to the 'AssignCase.fxml' scene
        switchScene(event, "AssignCase.fxml");
    }

    // Method to handle "Case Completion Confirmation" button click
    @FXML
    private void handleCaseCompletion(ActionEvent event) {
        // Logic for confirming case completion
        System.out.println("Confirming Case Completion...");

        // Switch to the 'CaseCompletion.fxml' scene
        switchScene(event, "CaseCompletion.fxml");
    }

    // Method to handle "Handle Client Escalations" button click
    @FXML
    private void handleClientEscalations(ActionEvent event) {
        // Logic for handling client escalations
        System.out.println("Handling Client Escalations...");

        // Switch to the 'ClientEscalations.fxml' scene
        switchScene(event, "ClientEscalations.fxml");
    }

    // Method to handle "Generate Case Reports" button click
    @FXML
    private void handleGenerateReports(ActionEvent event) {
        // Logic for generating case reports
        System.out.println("Generating Case Reports...");

        // Switch to the 'GenerateReports.fxml' scene
        switchScene(event, "GenerateReports.fxml");
    }

    // Method to handle "Monitor Case Timelines" button click
    @FXML
    private void handleMonitorTimelines(ActionEvent event) {
        // Logic for monitoring case timelines
        System.out.println("Monitoring Case Timelines...");

        // Switch to the 'MonitorTimelines.fxml' scene
        switchScene(event, "MonitorTimelines.fxml");
    }

    // Method to handle "Coordinate Between Departments" button click
    @FXML
    private void handleCoordinateDepartments(ActionEvent event) {
        // Logic for coordinating between departments
        System.out.println("Coordinating Between Departments...");

        // Switch to the 'CoordinateDepartments.fxml' scene
        switchScene(event, "CoordinateDepartments.fxml");
    }

    // Method to handle "Archive Completed Cases" button click
    @FXML
    private void handleArchiveCases(ActionEvent event) {
        // Logic for archiving completed cases
        System.out.println("Archiving Completed Cases...");

        // Switch to the 'ArchiveCases.fxml' scene
        switchScene(event, "ArchiveCases.fxml");
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
