module oop.demo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.demo1 to javafx.fxml;
    exports oop.demo1;
    exports oop.demo1.JunaidMannaf;
    opens oop.demo1.JunaidMannaf to javafx.fxml;
    exports oop.demo1.TasninSiza;
    opens oop.demo1.TasninSiza to javafx.fxml;
    exports oop.demo1.SanjidaAkterJui;
    opens oop.demo1.SanjidaAkterJui to javafx.fxml;
}