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
    public void render(GraphicsContext gc) {
        move();
        gc.drawImage(image, position.getX(), position.getY());
    }
}
