package com.sentinel.starbasesentinel.levels;

import com.sentinel.starbasesentinel.enemies.Astronaut;
import com.sentinel.starbasesentinel.enemies.Enemy;
import com.sentinel.starbasesentinel.enemies.Tank;
import com.sentinel.starbasesentinel.towers.Basic;
import com.sentinel.starbasesentinel.towers.Bullet;
import com.sentinel.starbasesentinel.towers.Tower;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Level1 extends Level {

    public Level1() {
        super(new Image("file:src/main/resources/gridpathtest.png"));
        init();
    }

    private void init() {
        // Add enemies
        Tank tank1 = new Tank(-1, 3);
        Astronaut astronaut1 = new Astronaut(-1, 3);
        Astronaut astronaut2 = new Astronaut(-1, 3);
        Astronaut astronaut3 = new Astronaut(-1, 3);

        // Add enemies to ArrayList
        enemies.add(tank1);
        enemies.add(astronaut1);
        enemies.add(astronaut2);
        enemies.add(astronaut3);

        // Set path for the level
        Path path = new Path(); // arraylist din lang to, di ko alam kung magandang abstraction
        path.add(5, 3);
        path.add(5, 6);
        path.add(8, 6);
        path.add(8, 3);
        path.add(5, 3);

        // Set path for each enemy
        for (Enemy enemy : enemies) {
            enemy.setPath(path.get());
        }

        // Create tower
        Basic basic = new Basic();
        basic.place(5,3);

        towers.add(basic);
    }

    @Override
    public void render(GraphicsContext gc) {
        // Render background color of level
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.setFill(Color.web("#1b1a17")); // kulay ng slides ni sir jm
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.drawImage(bg,0,0);

        // Render towers
        for (Tower tower : towers) {
            tower.update(enemies, bullets);
            tower.render(gc);
        }

        // Render bullets
        for (Bullet bullet : bullets) {
            bullet.render(gc);
        }

        // Render tank
        enemies.getFirst().render(gc);

        // Render astronauts with 5-second delay
        if (System.currentTimeMillis() - this.startTime > 5000) {
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
