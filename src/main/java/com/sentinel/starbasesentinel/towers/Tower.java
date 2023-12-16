package com.sentinel.starbasesentinel.towers;

import com.sentinel.starbasesentinel.Grid;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

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

    public void render(GraphicsContext gc) {
        gc.drawImage(image, position.getX()-image.getWidth()/2, position.getY()-image.getHeight()/2);
    }
}
