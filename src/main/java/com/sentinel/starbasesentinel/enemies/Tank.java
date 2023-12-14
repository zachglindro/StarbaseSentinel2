package com.sentinel.starbasesentinel.enemies;

import javafx.scene.image.Image;

public class Tank extends Enemy {
    final static Image image = new Image("file:src/main/resources/enemies/tank/tankslow-up.gif", 48, 48, true, true);

    public Tank(double x, double y) {
        super(image, x, y, 0.1, 50);
    }
}
