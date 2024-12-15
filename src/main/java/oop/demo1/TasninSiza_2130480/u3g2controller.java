package oop.demo1.TasninSiza_2130480;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableView<Document> documentsTableView;

    @FXML
    private TableColumn<Document, String> documentNameColumn;

    @FXML
    private TableColumn<Document, String> statusColumn;

    @FXML
    private TextArea feedbackTextArea;

    private final ObservableList<Document> allDocuments = FXCollections.observableArrayList();
    private final ObservableList<Document> filteredDocuments = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        clientComboBox.getItems().addAll("Client A", "Client B", "Client C");


        documentNameColumn.setCellValueFactory(new PropertyValueFactory<>("documentName"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));


        allDocuments.addAll(
                new Document("Passport Copy", "Pending", "Client A"),
                new Document("Visa Application", "Approved", "Client A"),
                new Document("Bank Statement", "Pending", "Client B"),
                new Document("Proof of Address", "Rejected", "Client B"),
                new Document("Employment Letter", "Approved", "Client C")
        );


        documentsTableView.setItems(allDocuments);
    }


    @FXML
    private void handleClientSelection() {
        String selectedClient = clientComboBox.getValue();
        System.out.println("Selected client: " + selectedClient);

        if (selectedClient == null) {

            documentsTableView.setItems(allDocuments);
        } else {

            filteredDocuments.clear();
            for (Document doc : allDocuments) {
                if (doc.getClient().equals(selectedClient)) {
                    filteredDocuments.add(doc);
                }
            }
            documentsTableView.setItems(filteredDocuments);
        }
    }


    @FXML
    private void handleFeedbackChange() {
        String feedback = feedbackTextArea.getText();
        System.out.println("Feedback updated: " + feedback);

    }

    @FXML
    private void handleChooseFile() {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select File to Upload");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Files", "*.*"),
                    new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                    new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png")
            );

            Stage stage = (Stage) clientComboBox.getScene().getWindow();
            File selectedFile = fileChooser.showOpenDialog(stage);

            if (selectedFile != null) {
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            } else {
                System.out.println("File selection canceled.");
            }
        } catch (Exception e) {
            System.out.println("Error during file selection: " + e.getMessage());
        }
    }

    @FXML
    private void handleSendFeedback() {
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

        System.out.println("Sending feedback for " + client + ": " + feedback);

        System.out.println("Feedback sent successfully!");
    }

    public static class Document {
        private final String documentName;
        private final String status;
        private final String client;

        public Document(String documentName, String status, String client) {
            this.documentName = documentName;
            this.status = status;
            this.client = client;
        }

        public String getDocumentName() {
            return documentName;
        }

        public String getStatus() {
            return status;
        }

        public String getClient() {
            return client;
        }
    }
}
