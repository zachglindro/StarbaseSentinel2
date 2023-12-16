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

    protected Tower(Image image, double range, double cooldownTime) {
        this.image = image;
        this.range = Grid.translateToCoords(range);
        this.cooldownTime = cooldownTime;
    }

    // Place a tower on the grid
    public void place(int x, int y) {
        position = Grid.translateToCoords(x, y);
    }

    private boolean hasEnemyInRange(ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (position.distance(enemy.getPosition()) <= range) {
                return true;
            }
        }
        return false;
    }

    public void update(ArrayList<Enemy> enemies) {
        if (hasEnemyInRange(enemies)) {
            System.out.println("Enemy in range");
        }
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image,
                position.getX()-image.getWidth()/2,
                position.getY()-image.getHeight()/2);
    }
}
