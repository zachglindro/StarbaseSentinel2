package com.sentinel.starbasesentinel.levels;

import com.sentinel.starbasesentinel.enemies.Enemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class Level {
    protected final static int WIDTH = 1280;
    protected final static int HEIGHT = 720;
    protected long startTime;
    protected Image bg;
    protected ArrayList<Enemy> enemies;

    public Level(Image bg) {
        this.startTime = System.currentTimeMillis();
        this.enemies = new ArrayList<>();
        this.bg = bg;
    }

    public void render(GraphicsContext gc) {
        // Set background color of level
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.setFill(Color.web("#1b1a17")); // kulay ng slides ni sir jm
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.drawImage(bg,0,0);

        // Render enemies
        for (Enemy enemy : enemies) {
            enemy.render(gc);
        }
    }
}
