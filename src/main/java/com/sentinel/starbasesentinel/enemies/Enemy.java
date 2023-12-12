package com.sentinel.starbasesentinel.enemies;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Enemy {
    Image image;
    int speed;
    int hp;
    Point2D position;
    ArrayList<Point2D> path;

    public Enemy(Point2D position, ArrayList<Point2D> path) {
        this.position = position;
        this.path = path;
    }

    public abstract void move();

    public abstract void render(GraphicsContext gc);
}
