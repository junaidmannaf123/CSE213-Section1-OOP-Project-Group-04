package oop.demo1.JunaidMannaf_2320846;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.net.URL;
import java.util.ResourceBundle;

public class User5Scene3AssignCaseToLegalAdviserController implements Initializable {

    @FXML
    private ComboBox<String> clientCaseComboBox;

    @FXML
    private ComboBox<String> legalAdviserComboBox;

    @FXML
    private Label statusLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientCaseComboBox.getItems().addAll(
                "Case 001: Immigration Sponsorship",
                "Case 002: Refugee Application",
                "Case 003: Family Reunification",
                "Case 004: Employment Authorization"
        );

        legalAdviserComboBox.getItems().addAll(
                "John Smith - Senior Adviser",
                "Jane Miller - Immigration Specialist",
                "Alice Johnson - Legal Consultant",
                "Bob Brown - Case Analyst"
        );
    }

    @FXML
    private void handleAssignCase(ActionEvent event) {
        String clientCase = clientCaseComboBox.getValue();
        String legalAdviser = legalAdviserComboBox.getValue();

        if (clientCase == null || legalAdviser == null) {
            statusLabel.setText("Please select both a client case and a legal adviser.");
        } else {
            statusLabel.setText("Case '" + clientCase + "' has been assigned to '" + legalAdviser + "'.");
            System.out.println("Assigned " + clientCase + " to " + legalAdviser);
        }
    }

    @FXML
    private void handleSendNotification(ActionEvent event) {
        String legalAdviser = legalAdviserComboBox.getValue();

        if (legalAdviser == null) {
            statusLabel.setText("Please assign a legal adviser before sending a notification.");
        } else {
            statusLabel.setText("Notification sent to '" + legalAdviser + "'.");
            System.out.println("Notification sent to " + legalAdviser);
        }
    }

    @FXML
    private void handleBack(ActionEvent event) {
        System.out.println("Navigating back to Dashboard...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User5CaseManagerDashboard.fxml");
    }

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
