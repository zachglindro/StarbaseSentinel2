package com.sentinel.starbasesentinel;

import javafx.geometry.Point2D;

public class Grid {
    // 1280x720 is converted to 26x15 grid
    final static int cellSize = 48; // Cell size in pixels

    public static Point2D translateToCoords(double x, double y) {
        return new Point2D(x * cellSize + 24, y * cellSize + 24);
    }

    public static double translateToCoords(double x) {
        return x * cellSize + 24;
    }

    public static Point2D translateToGrid(double x, double y) {
        return new Point2D((x - 24) / cellSize, (y - 24) / cellSize);
    }

    public static double translateToGrid(double x) {
        return (x - 24) / cellSize;
    }
}
