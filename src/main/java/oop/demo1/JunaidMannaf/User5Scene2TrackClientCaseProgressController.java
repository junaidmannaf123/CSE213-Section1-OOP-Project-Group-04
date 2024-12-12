package oop.demo1.JunaidMannaf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class User5Scene2TrackClientCaseProgressController {

    @FXML
    private ComboBox<String> clientCaseComboBox;

    @FXML
    private TableView<CaseProgress> progressTableView;

    @FXML
    private TableColumn<CaseProgress, String> documentColumn;

    @FXML
    private TableColumn<CaseProgress, String> legalReviewColumn;

    @FXML
    private TableColumn<CaseProgress, String> overallProgressColumn;

    @FXML
    private Button sendUpdateButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        // Populate ComboBox with sample data
        ObservableList<String> clientCases = FXCollections.observableArrayList(
                "Case #001: John Doe",
                "Case #002: Jane Smith",
                "Case #003: Michael Johnson",
                "Case #004: Emily Davis"
        );
        clientCaseComboBox.setItems(clientCases);

        // Set up TableView columns
        documentColumn.setCellValueFactory(new PropertyValueFactory<>("documentStatus"));
        legalReviewColumn.setCellValueFactory(new PropertyValueFactory<>("legalReviewStatus"));
        overallProgressColumn.setCellValueFactory(new PropertyValueFactory<>("overallProgress"));

        // Populate TableView with sample data
        ObservableList<CaseProgress> caseProgressList = FXCollections.observableArrayList(
                new CaseProgress("Submitted", "Pending", "25%"),
                new CaseProgress("Verified", "In Progress", "50%"),
                new CaseProgress("Pending", "Pending", "10%"),
                new CaseProgress("Submitted", "Completed", "90%")
        );
        progressTableView.setItems(caseProgressList);
    }

    @FXML
    private void handleSendUpdate(ActionEvent event) {
        String selectedCase = clientCaseComboBox.getValue();
        if (selectedCase == null) {
            statusLabel.setText("Please select a client case to send an update.");
        } else {
            statusLabel.setText("Update sent successfully for " + selectedCase + ".");
        }
    }

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

    public static class CaseProgress {
        private final String documentStatus;
        private final String legalReviewStatus;
        private final String overallProgress;

        public CaseProgress(String documentStatus, String legalReviewStatus, String overallProgress) {
            this.documentStatus = documentStatus;
            this.legalReviewStatus = legalReviewStatus;
            this.overallProgress = overallProgress;
        }

        public String getDocumentStatus() {
            return documentStatus;
        }

        public String getLegalReviewStatus() {
            return legalReviewStatus;
        }

        public String getOverallProgress() {
            return overallProgress;
        }
    }
}
