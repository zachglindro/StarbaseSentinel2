package com.sentinel.starbasesentinel.enemies;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Tank extends Enemy {
    public Tank(String image, Point2D initialPosition, ArrayList<Point2D> path) {
        super(initialPosition, path);

        this.image = new Image(image);
        speed = 1;
        hp = 50;
    }
}
