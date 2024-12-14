package oop.demo1.JunaidMannaf_2320846;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class User5Scene4SendCaseCompletionConfirmationController implements Initializable {

    @FXML
    private ComboBox<String> completedCaseComboBox;

    @FXML
    private Label statusLabel;

    private static final String COMPLETED_CASES_FILE = "completed_cases.bin";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        completedCaseComboBox.getItems().addAll(
                "Case 001: Immigration Sponsorship",
                "Case 002: Refugee Application",
                "Case 003: Family Reunification",
                "Case 004: Employment Authorization"
        );
    }

    @FXML
    private void handleMarkAsComplete(ActionEvent event) {
        String selectedCase = completedCaseComboBox.getValue();

        if (selectedCase == null) {
            statusLabel.setText("Please select a completed case.");
        } else {
            saveCompletedCase(selectedCase);
            statusLabel.setText("Case '" + selectedCase + "' marked as complete.");
            System.out.println("Marked as complete: " + selectedCase);
        }
    }

    @FXML
    private void handleSendNotification(ActionEvent event) {
        String selectedCase = completedCaseComboBox.getValue();

        if (selectedCase == null) {
            statusLabel.setText("Please select a completed case before sending a notification.");
        } else {
            statusLabel.setText("Notification sent for case: '" + selectedCase + "'.");
            System.out.println("Notification sent for: " + selectedCase);
        }
    }

    @FXML
    private void handleBackToDashboard(ActionEvent event) {
        System.out.println("Navigating back to Dashboard...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User5CaseManagerDashboard.fxml");
    }

    private void saveCompletedCase(String completedCase) {
        List<String> completedCases = readCompletedCases();
        completedCases.add(completedCase);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(COMPLETED_CASES_FILE))) {
            oos.writeObject(completedCases);
            System.out.println("Case saved to binary file: " + completedCase);
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Error saving completed case.");
        }
    }

    private List<String> readCompletedCases() {
        File file = new File(COMPLETED_CASES_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while switching scenes: " + e.getMessage());
        }
    }
}
