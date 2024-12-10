package oop.demo1;

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

public class User5Scene6GenerateClientCaseReportsController implements Initializable {

    @FXML
    private ComboBox<String> clientCaseComboBox;

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
    }

    // Handle "Generate Report" button click
    @FXML
    private void handleGenerateReport(ActionEvent event) {
        String selectedCase = clientCaseComboBox.getValue();
        if (selectedCase == null) {
            statusLabel.setText("Please select a client case to generate a report.");
        } else {
            statusLabel.setText("Report generated for case: " + selectedCase);
            System.out.println("Generated report for: " + selectedCase);
        }
    }

    // Handle "Export as PDF" button click
    @FXML
    private void handleExportPDF(ActionEvent event) {
        String selectedCase = clientCaseComboBox.getValue();
        if (selectedCase == null) {
            statusLabel.setText("Please select a client case to export as PDF.");
        } else {
            statusLabel.setText("Report for case '" + selectedCase + "' exported as PDF.");
            System.out.println("Exported report as PDF for: " + selectedCase);
        }
    }

    // Handle "Send to Client/Consultant" button click
    @FXML
    private void handleSendReport(ActionEvent event) {
        String selectedCase = clientCaseComboBox.getValue();
        if (selectedCase == null) {
            statusLabel.setText("Please select a client case to send the report.");
        } else {
            statusLabel.setText("Report for case '" + selectedCase + "' sent to client/consultant.");
            System.out.println("Sent report for: " + selectedCase);
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
