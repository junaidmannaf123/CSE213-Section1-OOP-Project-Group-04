package oop.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class User6Scene9UploadEvidenceOfFinancialSupportController {

    @FXML
    private ComboBox<String> documentTypeComboBox;

    @FXML
    private Button uploadDocumentButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Button backButton;

    @FXML
    public void initialize() {
        // Populate the ComboBox with predefined document types
        documentTypeComboBox.getItems().addAll(
                "Bank Statement",
                "Sponsorship Letter",
                "Proof of Employment",
                "Scholarship Letter"
        );
    }

    @FXML
    void handleUploadDocument(ActionEvent event) {
        String selectedDocumentType = documentTypeComboBox.getValue();

        if (selectedDocumentType == null || selectedDocumentType.isEmpty()) {
            statusLabel.setText("Please select a document type.");
        } else {
            // Open file chooser to upload the document
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Upload Document");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
            );

            Stage stage = (Stage) uploadDocumentButton.getScene().getWindow();
            File selectedFile = fileChooser.showOpenDialog(stage);

            if (selectedFile != null) {
                // Placeholder logic for uploading the file
                statusLabel.setText("Uploaded " + selectedDocumentType + " successfully.");
            } else {
                statusLabel.setText("File upload canceled.");
            }
        }
    }

    /// Handle "Back" button click
    @FXML
    private void handleBack(ActionEvent event) {
        System.out.println("Navigating back to the previous screen...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6ClientFSDashboard.fxml");
    }

    // Helper method to switch scenes
    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
