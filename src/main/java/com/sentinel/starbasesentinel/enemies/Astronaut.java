package com.sentinel.starbasesentinel.enemies;

import javafx.scene.image.Image;

public class Astronaut extends Enemy {
    public Astronaut(int x, int y) {
        super(new Image("file:src/main/resources/enemies/astronaut.gif", 50, 50, true, true),
                x, y);
        speed = 0.5;
        hp = 20;
    }
}
