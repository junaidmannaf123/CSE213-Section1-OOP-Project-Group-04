module oop.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kernel;
    requires layout;


    opens oop.demo1 to javafx.fxml;
    exports oop.demo1;
    exports oop.demo1.JunaidMannaf_2320846;
    opens oop.demo1.JunaidMannaf_2320846 to javafx.fxml;
    exports oop.demo1.TasninSiza_2130480;
    opens oop.demo1.TasninSiza_2130480 to javafx.fxml;
    exports oop.demo1.SanjidaAkterJui_2320087;
    opens oop.demo1.SanjidaAkterJui_2320087 to javafx.fxml;
}