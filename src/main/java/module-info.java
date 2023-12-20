module com.sentinel.starbasesentinel {
    requires javafx.controls;
    requires javafx.fxml;
    requires annotations;


    opens com.sentinel.starbasesentinel to javafx.fxml;
    exports com.sentinel.starbasesentinel;
    exports com.sentinel.starbasesentinel.towers;
    opens com.sentinel.starbasesentinel.towers to javafx.fxml;
}