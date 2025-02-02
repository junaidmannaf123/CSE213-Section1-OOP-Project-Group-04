package oop.demo1.TasninSiza_2130480;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class u3g3controller {

    @FXML
    private ComboBox<String> clientComboBox;

    @FXML
    private TableView<ProgressData> progressTrackerTable;

    @FXML
    private TableColumn<ProgressData, String> milestoneColumn;

    @FXML
    private TableColumn<ProgressData, String> statusColumn;

    @FXML
    private TableColumn<ProgressData, String> deadlineColumn;

    @FXML
    private void initialize() {

        clientComboBox.getItems().addAll("Client A", "Client B", "Client C");


        milestoneColumn.setCellValueFactory(new PropertyValueFactory<>("milestone"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));


        progressTrackerTable.setPlaceholder(new javafx.scene.control.Label("Select a client to view progress."));
    }


    @FXML
    private void handleClientSelection() {
        String selectedClient = clientComboBox.getValue();
        System.out.println("Selected client: " + selectedClient);


        ObservableList<ProgressData> progressData = FXCollections.observableArrayList();

        switch (selectedClient) {
            case "Client A":
                progressData.addAll(
                        new ProgressData("Submit Documents", "Completed", "2024-01-15"),
                        new ProgressData("Legal Review", "In Progress", "2024-01-30"),
                        new ProgressData("Final Approval", "Pending", "2024-02-10")
                );
                break;

            case "Client B":
                progressData.addAll(
                        new ProgressData("Initial Submission", "Completed", "2024-01-10"),
                        new ProgressData("Case Review", "In Progress", "2024-01-25"),
                        new ProgressData("Final Decision", "Pending", "2024-02-05")
                );
                break;

            case "Client C":
                progressData.addAll(
                        new ProgressData("Application Submission", "Completed", "2024-01-20"),
                        new ProgressData("Verification", "Pending", "2024-02-01"),
                        new ProgressData("Approval", "Pending", "2024-02-15")
                );
                break;

            default:
                progressData.clear();
                break;
        }

        progressTrackerTable.setItems(progressData);
    }


    @FXML
    private void handleSendUpdates(ActionEvent event) {
        String selectedClient = clientComboBox.getValue();

        if (selectedClient == null || selectedClient.isEmpty()) {
            System.out.println("No client selected. Updates cannot be sent.");
            return;
        }



        System.out.println("Sending updates for client: " + selectedClient);
        System.out.println("Updates sent successfully!");
    }


    public static class ProgressData {
        private final String milestone;
        private final String status;
        private final String deadline;

        public ProgressData(String milestone, String status, String deadline) {
            this.milestone = milestone;
            this.status = status;
            this.deadline = deadline;
        }

        public String getMilestone() {
            return milestone;
        }

        public String getStatus() {
            return status;
        }

        public String getDeadline() {
            return deadline;
        }
    }
}
