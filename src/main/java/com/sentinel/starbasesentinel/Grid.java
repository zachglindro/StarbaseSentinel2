/********************
 *
 * Grid class is used to translate between pixels and game coords.
 * 1280x720 screen is converted to (roughly) 26x15 grid.
 * 0,0 is at top left.
 *
 * @author: Zach Dwayne Glindro, Kervin Ralph Samson
 * @date: 2023-12-21 11:59
 *
 *
 */

package com.sentinel.starbasesentinel;

import javafx.geometry.Point2D;

public class Grid {
    public final static int CELL_SIZE = 48; // Cell size in pixels

    public static Point2D translateToCoords(double x, double y) {
        return new Point2D(x * CELL_SIZE + 24, y * CELL_SIZE + 24);
    }

    public static double translateToCoords(double x) {
        return x * CELL_SIZE + 24;
    }

    public static Point2D translateToGrid(double x, double y) {
        return new Point2D((x - 24) / CELL_SIZE, (y - 24) / CELL_SIZE);
    }

    public static double translateToGrid(double x) {
        return (x - 24) / CELL_SIZE;
    }
}
