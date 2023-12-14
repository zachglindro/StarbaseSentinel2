package com.sentinel.starbasesentinel.enemies;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class UFO extends Enemy {

    public UFO(Image image, Point2D startPos) {
        super(new Image("file:src/main/resources/enemies/ufo.png"),
                startPos);
    }
}
