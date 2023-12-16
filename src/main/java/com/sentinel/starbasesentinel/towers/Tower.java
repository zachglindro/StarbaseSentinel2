package com.sentinel.starbasesentinel.towers;

import com.sentinel.starbasesentinel.Grid;
import com.sentinel.starbasesentinel.enemies.Enemy;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Tower {
    protected Image image;
    protected Point2D position;
    protected double range;
    protected double cooldownTime;
    protected long lastShotTime;

    protected Tower(Image image, double range, double cooldownTime) {
        this.image = image;
        this.range = Grid.translateToCoords(range);
        this.cooldownTime = cooldownTime;
    }

    // Place a tower on the grid
    public void place(int x, int y) {
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
                bullets.add(new Bullet(position, nearestEnemy));
                lastShotTime = System.currentTimeMillis();
            }
        }
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image,
                position.getX()-image.getWidth()/2,
                position.getY()-image.getHeight()/2);
    }
}
