package com.sentinel.starbasesentinel.enemies;

import javafx.scene.image.Image;

public class Tank extends Enemy {

    public Tank(int x, int y) {
        super(new Image("file:src/main/resources/enemies/tank/tankslow-up.gif", 48, 48, true, true),
                x, y);
        speed = 0.1;
        hp = 50;

    }
}
