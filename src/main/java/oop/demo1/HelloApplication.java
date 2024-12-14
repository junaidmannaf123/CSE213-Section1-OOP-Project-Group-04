package oop.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

// TasninSiza_2130480 - (User 3 (Immigration Consultant) FXML, Controller), (User 4 (Immigration Applicant) FXML, Controller)
// JunaidMannaf_2320846 - Hello Application, Login Data, LoginSceneController, (User 5 (Case Manager) FXML, Controller), (User 6 Client (Sponsorship) FXML, Controller)
// SanjidaAkterJui_2320087 - (User 7 (Legal Advisor) FXML, Controller), (User 8 (IT Support) FXML, Controller)

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("XYZ Limited Immigration Consultant Firm");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
