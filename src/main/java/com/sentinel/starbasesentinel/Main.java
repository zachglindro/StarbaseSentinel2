package com.sentinel.starbasesentinel;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(@NotNull Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Button play = new Button("Play");
        Button exit = new Button("Exit");

        play.setOnMouseClicked(e -> System.out.println("I am playing"));
        exit.setOnMouseClicked(e -> System.exit(0));

        root.getChildren().addAll(play, exit);
        Scene scene = new Scene(root, 600, 600);

        stage.setTitle("Starbase Sentinel");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("Exited game.");
    }

    public static void main(String[] args) {
        launch();
    }
}