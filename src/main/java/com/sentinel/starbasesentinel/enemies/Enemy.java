package com.sentinel.starbasesentinel.enemies;

import javafx.geometry.Point2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class Enemy {
    ImageView imageView;
    double speed;
    int hp;
    Point2D position;
    ArrayList<Point2D> path;
    int hasReachedEnd;

    public Enemy(Image image, Point2D startPos) {
        this.imageView = new ImageView(image);
        this.position = startPos;
        this.path = new ArrayList<>();
    }

    private void move() {
        if (path.isEmpty()) {
            hasReachedEnd = 1;
        } else if (position.distance(path.getFirst()) < 1) {
            path.removeFirst();
            rotate();
        } else {
            // Move enemy towards next point in path
            Point2D nextPosition = path.getFirst(); // get first element in ArrayList
            double angle = Math.atan2(nextPosition.getY() - position.getY(), nextPosition.getX() - position.getX()); // magic
            position = position.add(speed * Math.cos(angle), speed * Math.sin(angle)); // magic 2
        }
    }

    private void rotate() {
        if (path.isEmpty()) {
            return;
        }

        Point2D nextPosition = path.getFirst();
        double angle = Math.atan2(nextPosition.getY() - position.getY(), nextPosition.getX() - position.getX());
        imageView.setRotate(Math.toDegrees(angle) + 90);
    }

    // Adds a point to the enemy's path
    public void addToPath(Point2D point) {
        path.add(point);
    }

    public void render(GraphicsContext gc) {
        move();

        // Rotate image
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage rotatedImage = imageView.snapshot(params, null);

        // Draw rotated image with center at position
        gc.drawImage(rotatedImage, position.getX() - rotatedImage.getWidth() / 2, position.getY() - rotatedImage.getHeight() / 2);
    }
}
