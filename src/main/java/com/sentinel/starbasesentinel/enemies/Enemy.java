package com.sentinel.starbasesentinel.enemies;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Enemy {
    Image image;
    double speed;
    int hp;
    Point2D position;
    ArrayList<Point2D> path;

    public Enemy(Point2D position, ArrayList<Point2D> path) {
        this.position = position;
        this.path = path;
    }

    public void move() {
        if (path.isEmpty()) {
            // TODO despawn enemy

            // TODO update game state (decrease base health, etc)
            // Enemy has reached the end of the path
        } else if (position.distance(path.getFirst()) < 1) {
            path.removeFirst();
        } else {
            // Move enemy towards next point in path
            Point2D nextPosition = path.getFirst(); // get first element in ArrayList
            double angle = Math.atan2(nextPosition.getY() - position.getY(), nextPosition.getX() - position.getX()); // magic
            position = position.add(speed * Math.cos(angle), speed * Math.sin(angle)); // magic 2
        }
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image, position.getX(), position.getY());
        move();
    }
}
