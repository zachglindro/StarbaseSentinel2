package com.sentinel.starbasesentinel.towers;

import com.sentinel.starbasesentinel.Grid;
import javafx.geometry.Point2D;

public class Plot {
    Point2D position;

    public Plot(int x, int y) {
        this.position = Grid.translateToCoords(x, y);
    }
}
