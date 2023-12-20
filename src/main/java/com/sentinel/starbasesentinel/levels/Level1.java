package com.sentinel.starbasesentinel.levels;

import com.sentinel.starbasesentinel.enemies.Astronaut;
import com.sentinel.starbasesentinel.enemies.AstronautFast;
import com.sentinel.starbasesentinel.enemies.Enemy;
import com.sentinel.starbasesentinel.enemies.Tank;
import com.sentinel.starbasesentinel.towers.Bullet;
import com.sentinel.starbasesentinel.towers.Plot;
import com.sentinel.starbasesentinel.towers.Tower;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Level1 extends Level {

    public Level1() {
        super(new Image("file:src/main/resources/levels/level1.png"));
        init();
    }

    @Override
    protected void init() {
        initEnemies();
        initPath();
        initPlots();
    }

    @Override
    protected void initEnemies() {
        wave1();
    }

    private void wave1() {
        Tank tank1 = new Tank(-1, 4);
        Astronaut a1 = new Astronaut(-1, 4);
        Astronaut a2 = new Astronaut(-1, 4);
        Astronaut a3 = new Astronaut(-1, 4);
        Astronaut a4 = new Astronaut(-1, 4);
        Astronaut a5 = new Astronaut(-1, 4);
        Astronaut a6 = new Astronaut(-1, 4);
        Astronaut a7 = new Astronaut(-1, 4);
        Astronaut a8 = new Astronaut(-1, 4);
        AstronautFast f1 = new AstronautFast(-1,4);
        enemies.add(a1);
        enemies.add(a2);
        enemies.add(a3);
        enemies.add(a4);
        enemies.add(a5);
        enemies.add(a6);
        enemies.add(a7);
        enemies.add(a8);
        enemies.add(f1);
        enemies.add(tank1);
    }

    @Override
    protected void initPath() {
        path.add(5, 4);
        path.add(5, 13);
        path.add(9, 13);
        path.add(9, 1);
        path.add(13, 1);
        path.add(13, 6);
        path.add(17, 6);
        path.add(17, 1);
        path.add(21, 1);
        path.add(21, 8);
        path.add(25, 8);

        // Set path for each enemy
        for (Enemy enemy : enemies) {
            enemy.setPath(path.get());
        }
    }

    @Override
    protected void initPlots() {
        plots.add(new Plot(2, 3));
        plots.add(new Plot(4, 8));
        plots.add(new Plot(7, 11));
        plots.add(new Plot(8, 5));
        plots.add(new Plot(10, 8));
        plots.add(new Plot(11, 3));
        plots.add(new Plot(11, 0));
        plots.add(new Plot(15, 4));
        plots.add(new Plot(15, 7));
        plots.add(new Plot(19, 3));
        plots.add(new Plot(22, 5));
    }

    @Override
    public void render(GraphicsContext gc) {
        // Render background color of level
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.drawImage(bg,0,0);

        // Render towers
        for (Tower tower : towers) {
            tower.render(gc);
        }

        // Render bullets
        for (Bullet bullet : bullets) {
            bullet.render(gc);
        }

        // Render enemies with 1 second duration in between
        for (Enemy enemy : enemies) {
            if (System.currentTimeMillis() - startTime > (enemies.indexOf(enemy) + 1) * 1000L) {
                enemy.render(gc);
            }
        }
    }
}
