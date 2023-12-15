package com.sentinel.starbasesentinel.towers;

import com.sentinel.starbasesentinel.Grid;
import com.sentinel.starbasesentinel.enemies.Enemy;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bullet {
    Image image;
    Point2D position;
    Point2D target;

    public Bullet(Point2D position, Point2D target) {
        this.position = position;
        this.target = target;
        this.image = new Image("file:src/main/resources/towers/bullet.gif");
    }

    public void move() {
        double x = target.getX() - position.getX();
        double y = target.getY() - position.getY();
        double magnitude = Math.sqrt(x*x + y*y);
        double speed = Grid.translateToCoords(0.5);
        double dx = x / magnitude * speed;
        double dy = y / magnitude * speed;
        position = position.add(dx, dy);
    }

    public void render(GraphicsContext gc) {
        move();
        gc.drawImage(image, position.getX()- Grid.translateToGrid(0.5), position.getY()-Grid.translateToGrid(0.5));
    }
}
