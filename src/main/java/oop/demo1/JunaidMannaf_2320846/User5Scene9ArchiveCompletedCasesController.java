package oop.demo1.JunaidMannaf_2320846;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class User5Scene9ArchiveCompletedCasesController {

    @FXML
    private ComboBox<String> completedCaseComboBox;

    @FXML
    private Label statusLabel;

    private final List<String> archivedCases = new ArrayList<>();

    @FXML
    public void initialize() {

        completedCaseComboBox.setItems(FXCollections.observableArrayList(
                "Case #001 - John Doe",
                "Case #002 - Jane Smith",
                "Case #003 - Michael Johnson",
                "Case #004 - Emily Davis"
        ));
    }

    @FXML
    private void handleNotifyClient(ActionEvent event) {
        String selectedCase = completedCaseComboBox.getValue();

        if (selectedCase == null) {
            statusLabel.setText("Please select a completed case.");
        } else {
            statusLabel.setText("Notification sent to client regarding case: " + selectedCase);
            System.out.println("Notified client about case: " + selectedCase);
        }
    }

    @FXML
    private void handleArchiveCase(ActionEvent event) {
        String selectedCase = completedCaseComboBox.getValue();

        if (selectedCase == null) {
            statusLabel.setText("Please select a completed case.");
        } else {

            completedCaseComboBox.getItems().remove(selectedCase);
            archivedCases.add(selectedCase);

            saveArchivedCasesToBinFile();

            statusLabel.setText("Case '" + selectedCase + "' has been archived.");
            System.out.println("Archived case: " + selectedCase);
        }
    }

    private void saveArchivedCasesToBinFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("archived_cases.bin"))) {
            oos.writeObject(archivedCases);
            System.out.println("Archived cases saved to binary file.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving to binary file: " + e.getMessage());
        }
    }

    @FXML
    private void handleBackToDashboard(ActionEvent event) {
        System.out.println("Navigating back to Dashboard...");
        switchScene(event, "/oop/demo1/Junaid Mannaf/User5CaseManagerDashboard.fxml");
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
