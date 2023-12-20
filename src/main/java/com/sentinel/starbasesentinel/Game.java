package com.sentinel.starbasesentinel;

import com.sentinel.starbasesentinel.levels.Level1;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Game {
    private final static int WIDTH = 1280;
    private final static int HEIGHT = 720;


//    public Game(Stage primaryStage){
//        this.primaryStage = primaryStage;
//    }

    public void start(Stage stage) {
        Canvas field = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = field.getGraphicsContext2D();

        Group group = new Group(field);
        Scene game = new Scene(group);

        Level1 level = new Level1();

        GameTimer timer = new GameTimer(level, game, gc);
        timer.start();

        stage.setScene(game);
        stage.show();
    }
}