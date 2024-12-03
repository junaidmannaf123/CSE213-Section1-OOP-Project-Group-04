package oop.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginSceneController implements Initializable {

    @FXML
    private TextField loginIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> userTypeComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Populate ComboBox with user types
        userTypeComboBox.getItems().addAll(
                "Immigration Consultant",
                "Immigration Applicant",
                "Case Manager",
                "Client (Family Sponsorship)",
                "Legal Advisor",
                "IT Support"
        );
    }

    @FXML
    private void handleLogin() {
        // Get the values entered by the user
        String loginId = loginIdField.getText();
        String password = passwordField.getText();
        String userType = userTypeComboBox.getValue();

        // Validate the input fields
        if (loginId == null || loginId.isEmpty() ||
                password == null || password.isEmpty() ||
                userType == null) {
            showAlert("Validation Error", "All fields are required!", Alert.AlertType.ERROR);
            return;
        }

        // Switch scene based on user type
        switch (userType) {
            case "Immigration Consultant":
                switchToDashboard("u3dashboard.fxml", "Immigration Consultant Dashboard");
                break;
            case "Immigration Applicant":
                switchToDashboard("u4dashboard.fxml", "Immigration Applicant Dashboard");
                break;
            case "Case Manager":
                switchToDashboard("Junaid Mannaf/User5CaseManagerDashboard.fxml", "Case Manager Dashboard");
                break;
            case "Client (Family Sponsorship)":
                switchToDashboard("Junaid Mannaf/User6ClientFSDashboard.fxml", "Client Dashboard");
                break;
            case "Legal Advisor":
                switchToDashboard("user7coverpage.fxml", "Legal Advisor Dashboard");
                break;
            case "IT Support":
                switchToDashboard("user8coverpage.fxml", "IT Support Dashboard");
                break;
            default:
                showAlert("Access Denied", "Unknown user type.", Alert.AlertType.ERROR);
                break;
        }
    }

    private void switchToDashboard(String fxmlFile, String title) {
        try {
            // Load the dashboard scene using the correct FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile)); // Load the correct dashboard
            Parent root = loader.load(); // Load the FXML

            // Set the new scene
            Stage stage = (Stage) loginIdField.getScene().getWindow(); // Get the current window
            Scene scene = new Scene(root); // Use the loaded root (dashboard scene)
            stage.setScene(scene); // Set the new scene
            stage.setTitle(title); // Set the title of the new scene
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Unable to load the " + title + ".", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
