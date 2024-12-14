package oop.demo1.TasninSiza_2130480;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class u4g5controller {

    @FXML
    private ComboBox<String> caseComboBox;

    @FXML
    private Label statusLabel;


    @FXML
    private void handleSchedule(ActionEvent event) {
        String selectedCase = caseComboBox.getValue();

        if (selectedCase == null || selectedCase.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Selection");
            alert.setHeaderText("Case Missing");
            alert.setContentText("Please select a case before scheduling.");
            alert.showAndWait();
            return;
        }


        System.out.println("Scheduling consultation for case: " + selectedCase);


        statusLabel.setText("Consultation scheduled for case: " + selectedCase);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Consultation Scheduled");
        alert.setHeaderText("Success");
        alert.setContentText("Consultation has been successfully scheduled for case: " + selectedCase);
        alert.showAndWait();
    }


    @FXML
    public void initialize() {

        caseComboBox.getItems().addAll(
                "Overstayed Visa",
                "Application Error",
                "Missing Documentation",
                "Other"
        );


        statusLabel.setText("Please select a case.");

        System.out.println("Controller initialized and case types loaded.");
    }
}
