package com.sentinel.starbasesentinel.levels;

import javafx.geometry.Point2D;

import java.util.ArrayList;

public class Path {
    ArrayList<Point2D> path;

    public Path() {
        path = new ArrayList<>();
    }

    public void add(int x, int y) {
        path.add(Grid.translate(x, y));
    }

    // Return a copy of the path
    public ArrayList<Point2D> get() {
        return new ArrayList<>(path);
    }
}
