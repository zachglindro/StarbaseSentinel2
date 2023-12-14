package com.sentinel.starbasesentinel.enemies;

import javafx.scene.image.Image;

public class Astronaut extends Enemy {
    final static Image image = new Image("file:src/main/resources/enemies/astronaut.gif", 50, 50, true, true);

    public Astronaut(double x, double y) {
        super(image, x, y, 0.5, 20, true);
    }
}
