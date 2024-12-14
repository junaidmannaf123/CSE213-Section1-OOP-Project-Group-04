package oop.demo1.JunaidMannaf_2320846;

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

public class User5Scene5HandleClientEscalationsController implements Initializable {

    @FXML
    private ComboBox<String> escalatedCaseComboBox;

    @FXML
    private Label statusLabel;

    @FXML
    private Label notificationLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        escalatedCaseComboBox.getItems().addAll(
                "Case #001: Sponsorship Delay",
                "Case #002: Missing Documents",
                "Case #003: Legal Adviser Unavailable",
                "Case #004: Urgent Processing Required"
        );
    }

    @FXML
    private void handleAssignToConsultant(ActionEvent event) {
        String selectedCase = escalatedCaseComboBox.getValue();

        if (selectedCase == null) {
            statusLabel.setText("Please select an escalated case.");
        } else {
            statusLabel.setText("Case '" + selectedCase + "' assigned to a consultant/adviser.");
            System.out.println("Assigned escalated case: " + selectedCase);
        }
    }

    @FXML
    private void handleFollowUpNotification(ActionEvent event) {
        String selectedCase = escalatedCaseComboBox.getValue();

        if (selectedCase == null) {
            notificationLabel.setText("Please select an escalated case before sending a notification.");
        } else {
            notificationLabel.setText("Follow-up notification sent for case: '" + selectedCase + "'.");
            System.out.println("Follow-up notification sent for: " + selectedCase);
        }
    }

    @FXML
    private void handleBackToDashboard(ActionEvent event) {
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
