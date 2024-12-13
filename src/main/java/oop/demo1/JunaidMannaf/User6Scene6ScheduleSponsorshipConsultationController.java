package oop.demo1.JunaidMannaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.LocalDate;

public class User6Scene6ScheduleSponsorshipConsultationController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button confirmButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Button backButton;

    @FXML
    void handleConfirmAppointment(ActionEvent event) {
        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate == null) {
            statusLabel.setText("Please select a date.");
        } else if (selectedDate.isBefore(LocalDate.now())) {
            statusLabel.setText("Date cannot be in the past. Please select a future date.");
        } else {
            statusLabel.setText("Appointment confirmed for: " + selectedDate.toString());
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
}