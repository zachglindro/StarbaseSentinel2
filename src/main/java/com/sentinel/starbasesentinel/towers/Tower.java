package com.sentinel.starbasesentinel.towers;

import com.sentinel.starbasesentinel.enemies.Enemy;
import com.sentinel.starbasesentinel.Grid;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Tower {
    protected Image image;
    protected Point2D position;
    protected double range;
    protected double cooldownTime;
    protected ArrayList<Bullet> firedBullets;
    protected long lastFiredTime;

    protected Tower(Image image, double range, double cooldownTime) {
        this.image = image;
        this.range = Grid.translateToCoords(range);
        this.cooldownTime = cooldownTime;

        this.firedBullets = new ArrayList<>();
        this.lastFiredTime = System.currentTimeMillis();
    }
    
    protected Boolean enemyInRange(ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (position.distance(enemy.getPosition()) <= Grid.translateToCoords(1)) {
                return true;
            }
        }
        return false;
    }

    protected void fireOn(Enemy enemy) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastFiredTime >= cooldownTime * 1000) {
            Bullet bullet = new Bullet(position, enemy.getPosition());
            firedBullets.add(bullet);
            lastFiredTime = currentTime;
        }
    }
    
    public void place(int x, int y) {
        position = Grid.translateToCoords(x, y);
    }

    public void render(GraphicsContext gc, ArrayList<Enemy> enemies) {
        // Fire a single bullet at the first enemy in range
        if (enemyInRange(enemies)) {
            fireOn(enemies.getFirst());
        }

        // Render bullets
        for (Bullet bullet : firedBullets) {
            bullet.render(gc);
        }

        gc.drawImage(image, position.getX()- Grid.translateToGrid(0.5), position.getY()-Grid.translateToGrid(0.5));
    }
}
