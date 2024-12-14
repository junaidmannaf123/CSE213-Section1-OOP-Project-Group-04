package oop.demo1.SanjidaAkterJui_2320087;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class User8DashboardController {

    @FXML
    private void handleManageUserAccounts(ActionEvent event) {
        System.out.println("Manage User Accounts button clicked.");
        // Add logic here
    }

    @FXML
    private void handleResolveSystemErrors(ActionEvent event) {
        System.out.println("Resolve System Errors button clicked.");
        // Add logic here
    }

    @FXML
    private void handleMonitorSystemPerformance(ActionEvent event) {
        System.out.println("Monitor System Performance button clicked.");
        // Add logic here
    }

    @FXML
    private void handleManageDataBackups(ActionEvent event) {
        System.out.println("Manage Data Backups button clicked.");
        // Add logic here
    }

    @FXML
    private void handleTroubleshootUserIssues(ActionEvent event) {
        System.out.println("Troubleshoot User Issues button clicked.");
        // Add logic here
    }

    @FXML
    private void handleUpdateSystemSecurity(ActionEvent event) {
        System.out.println("Update System Security button clicked.");
        // Add logic here
    }

    @FXML
    private void handleManageSystemPermissions(ActionEvent event) {
        System.out.println("Manage System Permissions button clicked.");
        // Add logic here
    }

    @FXML
    private void handleManageDatabaseConnections(ActionEvent event) {
        System.out.println("Manage Database Connections button clicked.");
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
        switchScene(event, "/oop/demo1/LoginScene.fxml");
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
