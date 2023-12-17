package com.sentinel.starbasesentinel.levels;

import com.sentinel.starbasesentinel.enemies.Astronaut;
import com.sentinel.starbasesentinel.enemies.AstronautFast;
import com.sentinel.starbasesentinel.enemies.Enemy;
import com.sentinel.starbasesentinel.enemies.Tank;
import com.sentinel.starbasesentinel.towers.BasicTower;
import com.sentinel.starbasesentinel.towers.Bullet;
import com.sentinel.starbasesentinel.towers.Tower;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Level1 extends Level {

    public Level1() {
        super(new Image("file:src/main/resources/levels/level1.png"));
        init();
    }

    @Override
    protected void init() {
        initEnemies();
        initPath();

        // Set path for each enemy
        for (Enemy enemy : enemies) {
            enemy.setPath(path.get());
        }

        // Create tower
        BasicTower basic = new BasicTower();
        basic.place(2,3);

        towers.add(basic);
    }

    @Override
    protected void initEnemies() {
        // Add enemies
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


        // Add enemies to ArrayList
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
    }

    @Override
    public void update() {
        for (Bullet bullet : bullets) {
            bullet.update();
        }
        // Is outside loop to prevent ConcurrentModificationException
        bullets.removeIf(Bullet::isMarkedForDeletion);
        enemies.removeIf(Enemy::isMarkedForDeletion);

        for (Tower tower : towers) {
            tower.update(enemies, bullets);
        }
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
