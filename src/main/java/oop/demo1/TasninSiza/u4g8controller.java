package oop.demo1.TasninSiza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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

    /**
     * This method handles the Pay button action.
     */
    @FXML
    private void handlePay(ActionEvent event) {
        // Retrieve user inputs
        String feeType = feeTypeComboBox.getValue();
        String cardNumber = cardNumberTextField.getText();
        String expiryDate = (expiryDatePicker.getValue() != null) ? expiryDatePicker.getValue().toString() : null;
        String cvv = cvvTextField.getText();
        String cardHolderName = cardHolderTextField.getText();
        String billingAddress = billingAddressTextField.getText();

        // Validate inputs
        if (feeType == null || feeType.isEmpty()) {
            showAlert("Validation Error", "Please select a Fee Type.");
            return;
        }

        if (cardNumber == null || cardNumber.isEmpty() || cardNumber.length() != 16) {
            showAlert("Validation Error", "Please enter a valid 16-digit Card Number.");
            return;
        }

        if (expiryDate == null) {
            showAlert("Validation Error", "Please select an Expiry Date.");
            return;
        }

        if (cvv == null || cvv.isEmpty() || cvv.length() != 3) {
            showAlert("Validation Error", "Please enter a valid 3-digit CVV.");
            return;
        }

        if (cardHolderName == null || cardHolderName.isEmpty()) {
            showAlert("Validation Error", "Please enter the Card Holder's Name.");
            return;
        }

        if (billingAddress == null || billingAddress.isEmpty()) {
            showAlert("Validation Error", "Please enter the Billing Address.");
            return;
        }

        // Simulate payment processing
        System.out.println("Payment Processing...");
        System.out.println("Fee Type: " + feeType);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("CVV: " + cvv);
        System.out.println("Card Holder Name: " + cardHolderName);
        System.out.println("Billing Address: " + billingAddress);

        // Show success alert
        showAlert("Payment Successful", "Your payment has been successfully processed.");
    }

    /**
     * Helper method to show alert messages.
     */
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
