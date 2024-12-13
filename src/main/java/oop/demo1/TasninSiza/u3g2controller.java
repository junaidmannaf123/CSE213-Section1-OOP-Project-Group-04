package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.File;

public class u3g2controller {

    @FXML
    private ComboBox<String> clientComboBox;

    @FXML
    private TextArea feedbackTextArea;

    @FXML
    private Button chooseFileButton;

    @FXML
    private Button sendFeedbackButton;

    @FXML
    private TableView<?> documentTableView;

    @FXML
    private Button backButton;

    @FXML
    private Label fileUploadLabel;

    // Variable to hold the selected file
    private File selectedFile;

    // Method to handle file selection
    @FXML
    private void handleChooseFile(ActionEvent event) {
        oop.demo1.TasninSiza.FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("All Files", "*.*"));
        selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            fileUploadLabel.setText("File: " + selectedFile.getName());
        }
    }

    // Method to handle sending feedback
    @FXML
    private void handleSendFeedback(ActionEvent event) {
        String selectedClient = clientComboBox.getValue();
        String feedback = feedbackTextArea.getText();

        if (selectedClient != null && !feedback.isEmpty()) {
            System.out.println("Sending feedback for client: " + selectedClient);
            System.out.println("Feedback: " + feedback);
            if (selectedFile != null) {
                System.out.println("Uploaded file: " + selectedFile.getName());
            } else {
                System.out.println("No file uploaded.");
            }
            // Here you can add logic to send the feedback, such as saving it or sending it to a server
        } else {
            System.out.println("Please select a client and enter feedback.");
        }
    }

    // Method to handle going back to the previous screen (login screen)
    @FXML
    private void handleBackToLogin(ActionEvent event) {
        System.out.println("Navigating back to the login screen.");

        // Switching to the login screen
        switchScene(event, "Login.fxml");
    }

    // Helper method to switch scenes
    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            // Load the FXML file for the target scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
