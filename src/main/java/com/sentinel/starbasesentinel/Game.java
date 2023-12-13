package com.sentinel.starbasesentinel;

import com.sentinel.starbasesentinel.enemies.Tank;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Game {
    private final static int WIDTH = 1280;
    private final static int HEIGHT = 720;

    final long startNanoTime = System.nanoTime();

    public void start(Stage stage) {
        Canvas field = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = field.getGraphicsContext2D();

        // Add tank
        Point2D initialPosition = new Point2D(0,720);
        ArrayList<Point2D> path = new ArrayList<>();
//        path.add(new Point2D(400,400));
        path.add(new Point2D(0, 0));
        path.add(new Point2D(1000, 0));
        path.add(new Point2D(0,0));
        Tank tank = new Tank("file:src/main/resources/enemies/tank.png", initialPosition, path);

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                // Clear canvas
                gc.clearRect(0, 0, WIDTH, HEIGHT);

                // Set background color
                gc.setFill(Color.web("#1b1a17"));
                gc.fillRect(0, 0, WIDTH, HEIGHT);

                // Draw tank
                tank.render(gc);
            }
        }.start();

        Group group = new Group(field);
        Scene game = new Scene(group);
        stage.setScene(game);
        stage.show();
    }
}
