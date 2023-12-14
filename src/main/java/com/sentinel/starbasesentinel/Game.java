package com.sentinel.starbasesentinel;

import com.sentinel.starbasesentinel.enemies.Tank;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Game {
    private final static int WIDTH = 1280;
    private final static int HEIGHT = 720;

    public void start(Stage stage) {
        Canvas field = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = field.getGraphicsContext2D();

        // Add tank
        Point2D initialPosition = new Point2D(0,700); // set spawn point
        ArrayList<Point2D> path = new ArrayList<>(); // initialize path list

        // turning points
        path.add(new Point2D(0,400));
        path.add(new Point2D(400, 400));
        path.add(new Point2D(1000, 0));
//        path.add(new Point2D(0,0));

        // create Tank
        Tank tank = new Tank(initialPosition, path);

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // reset canvas (?)
                gc.clearRect(0, 0, WIDTH, HEIGHT); // clear canvas
                gc.setFill(Color.web("#1b1a17")); // set background color
                gc.fillRect(0, 0, WIDTH, HEIGHT); // fill canvas with color

                // Draw tank with updated position
                tank.render(gc);
            }
        }.start();

        Group group = new Group(field);
        Scene game = new Scene(group);
        stage.setScene(game);
        stage.show();
    }
}
