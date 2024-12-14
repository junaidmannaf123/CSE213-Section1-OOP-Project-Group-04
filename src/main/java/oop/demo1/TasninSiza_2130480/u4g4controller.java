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

        String selectedDocumentType = documentTypeComboBox.getValue();

        if (selectedDocumentType == null || selectedDocumentType.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Selection");
            alert.setHeaderText("Document Type Missing");
            alert.setContentText("Please select a document type before uploading.");
            alert.showAndWait();
            return;
        }


        System.out.println("Uploading file for document type: " + selectedDocumentType);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("File Uploaded");
        alert.setHeaderText("Upload Successful");
        alert.setContentText("File uploaded successfully for document type: " + selectedDocumentType);
        alert.showAndWait();


        statusLabel.setText("File uploaded for: " + selectedDocumentType);
    }

    @FXML
    private void handleSubmit(ActionEvent event) {

        String selectedDocumentType = documentTypeComboBox.getValue();

        if (selectedDocumentType == null || selectedDocumentType.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Selection");
            alert.setHeaderText("Document Type Missing");
            alert.setContentText("Please select a document type before submitting.");
            alert.showAndWait();
            return;
        }


        System.out.println("Submitting uploaded document for type: " + selectedDocumentType);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Submission Successful");
        alert.setHeaderText("Documents Submitted");
        alert.setContentText("Documents for type '" + selectedDocumentType + "' have been submitted successfully.");
        alert.showAndWait();


        statusLabel.setText("Documents submitted for: " + selectedDocumentType);
    }

    @FXML
    public void initialize() {

        documentTypeComboBox.getItems().addAll(
                "Passport",
                "Visa",
                "Proof of Address",
                "Bank Statement",
                "Other"
        );


        statusLabel.setText("Please select a document type.");
        System.out.println("Controller initialized and document types loaded.");
    }
}
