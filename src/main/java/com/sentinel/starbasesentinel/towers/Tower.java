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

    protected Tower(Image image, double range) {
        this.image = image;
        this.range = Grid.translateToCoords(range);
    }
    
    protected Boolean hasEnemy(ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (position.distance(enemy.getPosition()) <= Grid.translateToCoords(1)) {
                System.out.println(enemy.getClass().getSimpleName());
                return true;
            }
        }
        return false;
    }
    
    public void place(int x, int y) {
        position = Grid.translateToCoords(x, y);
    }
    
    public void render(GraphicsContext gc, ArrayList<Enemy> enemies) {
        hasEnemy(enemies);
        gc.drawImage(image,
                position.getX()-image.getWidth()/2,
                position.getY()-image.getHeight()/2);
    }
}
