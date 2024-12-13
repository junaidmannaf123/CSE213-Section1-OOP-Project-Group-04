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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class User5Scene8CoordinateBetweenDepartmentsController implements Initializable {

    @FXML
    private TableView<DepartmentTask> departmentTasksTable;

    @FXML
    private TableColumn<DepartmentTask, String> departmentColumn;

    @FXML
    private TableColumn<DepartmentTask, String> taskColumn;

    @FXML
    private TableColumn<DepartmentTask, String> statusColumn;

    @FXML
    private Label statusLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set up TableView columns
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        taskColumn.setCellValueFactory(new PropertyValueFactory<>("task"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Populate TableView with sample data
        ObservableList<DepartmentTask> departmentTasks = FXCollections.observableArrayList(
                new DepartmentTask("Immigration Consultant", "Review Application", "Pending"),
                new DepartmentTask("Immigration Applicant", "Submit Documents", "Completed"),
                new DepartmentTask("Case Manager", "Track Case Progress", "In Progress"),
                new DepartmentTask("Client (Sponsorship)", "Provide Financial Proof", "Pending"),
                new DepartmentTask("Legal Advisor", "Review Legal Documents", "Completed"),
                new DepartmentTask("IT Support", "Resolve Portal Issues", "In Progress")
        );
        departmentTasksTable.setItems(departmentTasks);

        // Set placeholder for empty table
        departmentTasksTable.setPlaceholder(new Label("No tasks to display. Add tasks to manage department coordination."));
    }

    // Handle "Send Internal Message" button click
    @FXML
    private void handleSendInternalMessage(ActionEvent event) {
        // Logic to send an internal message
        statusLabel.setText("Internal message sent to the selected department.");
        System.out.println("Internal message sent.");
    }

    // Handle "Update Client" button click
    @FXML
    private void handleUpdateClient(ActionEvent event) {
        // Logic to update client
        statusLabel.setText("Client updated with the latest department status.");
        System.out.println("Client updated.");
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

    // Inner class to represent department tasks
    public static class DepartmentTask {
        private final String department;
        private final String task;
        private final String status;

        public DepartmentTask(String department, String task, String status) {
            this.department = department;
            this.task = task;
            this.status = status;
        }

        public String getDepartment() {
            return department;
        }

        public String getTask() {
            return task;
        }

        public String getStatus() {
            return status;
        }
    }
}
