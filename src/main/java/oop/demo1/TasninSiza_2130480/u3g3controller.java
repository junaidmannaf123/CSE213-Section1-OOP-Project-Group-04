package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class u3g3controller {

    @FXML
    private ComboBox<String> clientComboBox;

    @FXML
    private TableView<?> progressTrackerTable;

    @FXML
    private TableColumn<?, ?> milestoneColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;

    @FXML
    private TableColumn<?, ?> deadlineColumn;

    @FXML
    private void initialize() {
        // Sample data for ComboBox
        clientComboBox.getItems().addAll("Client A", "Client B", "Client C");

        // Initialize the TableView and columns with sample data (can be replaced with dynamic data)
        milestoneColumn.setText("Milestone");
        statusColumn.setText("Status");
        deadlineColumn.setText("Deadline");

        // You can populate the table with data here if needed
    }

    /**
     * Handles client selection from the ComboBox.
     */
    @FXML
    private void handleClientSelection() {
        String selectedClient = clientComboBox.getValue();
        System.out.println("Selected client: " + selectedClient);

        // Add logic to populate the progress tracker table based on the selected client
        // For example, fetch progress milestones related to the client
    }

    /**
     * Handles the action when "Send Updates" button is clicked.
     */
    @FXML
    private void handleSendUpdates(ActionEvent event) {
        String selectedClient = clientComboBox.getValue();

        if (selectedClient == null || selectedClient.isEmpty()) {
            System.out.println("No client selected. Updates cannot be sent.");
            return;
        }

        // Logic to send updates to the selected client
        // For example, you might want to collect progress data from the table and send it

        System.out.println("Sending updates for client: " + selectedClient);

        // Example: show confirmation or perform other actions (e.g., email, database update)
        System.out.println("Updates sent successfully!");
    }
}
