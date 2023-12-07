module com.sentinel.starbasesentinel {
    requires javafx.controls;
    requires javafx.fxml;
    requires annotations;


    opens com.sentinel.starbasesentinel to javafx.fxml;
    exports com.sentinel.starbasesentinel;
}