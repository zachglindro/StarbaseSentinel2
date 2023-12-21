/********************
 *
 * This file contains the basic code for creating a tower within the game.
 * It contains logic for firing on the nearest enemy within range.
 *
 * @author: Zach Dwayne Glindro, Kervin Ralph Samson
 * @date: 2023-12-21 11:59
 *
 *
 */

package com.sentinel.starbasesentinel.towers;

import com.sentinel.starbasesentinel.Grid;
import com.sentinel.starbasesentinel.enemies.Enemy;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class Tower {
    protected Image image;
    protected Point2D position;
    protected double range; // range of tower. used in detecting nearby enemies
    protected double cooldownTime; // cooldown time between tower's shots
    protected long lastShotTime; // tracks when tower last fired its projectile
    protected int damage;

    protected Tower(Image image, double range, int cost, double cooldownTime, int damage) {
        this.image = image;
        this.range = Grid.translateToCoords(range);
        this.cooldownTime = cooldownTime;
        this.damage = damage;
    }

    // Place a tower on the grid
    public void place(double x, double y) {
        position = Grid.translateToCoords(x, y);
    }

    // Gets the nearest enemy in range
    private Enemy getNearestEnemy(ArrayList<Enemy> enemies) {
        Enemy nearestEnemy = null;
        double nearestDistance = 0;
        for (Enemy enemy : enemies) {
            double distance = position.distance(enemy.getPosition());

            // If the enemy is in range and is the nearest enemy
            if (distance <= range && (nearestEnemy == null || distance < nearestDistance)) {
                // Set the enemy as the nearest enemy
                nearestEnemy = enemy;
                nearestDistance = distance;
            }
        }
        return nearestEnemy;
    }

    // Checks if the tower has an enemy in range
    private boolean hasEnemyInRange(ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (position.distance(enemy.getPosition()) <= range) {
                return true;
            }
        }
        return false;
    }

    public void update(ArrayList<Enemy> enemies, ArrayList<Bullet> bullets) {
        if (hasEnemyInRange(enemies)) {
            // Get the nearest enemy
            Enemy nearestEnemy = getNearestEnemy(enemies);

            // If the tower can fire a bullet
            if (System.currentTimeMillis() - lastShotTime >= cooldownTime * 1000) {
                // Fire a bullet
                bullets.add(new Bullet(position, nearestEnemy, damage));
                lastShotTime = System.currentTimeMillis();
            }
        }
    }

    public void render(GraphicsContext gc) {
        // draw range circle
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(1.0);
        gc.strokeOval(
                position.getX() - range,
                position.getY() - range,
                2 * range,
                2 * range);

        // Draw the tower image
        gc.drawImage(image,
                position.getX() - image.getWidth() / 2,
                position.getY() - image.getHeight() / 2);
    }
}
