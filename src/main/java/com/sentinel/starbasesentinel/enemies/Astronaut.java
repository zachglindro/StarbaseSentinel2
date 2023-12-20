package com.sentinel.starbasesentinel.enemies;

import javafx.scene.image.Image;

public class Astronaut extends Enemy {
    final static Image image = new Image("file:src/main/resources/enemies/astronaut-default/sus.gif", 50, 50, true, true);

    public Astronaut(double x, double y) {
        super(image, x, y, 5, 50, 0.3);
    }
}
