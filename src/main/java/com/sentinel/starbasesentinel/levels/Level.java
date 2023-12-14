package com.sentinel.starbasesentinel.levels;

import com.sentinel.starbasesentinel.enemies.Tank;
import javafx.scene.canvas.GraphicsContext;

public class Level {
    Tank tank1;

    public void init() {
        // Add tank
        this.tank1 = new Tank(0, 700);

        // turning points
        tank1.addToPath(Grid.translate(0, 2));
        tank1.addToPath(Grid.translate(20, 4));

    }

    public void render(GraphicsContext gc) {
        this.tank1.render(gc);
    }
}
