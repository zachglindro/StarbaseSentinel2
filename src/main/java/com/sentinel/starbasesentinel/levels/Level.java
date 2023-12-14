package com.sentinel.starbasesentinel.levels;

import com.sentinel.starbasesentinel.enemies.Tank;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Level {
    Tank tank1;

    public void init() {
        // Add tank
        this.tank1 = new Tank(new Point2D(0,700));

        // turning points
        tank1.addToPath(0,400);
        tank1.addToPath(400,400);
        tank1.addToPath(1000,0);
        tank1.addToPath(640,360);
    }

    public void render(GraphicsContext gc) {
        this.tank1.render(gc);
    }
}
