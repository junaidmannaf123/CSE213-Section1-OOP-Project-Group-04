package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class u4g1controller {

    @FXML
    private ComboBox<String> visaTypeComboBox;

    @FXML
    private TextField phoneTextField;

    @FXML
    private DatePicker dobDatePicker;

    @FXML
    private ComboBox<String> nationalityComboBox;

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
    private ComboBox<String> visaPurposeComboBox;

    @FXML
    private ComboBox<String> paymentMethodComboBox;

    @FXML
    private void initialize() {

        visaTypeComboBox.getItems().addAll("Tourist Visa", "Work Visa", "Student Visa", "Permanent Residence");
        nationalityComboBox.getItems().addAll("United States", "Canada", "India", "United Kingdom", "Australia");
        visaPurposeComboBox.getItems().addAll("Travel", "Employment", "Education", "Relocation");
        paymentMethodComboBox.getItems().addAll("Credit Card", "Debit Card", "PayPal", "Bank Transfer");


        visaTypeComboBox.setValue("Tourist Visa");
        nationalityComboBox.setValue("United States");
        visaPurposeComboBox.setValue("Travel");
        paymentMethodComboBox.setValue("Credit Card");
    }

    @FXML
    private void handleVisaTypeSelection(ActionEvent event) {
        System.out.println("Selected Visa Type: " + visaTypeComboBox.getValue());
    }

    @FXML
    private void handlePhoneInput(ActionEvent event) {
        String phone = phoneTextField.getText();
        if (!phone.matches("\\d{10}")) {
            showAlert(AlertType.ERROR, "Invalid Phone Number", "Phone number must be 10 digits.");
        } else {
            System.out.println("Phone number entered: " + phone);
        }
    }

    @FXML
    private void handleDOBInput(ActionEvent event) {
        LocalDate dob = dobDatePicker.getValue();
        if (dob != null && dob.isAfter(LocalDate.now())) {
            showAlert(AlertType.ERROR, "Invalid Date of Birth", "Date of birth cannot be in the future.");
        } else {
            System.out.println("Date of Birth selected: " + dob);
        }
    }

    @FXML
    private void handleNationalitySelection(ActionEvent event) {
        System.out.println("Selected Nationality: " + nationalityComboBox.getValue());
    }

    @FXML
    private void handleEmailInput(ActionEvent event) {
        String email = emailTextField.getText();
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            showAlert(AlertType.ERROR, "Invalid Email Address", "Please enter a valid email address.");
        } else {
            System.out.println("Email entered: " + email);
        }
    }

    @FXML
    private void handleAddressInput(ActionEvent event) {
        System.out.println("Residential Address entered: " + addressTextField.getText());
    }

    @FXML
    private void handlePassportInput(ActionEvent event) {
        String passport = passportTextField.getText();
        if (!passport.matches("^[A-Za-z0-9]{6,9}$")) {
            showAlert(AlertType.ERROR, "Invalid Passport Number", "Passport number must be 6-9 alphanumeric characters.");
        } else {
            System.out.println("Passport Number entered: " + passport);
        }
    }

    @FXML
    private void handleFullNameInput(ActionEvent event) {
        System.out.println("Full Name entered: " + fullNameTextField.getText());
    }

    @FXML
    private void handleAdditionalInfoInput(ActionEvent event) {
        System.out.println("Additional Information entered: " + additionalInfoTextField.getText());
    }

    @FXML
    private void handleVisaPurposeSelection(ActionEvent event) {
        System.out.println("Selected Visa Purpose: " + visaPurposeComboBox.getValue());
    }

    @FXML
    private void handlePaymentMethodSelection(ActionEvent event) {
        System.out.println("Selected Payment Method: " + paymentMethodComboBox.getValue());
    }

    @FXML
    private void handleUploadFile(ActionEvent event) {
        // Placeholder for file upload logic
        System.out.println("File upload functionality not yet implemented.");
    }

    @FXML
    private void handleSubmit(ActionEvent event) {
        List<String> errors = validateInputs();

        if (errors.isEmpty()) {

            System.out.println("Form submitted successfully!");
            showAlert(AlertType.INFORMATION, "Submission Successful", "Your application has been submitted successfully.");
        } else {

            String errorMessage = String.join("\n", errors);
            showAlert(AlertType.ERROR, "Submission Failed", errorMessage);
        }
    }

    private List<String> validateInputs() {
        List<String> errors = new ArrayList<>();

        if (fullNameTextField.getText().isEmpty()) {
            errors.add("Full Name is required.");
        }
        if (dobDatePicker.getValue() == null) {
            errors.add("Date of Birth is required.");
        }
        if (nationalityComboBox.getValue() == null) {
            errors.add("Nationality is required.");
        }
        if (phoneTextField.getText().isEmpty() || !phoneTextField.getText().matches("\\d{10}")) {
            errors.add("Valid Phone Number is required.");
        }
        if (emailTextField.getText().isEmpty() || !emailTextField.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errors.add("Valid Email Address is required.");
        }
        if (addressTextField.getText().isEmpty()) {
            errors.add("Residential Address is required.");
        }
        if (passportTextField.getText().isEmpty() || !passportTextField.getText().matches("^[A-Za-z0-9]{6,9}$")) {
            errors.add("Valid Passport Number is required.");
        }

        return errors;
    }

    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
