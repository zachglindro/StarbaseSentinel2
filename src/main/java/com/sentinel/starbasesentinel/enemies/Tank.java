package com.sentinel.starbasesentinel.enemies;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Tank extends Enemy {

    public Tank(Point2D startPos) {
        super(new Image("file:src/main/resources/enemies/tankslow-up.gif", 48, 48, true, true),
                startPos);
        speed = 0.1;
        hp = 50;

    }
}
