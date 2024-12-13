package oop.demo1.JunaidMannaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class User6Scene3TrackSponsorshipApplicationStatusController {

    @FXML
    private TextField applicationNumberTextField;

    @FXML
    private Label statusLabel;

    @FXML
    private void handleTrackStatus(ActionEvent event) {
        String applicationNumber = applicationNumberTextField.getText();

        if (applicationNumber == null || applicationNumber.isEmpty()) {
            statusLabel.setText("Please enter an application number.");
        } else {

            if (applicationNumber.equals("001")) {
                statusLabel.setText("Status: Approved");
            } else if (applicationNumber.equals("002")) {
                statusLabel.setText("Status: Pending");
            } else if (applicationNumber.equals("003")) {
                statusLabel.setText("Status: Declined");
            } else if (applicationNumber.equals("004")) {
                statusLabel.setText("Status: Approved");
            } else {
                statusLabel.setText("Application not found.");
            }
        }
    }


    @FXML
    private void handleBack(ActionEvent event) {
        System.out.println("Navigating back to the previous screen...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User6ClientFSDashboard.fxml"); // Replace with the actual FXML file for the dashboard
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
}
