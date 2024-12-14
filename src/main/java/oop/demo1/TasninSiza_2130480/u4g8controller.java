package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class u4g8controller {

    @FXML
    private ComboBox<String> feeTypeComboBox;

    @FXML
    private TextField cardNumberTextField;

    @FXML
    private DatePicker expiryDatePicker;

    @FXML
    private TextField cvvTextField;

    @FXML
    private TextField cardHolderTextField;

    @FXML
    private TextField billingAddressTextField;

    @FXML
    private void initialize() {

        feeTypeComboBox.getItems().addAll(
                "Application Fee",
                "Processing Fee",
                "Late Fee",
                "Premium Service Fee"
        );

        // Set a default value (optional)
        feeTypeComboBox.setValue("Application Fee");
    }

    @FXML
    private void handlePay(ActionEvent event) {

        String feeType = feeTypeComboBox.getValue();
        String cardNumber = cardNumberTextField.getText();
        LocalDate expiryDate = expiryDatePicker.getValue();
        String cvv = cvvTextField.getText();
        String cardHolderName = cardHolderTextField.getText();
        String billingAddress = billingAddressTextField.getText();


        if (feeType == null || feeType.isEmpty()) {
            showAlert("Validation Error", "Please select a Fee Type.");
            return;
        }

        if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
            showAlert("Validation Error", "Please enter a valid 16-digit Card Number (digits only).");
            return;
        }

        if (expiryDate == null || expiryDate.isBefore(LocalDate.now())) {
            showAlert("Validation Error", "Please select a valid Expiry Date (must be in the future).");
            return;
        }

        if (cvv == null || !cvv.matches("\\d{3}")) {
            showAlert("Validation Error", "Please enter a valid 3-digit CVV (digits only).");
            return;
        }

        if (cardHolderName == null || cardHolderName.trim().isEmpty()) {
            showAlert("Validation Error", "Please enter the Card Holder's Name.");
            return;
        }

        if (billingAddress == null || billingAddress.trim().isEmpty()) {
            showAlert("Validation Error", "Please enter the Billing Address.");
            return;
        }


        System.out.println("Payment Processing...");
        System.out.println("Fee Type: " + feeType);
        System.out.println("Card Number: " + maskCardNumber(cardNumber));
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("CVV: " + cvv);
        System.out.println("Card Holder Name: " + cardHolderName);
        System.out.println("Billing Address: " + billingAddress);

        showAlert("Payment Successful", "Your payment has been successfully processed.");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private String maskCardNumber(String cardNumber) {
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
}
