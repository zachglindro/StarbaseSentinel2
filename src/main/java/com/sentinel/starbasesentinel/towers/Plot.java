package com.sentinel.starbasesentinel.towers;

import com.sentinel.starbasesentinel.Grid;
import javafx.geometry.Point2D;

public class Plot {
    private final Point2D gridPosition;
    private final Point2D position;
    private boolean occupied;


    public Plot(int x, int y) {
        this.position = new Point2D(x * Grid.CELL_SIZE, y * Grid.CELL_SIZE);
        this.gridPosition = new Point2D(x, y);
        this.occupied = false;
    }

    public Point2D getGridPosition() {
        return gridPosition;
    }

    public boolean clicked(double x, double y) {
        if (x >= position.getX() && x <= position.getX() + Grid.CELL_SIZE) {
            return y >= position.getY() && y <= position.getY() + Grid.CELL_SIZE;
        }
        return false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void markAsOccupied() {
        occupied = true;
    }
}
