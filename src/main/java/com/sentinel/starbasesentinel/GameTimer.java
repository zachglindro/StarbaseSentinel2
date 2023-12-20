package com.sentinel.starbasesentinel;

import com.sentinel.starbasesentinel.levels.Level;
import com.sentinel.starbasesentinel.towers.Plot;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class GameTimer extends AnimationTimer {
    private final Level level;
    private final Scene scene;
    private final GraphicsContext gc;

    public GameTimer(Level level, Scene scene, GraphicsContext gc) {
        this.level = level;
        this.scene = scene;
        this.gc = gc;
    }
    @Override
    public void handle(long l) {
        level.update();
        level.render(gc);
        this.handleMouseEvent();
    }

    private void handleMouseEvent() {
        ArrayList<Plot> plots = level.getPlots();

        scene.setOnMouseClicked(mouseEvent -> {
            double x = mouseEvent.getX();
            double y = mouseEvent.getY();

            for (Plot plot : plots) {
                if (plot.clicked(x, y) && !plot.isOccupied()) {
                    double plotX = plot.getGridPosition().getX();
                    double plotY = plot.getGridPosition().getY();
                    level.addTower(plotX, plotY);
                    plot.markAsOccupied();
                    System.out.println("Placed tower at " + plotX + ", " + plotY);
                }
            }
        });
    }
}
