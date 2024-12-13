package oop.demo1.JunaidMannaf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class User6Scene7SubmitSponsorshipFeePaymentController {

    @FXML
    private TableView<FeeDetails> feeTable;

    @FXML
    private TableColumn<FeeDetails, String> feeTypeColumn;

    @FXML
    private TableColumn<FeeDetails, String> amountColumn;

    @FXML
    private TableColumn<FeeDetails, String> statusColumn;

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

    private final ObservableList<FeeDetails> feeData = FXCollections.observableArrayList(
            new FeeDetails("Processing Fee", "$50", "Paid"),
            new FeeDetails("Application Fee", "$100", "Pending"),
            new FeeDetails("Renewal Fee", "$75", "Pending"),
            new FeeDetails("Late Payment Fee", "$25", "Paid")
    );

    @FXML
    void handleSubmitPayment(ActionEvent event) {
        String selectedFee = feeComboBox.getValue();
        String paymentDetails = paymentDetailsField.getText();

        if (selectedFee == null || selectedFee.isEmpty()) {
            statusLabel.setText("Please select a sponsorship fee.");
        } else if (paymentDetails.isEmpty()) {
            statusLabel.setText("Please enter payment details.");
        } else {
            statusLabel.setText("Payment submitted for " + selectedFee + ".");
        }
    }

    @FXML
    private void handleBack(ActionEvent event) {
        System.out.println("Navigating back to the previous screen...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6ClientFSDashboard.fxml");
    }

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
        feeComboBox.getItems().addAll(
                "Processing Fee - $50",
                "Application Fee - $100",
                "Renewal Fee - $75",
                "Late Payment Fee - $25"
        );

        feeTypeColumn.setCellValueFactory(new PropertyValueFactory<>("feeType"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        feeTable.setItems(feeData);
    }

    public static class FeeDetails {
        private final String feeType;
        private final String amount;
        private final String status;

        public FeeDetails(String feeType, String amount, String status) {
            this.feeType = feeType;
            this.amount = amount;
            this.status = status;
        }

        public String getFeeType() {
            return feeType;
        }

        public String getAmount() {
            return amount;
        }

        public String getStatus() {
            return status;
        }
    }
}
