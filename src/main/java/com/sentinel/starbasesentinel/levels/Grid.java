package com.sentinel.starbasesentinel.levels;

import javafx.geometry.Point2D;

public class Grid {
    // 1280x720 is converted to 26x15 grid
    static int cellSize = 48;

    public static Point2D translate(int x, int y) {
        return new Point2D(x * cellSize + 24, y * cellSize + 24);
    }
}
