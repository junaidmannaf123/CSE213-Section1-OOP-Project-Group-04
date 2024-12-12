package oop.demo1.JunaidMannaf;

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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class User6Scene5DownloadSponsorshipGuidelinesController {

    @FXML
    private ComboBox<String> guidelinesComboBox;

    @FXML
    private Button downloadButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        // Add three options to the ComboBox
        guidelinesComboBox.getItems().addAll(
                "General Sponsorship Guidelines",
                "Business Sponsorship Guidelines",
                "Family Sponsorship Guidelines"
        );
        guidelinesComboBox.getSelectionModel().selectFirst(); // Select the first item by default
    }

    @FXML
    void handleDownloadGuidelines(ActionEvent event) {
        String selectedGuideline = guidelinesComboBox.getValue();
        String fileName;

        // Map selected guideline to corresponding file
        switch (selectedGuideline) {
            case "General Sponsorship Guidelines":
                fileName = "src/main/resources/static/General_Sponsorship_Guidelines.pdf";
                break;
            case "Business Sponsorship Guidelines":
                fileName = "/Business_Sponsorship_Guidelines.pdf";
                break;
            case "Family Sponsorship Guidelines":
                fileName = "/Family_Sponsorship_Guidelines.pdf";
                break;
            default:
                statusLabel.setText("Error: Invalid selection.");
                return;
        }

        // Open file chooser to save the file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        fileChooser.setInitialFileName(selectedGuideline + ".pdf");
        File saveFile = fileChooser.showSaveDialog(downloadButton.getScene().getWindow());

        if (saveFile != null) {
            try (InputStream inputStream = getClass().getResourceAsStream(fileName);
                 FileOutputStream outputStream = new FileOutputStream(saveFile)) {

                if (inputStream != null) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    statusLabel.setText("Downloaded: " + saveFile.getName());
                } else {
                    statusLabel.setText("Error: File not found.");
                }
            } catch (IOException e) {
                statusLabel.setText("Error saving the file.");
                e.printStackTrace();
            }
        } else {
            statusLabel.setText("Download canceled.");
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