package com.sentinel.starbasesentinel.levels;

import com.sentinel.starbasesentinel.Player;
import com.sentinel.starbasesentinel.enemies.Enemy;
import com.sentinel.starbasesentinel.towers.BasicTower;
import com.sentinel.starbasesentinel.towers.Bullet;
import com.sentinel.starbasesentinel.towers.Plot;
import com.sentinel.starbasesentinel.towers.Tower;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Level {
    protected final static int WIDTH = 1280;
    protected final static int HEIGHT = 720;
    protected long startTime;
    protected Image bg;
    protected Path path;
    protected ArrayList<Enemy> enemies;
    protected ArrayList<Tower> towers;
    protected ArrayList<Bullet> bullets;
    protected ArrayList<Plot> plots;

    public Level(Image bg) {
        this.startTime = System.currentTimeMillis();
        this.bg = bg;

        this.enemies = new ArrayList<>();
        this.towers = new ArrayList<>();
        this.bullets = new ArrayList<>();
        this.plots = new ArrayList<>();

        this.path = new Path();
    }

    protected abstract void init();
    protected abstract void initEnemies(); // initialize enemies to spawn for the level
    protected abstract void initPath(); // initialize path for the level
    protected abstract void initPlots(); // initialize plots for the level
    public void update(Player player) {
        for (Bullet bullet : bullets) {
            bullet.update();
        }

        for (Enemy enemy : enemies) {
            if (enemy.isMarkedForDeletion()) {
                player.addCoins(enemy.getReward());
            }
        }

        // Is outside loop to prevent ConcurrentModificationException
        bullets.removeIf(Bullet::isMarkedForDeletion);
        enemies.removeIf(Enemy::isMarkedForDeletion);

        for (Tower tower : towers) {
            tower.update(enemies, bullets);
        }
    }
    public abstract void render(GraphicsContext gc);
    public ArrayList<Plot> getPlots() {
        return plots;
    }

    // TODO: custom addAstronauts method para hindi repetitive yung pag-add nila
    public void addTower(double x, double y) {
        Tower tower = new BasicTower();
        tower.place(x, y);
        towers.add(tower);
    }
}
