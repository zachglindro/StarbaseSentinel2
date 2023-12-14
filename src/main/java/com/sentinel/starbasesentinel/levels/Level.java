package com.sentinel.starbasesentinel.levels;

import com.sentinel.starbasesentinel.enemies.Tank;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Level {
    Tank tank1;
    Image bg;
    public void init() {
        // Add tank
        this.tank1 = new Tank(0, 700);


        bg = new Image("file:src/main/resources/grid.png");


        // turning points
        tank1.addToPath(Grid.translate(0, 6));
        tank1.addToPath(Grid.translate(1, 6));
        tank1.addToPath(Grid.translate(0, 0));


    }

    public void render(GraphicsContext gc) {
        gc.drawImage(bg,0,0);
        this.tank1.render(gc);
    }
}
