package oop.demo1.JunaidMannaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class User5Scene8CoordinateBetweenDepartmentsController implements Initializable {

    @FXML
    private TableView<String> departmentTasksTable;

    @FXML
    private TableColumn<String, String> departmentColumn;

    @FXML
    private TableColumn<String, String> taskColumn;

    @FXML
    private TableColumn<String, String> statusColumn;

    @FXML
    private Label statusLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Placeholder for table initialization
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
}
