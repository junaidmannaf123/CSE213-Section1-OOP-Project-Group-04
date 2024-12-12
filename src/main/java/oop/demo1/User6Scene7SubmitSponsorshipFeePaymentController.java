package oop.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class User6Scene7SubmitSponsorshipFeePaymentController {

    @FXML
    private TableView<?> feeTable;

    @FXML
    private TableColumn<?, ?> feeTypeColumn;

    @FXML
    private TableColumn<?, ?> amountColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;

    @FXML
    private ComboBox<String> feeComboBox;

    @FXML
    private TextField paymentDetailsField;

    @FXML
    private Button submitPaymentButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Button backButton;

    @FXML
    void handleSubmitPayment(ActionEvent event) {
        String selectedFee = feeComboBox.getValue();
        String paymentDetails = paymentDetailsField.getText();

        if (selectedFee == null || selectedFee.isEmpty()) {
            statusLabel.setText("Please select a sponsorship fee.");
        } else if (paymentDetails.isEmpty()) {
            statusLabel.setText("Please enter payment details.");
        } else {
            // Process the payment (placeholder logic)
            statusLabel.setText("Payment submitted for " + selectedFee + ".");
        }
    }

    /// Handle "Back" button click
    @FXML
    private void handleBack(ActionEvent event) {
        System.out.println("Navigating back to the previous screen...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6ClientFSDashboard.fxml");
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

    @FXML
    public void initialize() {
        // Populate the ComboBox with fee types
        feeComboBox.getItems().addAll(
                "Processing Fee - $50",
                "Application Fee - $100",
                "Renewal Fee - $75",
                "Late Payment Fee - $25"
        );
    }
}
