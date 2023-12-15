package com.sentinel.starbasesentinel.levels;

import com.sentinel.starbasesentinel.enemies.Astronaut;
import com.sentinel.starbasesentinel.enemies.Enemy;
import com.sentinel.starbasesentinel.enemies.Tank;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Level {
    final long startTime;
    ArrayList<Enemy> enemies;
    final Image bg;
    public Level() {
        bg = new Image("file:src/main/resources/gridpathtest.png");
        startTime = System.currentTimeMillis();

        // Add enemies
        Tank tank1 = new Tank(-1, 3);
        Astronaut astronaut1 = new Astronaut(-1, 3);
        Astronaut astronaut2 = new Astronaut(-1, 3);
        Astronaut astronaut3 = new Astronaut(-1, 3);

        enemies = new ArrayList<>();
        enemies.add(tank1);
        enemies.add(astronaut1);
        enemies.add(astronaut2);
        enemies.add(astronaut3);

        // Set path for the level
        Path path = new Path();
        path.add(5, 3);
        path.add(5, 6);
        path.add(8, 6);
        path.add(8, 3);
        path.add(5, 3);

        // Set path for each enemy
        for (Enemy enemy : enemies) {
            enemy.setPath(path.get());
        }
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(bg,0,0);

        // Render tank
        enemies.getFirst().render(gc);

        // Render astronauts with 5-second delay
        if (System.currentTimeMillis() - startTime > 5000) {
            enemies.get(1).render(gc);
        }
        if (System.currentTimeMillis() - startTime > 6000) {
            enemies.get(2).render(gc);
        }
        if (System.currentTimeMillis() - startTime > 7000) {
            enemies.get(3).render(gc);
        }
    }
}
