package com.sentinel.starbasesentinel.towers;

import com.sentinel.starbasesentinel.Grid;
import javafx.geometry.Point2D;

public class Plot {
    Point2D position;

    public Plot(int x, int y) {
        this.position = new Point2D(x * Grid.CELL_SIZE, y * Grid.CELL_SIZE);
    }

    public boolean clicked(double x, double y) {
        if (x >= position.getX() && x <= position.getX() + Grid.CELL_SIZE) {
            return y >= position.getY() && y <= position.getY() + Grid.CELL_SIZE;
        }
        return false;
    }
}
