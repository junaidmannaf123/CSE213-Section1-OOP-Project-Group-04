package oop.demo1.JunaidMannaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class User6Scene2SubmitSponsorshipApplicationController {

    @FXML
    private ComboBox<String> sponsorshipTypeComboBox;

    @FXML
    private TextField familyMemberNameTextField;

    @FXML
    private Label statusLabel;

    // This method is called when the scene is initialized
    @FXML
    public void initialize() {
        // Add sample sponsorship types to the ComboBox
        sponsorshipTypeComboBox.getItems().addAll(
                "Family Sponsorship",
                "Work Sponsorship",
                "Education Sponsorship"
        );
    }

    // Handle "Upload Documents" button click
    @FXML
    private void handleUploadDocuments(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload Documents");
        File selectedFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

        if (selectedFile != null) {
            statusLabel.setText("Uploaded: " + selectedFile.getName());
            System.out.println("Uploaded file: " + selectedFile.getAbsolutePath());
        } else {
            statusLabel.setText("No file selected.");
            System.out.println("No file selected.");
        }
    }

    // Handle "Submit Application" button click
    @FXML
    private void handleSubmitApplication(ActionEvent event) {
        String sponsorshipType = sponsorshipTypeComboBox.getValue();
        String familyMemberName = familyMemberNameTextField.getText();

        if (sponsorshipType == null || sponsorshipType.isEmpty()) {
            statusLabel.setText("Please select a sponsorship type.");
        } else if (familyMemberName == null || familyMemberName.isEmpty()) {
            statusLabel.setText("Please enter family member's name.");
        } else {
            statusLabel.setText("Application submitted successfully!");
            System.out.println("Sponsorship Type: " + sponsorshipType);
            System.out.println("Family Member's Name: " + familyMemberName);
        }
    }

    // Handle "Back" button click
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
