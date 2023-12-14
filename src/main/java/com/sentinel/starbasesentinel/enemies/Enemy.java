package com.sentinel.starbasesentinel.enemies;

import com.sentinel.starbasesentinel.levels.Grid;
import javafx.geometry.Point2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class Enemy {
    final ImageView imageView;
    double speed;
    int hp;
    Point2D position;
    ArrayList<Point2D> path;
    int hasReachedEnd;

    public Enemy(Image image, int x, int y) {
        this.imageView = new ImageView(image);
        this.position = Grid.translate(x, y);
        this.path = new ArrayList<>();
    }

    // Move enemy towards next point in path
    private void move() {
        rotate();
        if (path.isEmpty()) {
            hasReachedEnd = 1;
        } else if (position.distance(path.getFirst()) < 1) {
            path.removeFirst();
        } else {
            // Move enemy towards next point in path
            Point2D nextPosition = path.getFirst(); // get first element in ArrayList
            double angle = Math.atan2(nextPosition.getY() - position.getY(), nextPosition.getX() - position.getX()); // magic
            position = position.add(speed * Math.cos(angle), speed * Math.sin(angle)); // magic 2
        }
    }

    // Rotate image to face next point in path
    private void rotate() {
        if (path.isEmpty()) {
            return;
        }

        Point2D nextPosition = path.getFirst();
        double angle = Math.atan2(nextPosition.getY() - position.getY(), nextPosition.getX() - position.getX());
        imageView.setRotate(Math.toDegrees(angle) + 90); // assumes image is facing up
    }

    public void setPath(ArrayList<Point2D> path) {
        this.path = path;
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
