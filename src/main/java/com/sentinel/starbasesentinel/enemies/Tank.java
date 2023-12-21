package com.sentinel.starbasesentinel.enemies;

import javafx.scene.image.Image;

public class Tank extends Enemy {
    final static Image image = new Image("file:src/main/resources/enemies/tank/tankslow-up1.gif", 60, 60, true, true);

    public Tank(double x, double y) {
        super(image, x, y, 40, 100, 0.05);
    }
}
