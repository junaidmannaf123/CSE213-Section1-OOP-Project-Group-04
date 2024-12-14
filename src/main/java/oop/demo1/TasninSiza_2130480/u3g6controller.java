package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class u3g6controller {

    @FXML
    private TableView<Query> queryTable;

    @FXML
    private TableColumn<Query, String> queryColumn;

    @FXML
    private TableColumn<Query, String> statusColumn;

    @FXML
    private TextArea responseTextArea;

    @FXML
    private Label statusLabel;

    @FXML
    private Button updateButton;

    @FXML
    private void initialize() {
        if (queryColumn == null || statusColumn == null) {
            System.out.println("Error: TableColumns not properly initialized.");
            return;
        }

        // Initialize the TableColumn with data
        queryColumn.setCellValueFactory(cellData -> cellData.getValue().queryProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        // Add default queries
        queryTable.getItems().add(new Query("How to register for a service?", "Pending"));
        queryTable.getItems().add(new Query("What are the available services?", "Pending"));

        // Set initial label text
        statusLabel.setText("Select a query and provide a response.");
    }

    @FXML
    private void handleResponseChange() {
        String response = responseTextArea.getText();
        if (!response.trim().isEmpty()) {
            statusLabel.setText("Response entered.");
        } else {
            statusLabel.setText("Enter a response to update the query.");
        }
    }

    @FXML
    private void handleUpdate(ActionEvent event) {
        Query selectedQuery = queryTable.getSelectionModel().getSelectedItem();
        String response = responseTextArea.getText();

        // Check if a query is selected
        if (selectedQuery == null) {
            statusLabel.setText("Error: No query selected.");
            System.out.println("Error: No query selected.");
            return;
        }

        // Validate the response input
        if (response == null || response.trim().isEmpty()) {
            statusLabel.setText("Error: Response cannot be empty.");
            System.out.println("Error: Response is empty.");
            return;
        }

        // Update query status and print the result
        selectedQuery.setStatus("Answered");
        System.out.println("Query: " + selectedQuery.getQuery());
        System.out.println("Response: " + response);

        // Update the status label
        statusLabel.setText("Query updated successfully.");
        System.out.println("Query updated successfully.");

        // Clear the response field
        responseTextArea.clear();
    }

    public static class Query {
        private final javafx.beans.property.StringProperty query;
        private final javafx.beans.property.StringProperty status;

        public Query(String query, String status) {
            this.query = new javafx.beans.property.SimpleStringProperty(query);
            this.status = new javafx.beans.property.SimpleStringProperty(status);
        }

        public String getQuery() {
            return query.get();
        }

        public javafx.beans.property.StringProperty queryProperty() {
            return query;
        }

        public void setQuery(String query) {
            this.query.set(query);
        }

        public String getStatus() {
            return status.get();
        }

        public javafx.beans.property.StringProperty statusProperty() {
            return status;
        }

        public void setStatus(String status) {
            this.status.set(status);
        }
    }
}
