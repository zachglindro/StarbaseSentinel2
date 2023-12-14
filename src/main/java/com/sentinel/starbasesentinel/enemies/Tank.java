package com.sentinel.starbasesentinel.enemies;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Tank extends Enemy {

    public Tank(Point2D initialPosition) {
        super(new Image("file:src/main/resources/enemies/tank.png", 50, 50, true, true),
                initialPosition);

        speed = 1;
        hp = 50;
    }
}
