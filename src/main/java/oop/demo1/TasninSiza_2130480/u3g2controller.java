package oop.demo1.TasninSiza_2130480;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class u3g2controller {

    @FXML
    private ComboBox<String> clientComboBox;

    @FXML
    private TableView<DocumentData> documentsTableView;

    @FXML
    private TableColumn<DocumentData, String> documentNameColumn;

    @FXML
    private TableColumn<DocumentData, String> statusColumn;

    @FXML
    private TextArea feedbackTextArea;

    private File selectedFile; // To store the selected file for upload

    /**
     * Initializes the controller and sets up data.
     */
    @FXML
    private void initialize() {
        // Add sample clients to the ComboBox
        clientComboBox.getItems().addAll("Client A", "Client B", "Client C");

        // Set up the TableView columns
        documentNameColumn.setCellValueFactory(new PropertyValueFactory<>("documentName"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Placeholder for TableView when no data is available
        documentsTableView.setPlaceholder(new javafx.scene.control.Label("No documents uploaded yet."));
    }

    /**
     * Handles the selection of a client from the ComboBox.
     */
    @FXML
    private void handleClientSelection() {
        String selectedClient = clientComboBox.getValue();
        System.out.println("Selected client: " + selectedClient);

        if (selectedClient != null) {
            // Populate TableView with mock document data for the selected client
            ObservableList<DocumentData> documentData = FXCollections.observableArrayList();

            switch (selectedClient) {
                case "Client A":
                    documentData.addAll(
                            new DocumentData("Passport Copy", "Uploaded"),
                            new DocumentData("Visa Application", "Pending")
                    );
                    break;

                case "Client B":
                    documentData.addAll(
                            new DocumentData("Bank Statement", "Uploaded"),
                            new DocumentData("Proof of Address", "Pending")
                    );
                    break;

                case "Client C":
                    documentData.addAll(
                            new DocumentData("Employment Letter", "Uploaded"),
                            new DocumentData("Educational Certificate", "Pending")
                    );
                    break;
            }

            documentsTableView.setItems(documentData);
        } else {
            System.out.println("No client selected.");
        }
    }

    /**
     * Handles feedback text updates when typed in the TextArea.
     */
    @FXML
    private void handleFeedbackChange() {
        String feedback = feedbackTextArea.getText();
        System.out.println("Feedback updated: " + feedback);
    }

    /**
     * Handles the file selection action when "Choose File" is clicked.
     */
    @FXML
    private void handleChooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File to Upload");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        Stage stage = (Stage) feedbackTextArea.getScene().getWindow(); // Use any component to get the Stage
        selectedFile = fileChooser.showOpenDialog(stage);

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

        // Validate client selection
        if (client == null || client.isEmpty()) {
            System.out.println("Error: No client selected. Feedback cannot be sent.");
            return;
        }

        // Validate feedback input
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("Error: Feedback is empty. Please enter feedback.");
            return;
        }

        // Simulate feedback sending logic
        System.out.println("Sending feedback for " + client + ": " + feedback);

        // Provide confirmation
        System.out.println("Feedback sent successfully!");
    }

    /**
     * Data model class for documents in the TableView.
     */
    public static class DocumentData {
        private final String documentName;
        private final String status;

        public DocumentData(String documentName, String status) {
            this.documentName = documentName;
            this.status = status;
        }

        public String getDocumentName() {
            return documentName;
        }

        public String getStatus() {
            return status;
        }
    }
}
