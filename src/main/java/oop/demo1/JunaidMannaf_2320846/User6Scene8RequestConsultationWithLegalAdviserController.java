package oop.demo1.JunaidMannaf_2320846;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class User6Scene8RequestConsultationWithLegalAdviserController {

    @FXML
    private ComboBox<String> legalIssueComboBox;

    @FXML
    private DatePicker consultationDatePicker;

    @FXML
    private Button requestConsultationButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Button backButton;

    @FXML
    public void initialize() {

        legalIssueComboBox.getItems().addAll(
                "Contract Dispute",
                "Property Law Issue",
                "Employment Issue",
                "Intellectual Property"
        );
    }

    @FXML
    void handleRequestConsultation(ActionEvent event) {
        String selectedIssue = legalIssueComboBox.getValue();
        LocalDate selectedDate = consultationDatePicker.getValue();

        if (selectedIssue == null || selectedIssue.isEmpty()) {
            statusLabel.setText("Please select a legal issue.");
        } else if (selectedDate == null) {
            statusLabel.setText("Please select a consultation date.");
        } else {
            statusLabel.setText("Consultation requested for " + selectedIssue + " on " + selectedDate + ".");
        }
    }

    @FXML
    private void handleBack(ActionEvent event) {
        System.out.println("Navigating back to the previous screen...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6ClientFSDashboard.fxml");
    }

    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while switching scenes: " + e.getMessage());
        }
    }
}