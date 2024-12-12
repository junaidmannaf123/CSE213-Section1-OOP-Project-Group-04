package oop.demo1.JunaidMannaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

public class User5Scene9ArchiveCompletedCasesController {

    @FXML
    private ComboBox<String> completedCaseComboBox;

    @FXML
    private Label statusLabel;

    // This method is called when the scene is initialized
    @FXML
    public void initialize() {
        // Adding sample cases to the ComboBox
        completedCaseComboBox.setItems(FXCollections.observableArrayList(
                "Case #12345 - John Doe",
                "Case #12346 - Jane Smith",
                "Case #12347 - Bob Johnson",
                "Case #12348 - Alice Williams"
        ));
    }

    // Handle "Notify Client" button click
    @FXML
    private void handleNotifyClient(ActionEvent event) {
        String selectedCase = completedCaseComboBox.getValue();

        if (selectedCase == null) {
            statusLabel.setText("Please select a completed case.");
        } else {
            statusLabel.setText("Notification sent to client regarding case: " + selectedCase);
            System.out.println("Notified client about case: " + selectedCase);
        }
    }

    // Handle "Archive Case" button click
    @FXML
    private void handleArchiveCase(ActionEvent event) {
        String selectedCase = completedCaseComboBox.getValue();

        if (selectedCase == null) {
            statusLabel.setText("Please select a completed case.");
        } else {
            statusLabel.setText("Case '" + selectedCase + "' has been archived.");
            System.out.println("Archived case: " + selectedCase);
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
