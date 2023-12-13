package com.sentinel.starbasesentinel.enemies;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Tank extends Enemy {

    public Tank(String image, Point2D position, ArrayList<Point2D> path) {
        super(position, path);

        this.image = new Image(image);
        speed = 1;
        hp = 50;
    }

    @Override
    public void move() {
        // Check if tank is near the next point in the path
        if (path.isEmpty()) {
            // Tank has reached the end of the path
        } else if (position.distance(path.getFirst()) < 1) {
            path.removeFirst();
        } else {
            // Move tank towards next point in path
            Point2D nextPosition = path.getFirst();
            double angle = Math.atan2(nextPosition.getY() - position.getY(), nextPosition.getX() - position.getX());
            position = position.add(speed * Math.cos(angle), speed * Math.sin(angle));
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        move();
        gc.drawImage(image, position.getX(), position.getY());
    }
}
