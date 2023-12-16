package com.sentinel.starbasesentinel.towers;

import com.sentinel.starbasesentinel.Grid;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Bullet {
    private final Image image;
    private Point2D position;
    private final Point2D target;
    private final double speed;

    public Bullet(Point2D position, Point2D target) {
        this.position = position;
        this.target = target;

        this.speed = 0.5;
        this.image = new Image("file:src/main/resources/towers/bullet.gif");
    }

    private void move() {
        if (position.distance(target) < 1) {
            return;
        }

        double angle = Math.atan2(target.getY() - position.getY(), target.getX() - position.getX());
        position = position.add(speed * Math.cos(angle), speed * Math.sin(angle));
    }

    public void update(ArrayList<Bullet> existingBullets) {
        move();


        existingBullets.removeIf(bullet -> bullet.position.distance(bullet.target) < 1);
        // TODO: add damage to enemy, show explosion?
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image, position.getX()- Grid.translateToGrid(0.5), position.getY()-Grid.translateToGrid(0.5));
    }
}
