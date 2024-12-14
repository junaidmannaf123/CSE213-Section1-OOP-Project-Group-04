package oop.demo1.JunaidMannaf_2320846;

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
        ObservableList<String> clientCases = FXCollections.observableArrayList(
                "Case #001: John Doe",
                "Case #002: Jane Smith",
                "Case #003: Michael Johnson",
                "Case #004: Emily Davis"
        );
        clientCaseComboBox.setItems(clientCases);

        documentColumn.setCellValueFactory(new PropertyValueFactory<>("documentStatus"));
        legalReviewColumn.setCellValueFactory(new PropertyValueFactory<>("legalReviewStatus"));
        overallProgressColumn.setCellValueFactory(new PropertyValueFactory<>("overallProgress"));

        progressTableView.setPlaceholder(new Label("Select a case to view progress."));

        clientCaseComboBox.setOnAction(event -> updateTableData(clientCaseComboBox.getValue()));
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

    private void updateTableData(String selectedCase) {
        ObservableList<CaseProgress> caseProgressList = FXCollections.observableArrayList();

        switch (selectedCase) {
            case "Case #001: John Doe":
                caseProgressList.addAll(
                        new CaseProgress("Submitted", "Pending", "25%"),
                        new CaseProgress("Verified", "In Progress", "50%"),
                        new CaseProgress("Approved", "Completed", "100%")
                );
                break;

            case "Case #002: Jane Smith":
                caseProgressList.addAll(
                        new CaseProgress("Submitted", "Pending", "20%"),
                        new CaseProgress("Under Review", "In Progress", "60%"),
                        new CaseProgress("Awaiting Approval", "Pending", "70%")
                );
                break;

            case "Case #003: Michael Johnson":
                caseProgressList.addAll(
                        new CaseProgress("Drafted", "Pending", "15%"),
                        new CaseProgress("Submitted", "In Progress", "40%"),
                        new CaseProgress("Under Legal Review", "Pending", "75%")
                );
                break;

            case "Case #004: Emily Davis":
                caseProgressList.addAll(
                        new CaseProgress("Submitted", "Pending", "30%"),
                        new CaseProgress("Reviewed", "Completed", "80%"),
                        new CaseProgress("Approved", "Completed", "100%")
                );
                break;

            default:
                caseProgressList.clear();
                break;
        }

        progressTableView.setItems(caseProgressList);
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
