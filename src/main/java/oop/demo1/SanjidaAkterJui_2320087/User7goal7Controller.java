package oop.demo1.SanjidaAkterJui_2320087;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class User7goal7Controller {

    @FXML
    private ComboBox<String> listoccombobox;

    @FXML
    private TableView<String> displaysubdoctableview;

    @FXML
    private TextArea inputcomfeedbctextarea;

    @FXML
    private Button markascompliantbutton;

    @FXML
    private void handleMarkAsCompliant() {
        // Logic to handle marking documents as compliant
        System.out.println("Mark as Compliant button clicked.");
        String feedback = inputcomfeedbctextarea.getText();
        System.out.println("Compliance Feedback: " + feedback);
        // Implement your logic to process compliance feedback
    }
}
