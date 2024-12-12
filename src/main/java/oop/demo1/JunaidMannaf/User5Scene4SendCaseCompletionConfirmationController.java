package oop.demo1.JunaidMannaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class User5Scene4SendCaseCompletionConfirmationController implements Initializable {

    @FXML
    private ComboBox<String> completedCaseComboBox;

    @FXML
    private Label statusLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Populate the ComboBox with sample completed cases
        completedCaseComboBox.getItems().addAll(
                "Case 001: Immigration Sponsorship",
                "Case 002: Refugee Application",
                "Case 003: Family Reunification",
                "Case 004: Employment Authorization"
        );
    }

    // Handle "Mark As Complete" button click
    @FXML
    private void handleMarkAsComplete(ActionEvent event) {
        String selectedCase = completedCaseComboBox.getValue();

        if (selectedCase == null) {
            statusLabel.setText("Please select a completed case.");
        } else {
            statusLabel.setText("Case '" + selectedCase + "' marked as complete.");
            System.out.println("Marked as complete: " + selectedCase);
        }
    }

    // Handle "Send Notification" button click
    @FXML
    private void handleSendNotification(ActionEvent event) {
        String selectedCase = completedCaseComboBox.getValue();

        if (selectedCase == null) {
            statusLabel.setText("Please select a completed case before sending a notification.");
        } else {
            statusLabel.setText("Notification sent for case: '" + selectedCase + "'.");
            System.out.println("Notification sent for: " + selectedCase);
        }
    }

    // Handle "Back" button click
    @FXML
    private void handleBackToDashboard(ActionEvent event) {
        System.out.println("Navigating back to Dashboard...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User5CaseManagerDashboard.fxml");
    }

    // Helper method to switch scenes
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

