package oop.demo1.JunaidMannaf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class User5Scene7MonitorCaseTimelinesController implements Initializable {

    @FXML
    private ComboBox<String> clientCaseComboBox;

    @FXML
    private TableView<TimelineEntry> caseTimelineTable;

    @FXML
    private TableColumn<TimelineEntry, String> milestoneColumn;

    @FXML
    private TableColumn<TimelineEntry, String> dueDateColumn;

    @FXML
    private TableColumn<TimelineEntry, String> statusColumn;

    @FXML
    private Label statusLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Populate ComboBox with sample client cases
        clientCaseComboBox.getItems().addAll(
                "Case #001: Immigration Sponsorship",
                "Case #002: Legal Document Review",
                "Case #003: Visa Application Assistance",
                "Case #004: Citizenship Process"
        );

        // Set up table columns
        milestoneColumn.setCellValueFactory(new PropertyValueFactory<>("milestone"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Set placeholder for TableView
        caseTimelineTable.setPlaceholder(new Label("No milestones to display. Please select a case."));

        // Add listener for ComboBox selection changes
        clientCaseComboBox.setOnAction(event -> populateTable(clientCaseComboBox.getValue()));
    }

    // Populate the table based on the selected case
    private void populateTable(String selectedCase) {
        ObservableList<TimelineEntry> data = FXCollections.observableArrayList();

        switch (selectedCase) {
            case "Case 201: Immigration Sponsorship":
                data.add(new TimelineEntry("Submit Documents", "2024-12-15", "Pending"));
                data.add(new TimelineEntry("Interview Scheduled", "2025-01-10", "Scheduled"));
                data.add(new TimelineEntry("Decision Received", "2025-02-20", "In Progress"));
                break;

            case "Case 202: Legal Document Review":
                data.add(new TimelineEntry("Submit Contract", "2024-12-18", "Completed"));
                data.add(new TimelineEntry("Review Feedback", "2024-12-20", "Pending"));
                data.add(new TimelineEntry("Approval Received", "2024-12-25", "Pending"));
                break;

            case "Case 203: Visa Application Assistance":
                data.add(new TimelineEntry("Application Submission", "2024-12-10", "Completed"));
                data.add(new TimelineEntry("Biometrics Appointment", "2024-12-20", "Scheduled"));
                data.add(new TimelineEntry("Visa Approval", "2025-01-15", "Pending"));
                break;

            case "Case 204: Citizenship Process":
                data.add(new TimelineEntry("Submit Application", "2024-12-05", "Completed"));
                data.add(new TimelineEntry("Oath Ceremony", "2025-01-20", "Scheduled"));
                data.add(new TimelineEntry("Certificate Issued", "2025-01-25", "Pending"));
                break;

            default:
                data.clear();
                break;
        }

        // Update TableView
        caseTimelineTable.setItems(data);
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

    // Timeline entry data model
    public static class TimelineEntry {
        private final String milestone;
        private final String dueDate;
        private final String status;

        public TimelineEntry(String milestone, String dueDate, String status) {
            this.milestone = milestone;
            this.dueDate = dueDate;
            this.status = status;
        }

        public String getMilestone() {
            return milestone;
        }

        public String getDueDate() {
            return dueDate;
        }

        public String getStatus() {
            return status;
        }
    }
}
