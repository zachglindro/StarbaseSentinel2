package com.sentinel.starbasesentinel;

import com.sentinel.starbasesentinel.levels.Level1;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Game {
    private final static int WIDTH = 1280;
    private final static int HEIGHT = 720;

    public void start(Stage stage) {
        Canvas field = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = field.getGraphicsContext2D();

        Level1 level = new Level1();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                level.render(gc);
            }
        };

        timer.start();

        Group group = new Group(field);
        Scene game = new Scene(group);
        stage.setScene(game);
        stage.show();
    }
}
