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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class User5Scene7MonitorCaseTimelinesController implements Initializable {

    @FXML
    private ComboBox<String> clientCaseComboBox;

    @FXML
    private TableView<String> caseTimelineTable;

    @FXML
    private TableColumn<String, String> milestoneColumn;

    @FXML
    private TableColumn<String, String> dueDateColumn;

    @FXML
    private TableColumn<String, String> statusColumn;

    @FXML
    private Label statusLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Populate ComboBox with sample client cases
        clientCaseComboBox.getItems().addAll(
                "Case 201: Immigration Sponsorship",
                "Case 202: Legal Document Review",
                "Case 203: Visa Application Assistance",
                "Case 204: Citizenship Process"
        );

        // Set placeholder for TableView
        caseTimelineTable.setPlaceholder(new Label("No milestones to display. Please select a case."));
    }

    // Handle "Send Follow-Up Notification" button click
    @FXML
    private void handleSendFollowUpNotification(ActionEvent event) {
        String selectedCase = clientCaseComboBox.getValue();
        if (selectedCase == null) {
            statusLabel.setText("Please select a client case before sending a notification.");
        } else {
            statusLabel.setText("Follow-up notification sent for case: " + selectedCase);
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
