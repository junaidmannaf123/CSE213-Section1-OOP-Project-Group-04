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
        // Sample data for the query table
        queryColumn.setCellValueFactory(cellData -> cellData.getValue().queryProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        // Adding some dummy queries to the table
        queryTable.getItems().add(new Query("How to register for a service?", "Pending"));
        queryTable.getItems().add(new Query("What are the available services?", "Pending"));
    }

    /**
     * Handles the response text change in the TextArea.
     */
    @FXML
    private void handleResponseChange() {
        String response = responseTextArea.getText();
        if (!response.isEmpty()) {
            statusLabel.setText("Response provided.");
        } else {
            statusLabel.setText("Enter response to update query.");
        }
    }

    /**
     * Handles the update button click action to update the query status.
     */
    @FXML
    private void handleUpdate(ActionEvent event) {
        Query selectedQuery = queryTable.getSelectionModel().getSelectedItem();
        if (selectedQuery != null && !responseTextArea.getText().isEmpty()) {
            // Update the status of the selected query
            selectedQuery.setStatus("Answered");
            statusLabel.setText("Query updated successfully.");

            // Optionally, you can also store the response text in the query object
            String response = responseTextArea.getText();
            System.out.println("Response for query: " + selectedQuery.getQuery());
            System.out.println("Response: " + response);

            // Clear the response text area after update
            responseTextArea.clear();
        } else {
            statusLabel.setText("Select a query and enter a response.");
        }
    }

    // Inner class for Query object
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
