package com.sentinel.starbasesentinel.enemies;

import javafx.scene.image.Image;

public class AstronautFast extends Enemy {
    final static Image image = new Image("file:src/main/resources/enemies/astronaut-fast/astronaut-fast.gif", 50, 50, true, true);

    public AstronautFast(double x, double y) {
        super(image, 3, x, y, 0.35);
    }
}

