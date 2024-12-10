package oop.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class User7Goal1Controller {

    @FXML
    private ComboBox<String> listOfFlaggedComplexCasesComboBox;

    @FXML
    private TextArea caseDetailsTextArea;

    @FXML
    private void handleSubmitNotes(ActionEvent event) {
        System.out.println("Submit Notes button clicked.");
        // Logic for submitting notes
        String selectedCase = listOfFlaggedComplexCasesComboBox.getValue();
        String notes = caseDetailsTextArea.getText();
        System.out.println("Submitting notes for case: " + selectedCase + ", Notes: " + notes);
    }

    @FXML
    private void handleUpdateStatusAndNotify(ActionEvent event) {
        System.out.println("Update Status and Notify button clicked.");
        // Logic for updating status and notifying
        String selectedCase = listOfFlaggedComplexCasesComboBox.getValue();
        System.out.println("Updating status for case: " + selectedCase);
    }

    @FXML
    private void handleBackToDashboard(ActionEvent event) {
        System.out.println("Navigating back to Dashboard...");
        try {
            // Load the FXML file for the dashboard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/oop/demo1/Sanjida Akter Jui/user7dashboard.fxml"));
            Parent root = loader.load();

            // Get the current stage and set the new scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
            stage.show();
            System.out.println("Dashboard scene successfully loaded.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
