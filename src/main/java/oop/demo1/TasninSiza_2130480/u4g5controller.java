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

    /**
     * This method handles the scheduling of a visa refusal consultation.
     */
    @FXML
    private void handleSchedule(ActionEvent event) {
        String selectedCase = caseComboBox.getValue();

        if (selectedCase == null || selectedCase.isEmpty()) {
            // Show an alert if no case is selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Selection");
            alert.setHeaderText("Case Missing");
            alert.setContentText("Please select a case before scheduling.");
            alert.showAndWait();
            return;
        }

        // Simulate scheduling logic
        System.out.println("Scheduling consultation for case: " + selectedCase);

        // Update the status label
        statusLabel.setText("Consultation scheduled for case: " + selectedCase);

        // Provide user feedback
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Consultation Scheduled");
        alert.setHeaderText("Success");
        alert.setContentText("Consultation has been successfully scheduled for case: " + selectedCase);
        alert.showAndWait();
    }

    /**
     * Initialize the ComboBox with predefined case types.
     * This method is called automatically when the controller is loaded.
     */
    @FXML
    public void initialize() {
        // Add predefined case types to the ComboBox
        caseComboBox.getItems().addAll(
                "Overstayed Visa",
                "Application Error",
                "Missing Documentation",
                "Other"
        );

        System.out.println("Controller initialized and case types loaded.");
    }
}
