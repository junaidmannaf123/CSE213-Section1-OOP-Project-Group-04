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
        userTypeComboBox.getItems().addAll(
                "Immigration Consultant",
                "Immigration Applicant",
                "Case Manager",
                "Client (Sponsorship)",
                "Legal Advisor",
                "IT Support"
        );
    }

    @FXML
    private void handleLogin() {
        String loginId = loginIdField.getText();
        String password = passwordField.getText();
        String userType = userTypeComboBox.getValue();

        // Debugging Logs
        System.out.println("Login ID: " + loginId);
        System.out.println("Password: " + password);
        System.out.println("User Type: " + userType);

        if (loginId == null || loginId.isEmpty() ||
                password == null || password.isEmpty() ||
                userType == null || userType.isEmpty()) {
            showAlert("Validation Error", "All fields are required!", Alert.AlertType.ERROR);
            return;
        }

        boolean isAuthenticated = false;
        switch (userType) {
            case "Immigration Consultant":
                isAuthenticated = loginId.equals("consultant01") && password.equals("ic123");
                break;
            case "Immigration Applicant":
                isAuthenticated = loginId.equals("applicant01") && password.equals("ia123");
                break;
            case "Case Manager":
                isAuthenticated = loginId.equals("manager01") && password.equals("cm123");
                break;
            case "Client (Sponsorship)":
                isAuthenticated = loginId.equals("client01") && password.equals("cfs123");
                break;
            case "Legal Advisor":
                isAuthenticated = loginId.equals("advisor01") && password.equals("la123");
                break;
            case "IT Support":
                isAuthenticated = loginId.equals("support01") && password.equals("its123");
                break;
            default:
                showAlert("Access Denied", "Unknown user type.", Alert.AlertType.ERROR);
                return;
        }

        if (!isAuthenticated) {
            showAlert("Login Failed", "Invalid login credentials.", Alert.AlertType.ERROR);
            return;
        }

        System.out.println("Login successful for user type: " + userType);

        switch (userType) {
            case "Immigration Consultant":
                switchToDashboard("Tasnin Siza/u3dashboard.fxml", "Immigration Consultant Dashboard");
                break;
            case "Immigration Applicant":
                switchToDashboard("Tasnin Siza/u4dashboard.fxml", "Immigration Applicant Dashboard");
                break;
            case "Case Manager":
                switchToDashboard("Junaid Mannaf/User5CaseManagerDashboard.fxml", "Case Manager Dashboard");
                break;
            case "Client (Sponsorship)":
                switchToDashboard("Junaid Mannaf/User6ClientFSDashboard.fxml", "Client Dashboard");
                break;
            case "Legal Advisor":
                switchToDashboard("Sanjida Akter Jui/user7dashboard.fxml", "Legal Advisor Dashboard");
                break;
            case "IT Support":
                switchToDashboard("Sanjida Akter Jui/user8dashboard.fxml", "IT Support Dashboard");
                break;
        }
    }

    private void switchToDashboard(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            Stage stage = (Stage) loginIdField.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
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
