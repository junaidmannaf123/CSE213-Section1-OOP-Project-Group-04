package oop.demo1.SanjidaAkterJui_2320087;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class User7goal3Controller {

    @FXML
    private ComboBox<String> loscombobox;

    @FXML
    private Button uddbutton;

    @FXML
    private Button senddocsbutton;

    @FXML
    private TableView<?> legaldocstabileview;

    @FXML
    private void handleUploadDraft() {
        // Logic to handle upload draft documents
        System.out.println("Upload Draft Documents button clicked.");
    }

    @FXML
    private void handleSendDocs() {
        // Logic to handle send documents
        System.out.println("Send Documents button clicked.");
    }
}