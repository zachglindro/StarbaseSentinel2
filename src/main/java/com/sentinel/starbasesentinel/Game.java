package com.sentinel.starbasesentinel;

import com.sentinel.starbasesentinel.levels.Level;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game {
    private final static int WIDTH = 1280;
    private final static int HEIGHT = 720;

    public void start(Stage stage) {
        Canvas field = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = field.getGraphicsContext2D();


        Level level = new Level();
        level.init();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // reset canvas (?)
                gc.clearRect(0, 0, WIDTH, HEIGHT); // clear canvas
                gc.setFill(Color.web("#1b1a17")); // set background color
                gc.fillRect(0, 0, WIDTH, HEIGHT); // fill canvas with color

                level.render(gc);
            }
        }.start();

        Group group = new Group(field);
        Scene game = new Scene(group);
        stage.setScene(game);
        stage.show();
    }
}
