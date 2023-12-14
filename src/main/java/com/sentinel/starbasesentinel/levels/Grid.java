package com.sentinel.starbasesentinel.levels;

import javafx.geometry.Point2D;

public class Grid {
    // 1280x720 is converted to 26x15 grid
    final static int cellSize = 48; // Cell size in pixels

    public static Point2D translate(double x, double y) {
        return new Point2D(x * cellSize + 24, y * cellSize + 24);
    }
}
