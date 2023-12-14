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


        bg = new Image("file:src/main/resources/level1-test.png");


        // turning points
        tank1.addToPath(Grid.translate(0, 5));
        tank1.addToPath(Grid.translate(4,5 ));
        tank1.addToPath(Grid.translate(4, 11));


    }

    public void render(GraphicsContext gc) {
        gc.drawImage(bg,0,0);
        this.tank1.render(gc);
    }
}
