package com.sentinel.starbasesentinel.enemies;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Tank extends Enemy {

    public Tank(String image, ArrayList<Point2D> path) {
        super(new Point2D(0,0), path);

        this.image = new Image(image);
        speed = 0.1;
        hp = 50;
    }
    public Tank(String image, Point2D initialPosition, ArrayList<Point2D> path) {
        super(initialPosition, path);

        this.image = new Image(image);
        speed = 0.1;
        hp = 50;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(image, position.getX(), position.getY());
        move();

    }
}
