package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class u4g1controller {

    @FXML
    private ComboBox<?> visaTypeComboBox; // ComboBox for visa type

    @FXML
    private ComboBox<?> nationalityComboBox; // ComboBox for nationality

    @FXML
    private ComboBox<?> visaPurposeComboBox; // ComboBox for visa purpose

    @FXML
    private ComboBox<?> paymentMethodComboBox; // ComboBox for fee payment method

    @FXML
    private DatePicker dateOfBirthDatePicker; // DatePicker for date of birth

    @FXML
    private TextField fullNameTextField; // TextField for full name

    @FXML
    private TextField phoneTextField; // TextField for phone number

    @FXML
    private TextField emailTextField; // TextField for email

    @FXML
    private TextField addressTextField; // TextField for residential address

    @FXML
    private TextField passportNumberTextField; // TextField for passport number

    @FXML
    private TextField additionalInfoTextField; // TextField for additional information

    @FXML
    private Button uploadButton; // Button to upload file

    @FXML
    private Button submitButton; // Button to submit the application

    @FXML
    private Button backButton; // Button to go back to the previous screen

    // Method to handle the submit action
    @FXML
    private void handleSubmit(ActionEvent event) {
        // Capture the input values
        String visaType = (String) visaTypeComboBox.getValue();
        String nationality = (String) nationalityComboBox.getValue();
        String visaPurpose = (String) visaPurposeComboBox.getValue();
        String paymentMethod = (String) paymentMethodComboBox.getValue();
        String fullName = fullNameTextField.getText();
        String phone = phoneTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String passportNumber = passportNumberTextField.getText();
        String additionalInfo = additionalInfoTextField.getText();
        String dob = dateOfBirthDatePicker.getValue().toString();

        if (fullName.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() || passportNumber.isEmpty()) {
            // Show an error or warning if required fields are missing
            System.out.println("Please fill in all required fields.");
        } else {
            // Logic to submit the immigration application (e.g., save data or interact with a backend)
            System.out.println("Application Submitted. Details: " +
                    "\nVisa Type: " + visaType + "\nNationality: " + nationality + "\nPurpose: " + visaPurpose +
                    "\nPayment Method: " + paymentMethod + "\nFull Name: " + fullName + "\nPhone: " + phone +
                    "\nEmail: " + email + "\nAddress: " + address + "\nPassport Number: " + passportNumber +
                    "\nAdditional Information: " + additionalInfo + "\nDate of Birth: " + dob);
        }
    }

    // Method to handle the upload button action
    @FXML
    private void handleUpload(ActionEvent event) {
        // Logic to handle file upload
        System.out.println("File uploaded.");
    }

    // Method to handle going back to the previous screen (e.g., login screen)
    @FXML
    private void handleBackToLogin(ActionEvent event) {
        System.out.println("Navigating back to the login screen.");

        // Switch to the login screen
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
