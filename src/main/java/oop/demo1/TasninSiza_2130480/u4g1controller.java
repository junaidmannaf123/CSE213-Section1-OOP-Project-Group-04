package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class u4g1controller {

    @FXML
    private ComboBox<String> visaTypeComboBox;

    @FXML
    private ComboBox<String> nationalityComboBox;

    @FXML
    private ComboBox<String> visaPurposeComboBox;

    @FXML
    private ComboBox<String> paymentMethodComboBox;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField passportTextField;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField additionalInfoTextField;

    @FXML
    private DatePicker dobDatePicker;

    @FXML
    private void handleVisaTypeSelection(ActionEvent event) {
        String selectedVisaType = visaTypeComboBox.getValue();
        System.out.println("Selected Visa Type: " + selectedVisaType);
    }

    @FXML
    private void handleNationalitySelection(ActionEvent event) {
        String selectedNationality = nationalityComboBox.getValue();
        System.out.println("Selected Nationality: " + selectedNationality);
    }

    @FXML
    private void handleVisaPurposeSelection(ActionEvent event) {
        String selectedVisaPurpose = visaPurposeComboBox.getValue();
        System.out.println("Selected Visa Purpose: " + selectedVisaPurpose);
    }

    @FXML
    private void handlePaymentMethodSelection(ActionEvent event) {
        String selectedPaymentMethod = paymentMethodComboBox.getValue();
        System.out.println("Selected Payment Method: " + selectedPaymentMethod);
    }

    @FXML
    private void handlePhoneInput(ActionEvent event) {
        String phone = phoneTextField.getText();
        System.out.println("Entered Phone: " + phone);
    }

    @FXML
    private void handleEmailInput(ActionEvent event) {
        String email = emailTextField.getText();
        System.out.println("Entered Email: " + email);
    }

    @FXML
    private void handleAddressInput(ActionEvent event) {
        String address = addressTextField.getText();
        System.out.println("Entered Address: " + address);
    }

    @FXML
    private void handlePassportInput(ActionEvent event) {
        String passportNumber = passportTextField.getText();
        System.out.println("Entered Passport Number: " + passportNumber);
    }

    @FXML
    private void handleFullNameInput(ActionEvent event) {
        String fullName = fullNameTextField.getText();
        System.out.println("Entered Full Name: " + fullName);
    }

    @FXML
    private void handleDOBInput(ActionEvent event) {
        if (dobDatePicker.getValue() != null) {
            String dateOfBirth = dobDatePicker.getValue().toString();
            System.out.println("Selected Date of Birth: " + dateOfBirth);
        } else {
            System.out.println("Date of Birth not selected.");
        }
    }

    @FXML
    private void handleAdditionalInfoInput(ActionEvent event) {
        String additionalInfo = additionalInfoTextField.getText();
        System.out.println("Entered Additional Information: " + additionalInfo);
    }

    @FXML
    private void handleUploadFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png")
        );

        Stage stage = (Stage) phoneTextField.getScene().getWindow(); // Using any component to get the stage
        java.io.File file = fileChooser.showOpenDialog(stage);

        if (file != null) { // Check if a file was selected
            System.out.println("Selected file: " + file.getAbsolutePath());
        } else {
            System.out.println("No file selected.");
        }
    }

    @FXML
    private void handleSubmit(ActionEvent event) {
        // Collecting all the input data
        String fullName = fullNameTextField.getText();
        String phone = phoneTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String passportNumber = passportTextField.getText();
        String visaType = visaTypeComboBox.getValue();
        String nationality = nationalityComboBox.getValue();
        String visaPurpose = visaPurposeComboBox.getValue();
        String paymentMethod = paymentMethodComboBox.getValue();
        String dob = (dobDatePicker.getValue() != null) ? dobDatePicker.getValue().toString() : "Not Provided";
        String additionalInfo = additionalInfoTextField.getText();

        // Log the information (replace this with actual saving logic, e.g., database)
        System.out.println("Submission Details:");
        System.out.println("Full Name: " + fullName);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Passport Number: " + passportNumber);
        System.out.println("Visa Type: " + visaType);
        System.out.println("Nationality: " + nationality);
        System.out.println("Visa Purpose: " + visaPurpose);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Additional Info: " + additionalInfo);

        // Example: Show confirmation
        System.out.println("Application submitted successfully!");
    }
}
