package com.sentinel.starbasesentinel.enemies;

import javafx.scene.image.Image;

public class UFO extends Enemy {

    public UFO(Image image, int x, int y) {
        super(new Image("file:src/main/resources/enemies/ufo.png"),
                x,
                y);
    }
}
