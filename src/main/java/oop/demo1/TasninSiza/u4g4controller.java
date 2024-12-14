package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

public class u4g4controller {

    @FXML
    private ComboBox<String> documentTypeComboBox;

    /**
     * This method handles the action of uploading a file.
     */
    @FXML
    private void handleUpload(ActionEvent event) {
        String selectedDocumentType = documentTypeComboBox.getValue();

        if (selectedDocumentType == null || selectedDocumentType.isEmpty()) {
            // Show an alert if no document type is selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Selection");
            alert.setHeaderText("Document Type Missing");
            alert.setContentText("Please select a document type before uploading.");
            alert.showAndWait();
            return;
        }

        // Simulate file upload logic
        System.out.println("Uploading file for document type: " + selectedDocumentType);

        // Provide user feedback
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("File Uploaded");
        alert.setHeaderText("Upload Successful");
        alert.setContentText("File uploaded successfully for document type: " + selectedDocumentType);
        alert.showAndWait();
    }

    /**
     * This method handles the action of submitting the uploaded documents.
     */
    @FXML
    private void handleSubmit(ActionEvent event) {
        String selectedDocumentType = documentTypeComboBox.getValue();

        if (selectedDocumentType == null || selectedDocumentType.isEmpty()) {
            // Show an alert if no document type is selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Selection");
            alert.setHeaderText("Document Type Missing");
            alert.setContentText("Please select a document type before submitting.");
            alert.showAndWait();
            return;
        }

        // Simulate document submission logic
        System.out.println("Submitting uploaded document for type: " + selectedDocumentType);

        // Provide user feedback
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Submission Successful");
        alert.setHeaderText("Documents Submitted");
        alert.setContentText("Documents for type '" + selectedDocumentType + "' have been submitted successfully.");
        alert.showAndWait();
    }

    /**
     * Initialize the ComboBox with predefined document types.
     * This method is called automatically when the controller is loaded.
     */
    @FXML
    public void initialize() {
        // Add predefined document types to the ComboBox
        documentTypeComboBox.getItems().addAll(
                "Passport",
                "Visa",
                "Proof of Address",
                "Bank Statement",
                "Other"
        );

        System.out.println("Controller initialized and document types loaded.");
    }
}
