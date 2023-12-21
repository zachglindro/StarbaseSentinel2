/********************
 *
 * This file contains methods for enemy initialization, rendering, and moving.
 *
 * @author: Zach Dwayne Glindro, Kervin Ralph Samson
 * @date: 2023-12-21 11:59
 *
 *
 */

package com.sentinel.starbasesentinel.enemies;

import com.sentinel.starbasesentinel.Grid;
import javafx.geometry.Point2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class Enemy {
    protected ImageView imageView;
    protected final double speed;
    protected Point2D position;
    protected int health;
    protected int reward;
    protected ArrayList<Point2D> path;
    protected boolean doNotRotate;
    protected boolean markForDeletion;
    protected boolean spawned = false;

    protected boolean pathEnded;

    protected Enemy(Image image, double x, double y, int health, int reward, double speed, boolean doNotRotate) {
        this.health = health;
        this.reward = reward;
        this.imageView = new ImageView(image);
        this.position = Grid.translateToCoords(x, y);
        this.speed = speed;
        this.path = new ArrayList<>();
        this.doNotRotate = doNotRotate;

        this.markForDeletion = false;
    }

    protected Enemy(Image image, double x, double y, int health, int reward, double speed) {
        this(image, x, y, health, reward, speed, false);
    }

    public int getHealth(){
        return this.health;
    }

    public void updateHealth(int value){
        this.health += value;

        if (this.health <= 0) {
            markForDeletion = true;
        }
    }

    public void spawn() {
        spawned = true;
    }

    // Move enemy towards next point in path
    public void move() {

        if (path.isEmpty()) {
            // should do something here -> DONE
            markForDeletion = true;
            return;
        }

        if (!doNotRotate) {
            rotate();
        }

        if (position.distance(path.getFirst()) < 1) {
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
        Point2D nextPosition = path.getFirst();
        double angle = Math.atan2(nextPosition.getY() - position.getY(), nextPosition.getX() - position.getX());
        imageView.setRotate(Math.toDegrees(angle) + 90); // assumes image is facing up
    }

    public void setPath(ArrayList<Point2D> path) {
        this.path = path;
    }

    public boolean isMarkedForDeletion() {
        return markForDeletion;
        // TODO: add coins to player
    }

    // Gets the current position of the enemy
    public Point2D getPosition() {
        return position;
    }

    public void update() {
        if (spawned) {
            move();
        }
    }

    // Renders the enemy
    public void render(GraphicsContext gc) {

        // Get a snapshot of the rotated image with a transparent background
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage rotatedImage = imageView.snapshot(params, null);

        // Draw rotated image at the enemy's position
        // Subtract half of the image's width and height to center the image
        gc.drawImage(rotatedImage, position.getX() - rotatedImage.getWidth() / 2, position.getY() - rotatedImage.getHeight() / 2);
    }

    public int getReward() {
        return reward;
    }


    public boolean hasReachedLastPoint(){
        return path.isEmpty();
    }
}
