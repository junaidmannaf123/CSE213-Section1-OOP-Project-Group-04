package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class u4g4controller {

    @FXML
    private ComboBox<String> documentTypeComboBox;

    @FXML
    private Label statusLabel;

    @FXML
    private void handleUpload(ActionEvent event) {
        // Get the selected document type
        String selectedDocumentType = documentTypeComboBox.getValue();

        if (selectedDocumentType == null || selectedDocumentType.isEmpty()) {
            // Show warning alert if no document type is selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Selection");
            alert.setHeaderText("Document Type Missing");
            alert.setContentText("Please select a document type before uploading.");
            alert.showAndWait();
            return;
        }

        // Log the upload action
        System.out.println("Uploading file for document type: " + selectedDocumentType);

        // Show success alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("File Uploaded");
        alert.setHeaderText("Upload Successful");
        alert.setContentText("File uploaded successfully for document type: " + selectedDocumentType);
        alert.showAndWait();

        // Update the status label
        statusLabel.setText("File uploaded for: " + selectedDocumentType);
    }

    @FXML
    private void handleSubmit(ActionEvent event) {
        // Get the selected document type
        String selectedDocumentType = documentTypeComboBox.getValue();

        if (selectedDocumentType == null || selectedDocumentType.isEmpty()) {
            // Show warning alert if no document type is selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Selection");
            alert.setHeaderText("Document Type Missing");
            alert.setContentText("Please select a document type before submitting.");
            alert.showAndWait();
            return;
        }

        // Log the submission action
        System.out.println("Submitting uploaded document for type: " + selectedDocumentType);

        // Show success alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Submission Successful");
        alert.setHeaderText("Documents Submitted");
        alert.setContentText("Documents for type '" + selectedDocumentType + "' have been submitted successfully.");
        alert.showAndWait();

        // Update the status label
        statusLabel.setText("Documents submitted for: " + selectedDocumentType);
    }

    @FXML
    public void initialize() {
        // Populate the ComboBox with document types
        documentTypeComboBox.getItems().addAll(
                "Passport",
                "Visa",
                "Proof of Address",
                "Bank Statement",
                "Other"
        );

        // Set the initial status label text
        statusLabel.setText("Please select a document type.");
        System.out.println("Controller initialized and document types loaded.");
    }
}
