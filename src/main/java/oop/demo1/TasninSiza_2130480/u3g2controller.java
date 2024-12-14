package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class u3g2controller {

    @FXML
    private ComboBox<String> clientComboBox;

    @FXML
    private TableView<?> documentsTableView;

    @FXML
    private TableColumn<?, ?> documentNameColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;

    @FXML
    private TextArea feedbackTextArea;

    @FXML
    private void initialize() {
        // Add sample data to ComboBox for testing
        clientComboBox.getItems().addAll("Client A", "Client B", "Client C");

        // Initialize document table columns if required
        // For example, set CellValueFactory here if TableView is being populated
    }

    /**
     * Handles the selection of a client from the ComboBox.
     */
    @FXML
    private void handleClientSelection() {
        String selectedClient = clientComboBox.getValue();
        System.out.println("Selected client: " + selectedClient);

        // Add logic to load documents or related data for the selected client
    }

    /**
     * Handles feedback text updates when typed in the TextArea.
     */
    @FXML
    private void handleFeedbackChange() {
        String feedback = feedbackTextArea.getText();
        System.out.println("Feedback updated: " + feedback);

        // Add any logic such as auto-saving or validation if needed
    }

    /**
     * Handles the file selection action when "Choose File" is clicked.
     */
    @FXML
    private void handleChooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File to Upload");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png")
        );

        Stage stage = (Stage) feedbackTextArea.getScene().getWindow(); // Use any component to get the Stage
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        } else {
            System.out.println("File selection canceled.");
        }
    }

    /**
     * Handles the action when "Send Feedback" button is clicked.
     */
    @FXML
    private void handleSendFeedback(ActionEvent event) {
        String feedback = feedbackTextArea.getText();
        String client = clientComboBox.getValue();

        if (client == null || client.isEmpty()) {
            System.out.println("No client selected. Feedback cannot be sent.");
            return;
        }

        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No feedback entered. Feedback cannot be sent.");
            return;
        }

        // Simulate sending feedback
        System.out.println("Sending feedback for " + client + ": " + feedback);

        // Example: Provide user feedback
        System.out.println("Feedback sent successfully!");
    }
}
