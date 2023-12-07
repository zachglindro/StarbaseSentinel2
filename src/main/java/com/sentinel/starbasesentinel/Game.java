package com.sentinel.starbasesentinel;

import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class Game {
    public void start(Stage stage) {
        HBox root = new HBox();
        Text text = new Text("Game started.");
        root.getChildren().add(text);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
