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

public class u4g8controller {

    @FXML
    private ComboBox<String> feeTypeComboBox; // ComboBox for selecting Fee Type

    @FXML
    private TextField cardNumberTextField; // TextField for entering Card Number

    @FXML
    private DatePicker expiryDatePicker; // DatePicker for selecting Expiry Date

    @FXML
    private TextField cvvTextField; // TextField for entering CVV

    @FXML
    private TextField cardHolderNameTextField; // TextField for entering Card Holder Name

    @FXML
    private TextField billingAddressTextField; // TextField for entering Billing Address

    @FXML
    private Button payButton; // Button to make payment

    @FXML
    private Button backButton; // Button to go back to the previous screen

    @FXML
    private Label statusLabel; // Label to show the status or error message

    // Method to handle the "Pay" button action
    @FXML
    private void handlePay(ActionEvent event) {
        String feeType = feeTypeComboBox.getValue();
        String cardNumber = cardNumberTextField.getText();
        String cvv = cvvTextField.getText();
        String cardHolderName = cardHolderNameTextField.getText();
        String billingAddress = billingAddressTextField.getText();
        String expiryDate = expiryDatePicker.getValue() != null ? expiryDatePicker.getValue().toString() : "";

        if (feeType == null || feeType.isEmpty() || cardNumber.isEmpty() || cvv.isEmpty() || cardHolderName.isEmpty() || billingAddress.isEmpty() || expiryDate.isEmpty()) {
            statusLabel.setText("Please fill in all fields.");
        } else {
            // Logic to process the payment
            // For now, we simulate a successful payment and show a success message
            statusLabel.setText("Payment successful for Fee Type: " + feeType);
        }
    }

    // Method to handle the "Back" button action
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
