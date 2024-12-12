package oop.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class User6Scene4UploadAdditionalDocumentsController {

    @FXML
    private ComboBox<String> documentTypeComboBox;

    @FXML
    private Label statusLabel;

    // Initialize the ComboBox with sample document types
    @FXML
    public void initialize() {
        documentTypeComboBox.getItems().addAll("Passport Copy", "Birth Certificate", "Proof of Residency", "Other");
    }

    // Handle the "Upload Document" button click
    @FXML
    private void handleUploadDocument(ActionEvent event) {
        if (documentTypeComboBox.getValue() == null) {
            statusLabel.setText("Please select a document type.");
            return;
        }

        // Open a file chooser to allow the user to select a file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Document");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        Stage stage = new Stage(); // You might need to replace this with the current stage reference
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            // Simulate file upload
            statusLabel.setText("Document uploaded successfully: " + selectedFile.getName());
        } else {
            statusLabel.setText("No file selected.");
        }
    }

    /// Handle "Back" button click
    @FXML
    private void handleBack(ActionEvent event) {
        System.out.println("Navigating back to the previous screen...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6ClientFSDashboard.fxml"); // Replace with the actual FXML file for the dashboard
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
