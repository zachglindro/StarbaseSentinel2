package com.sentinel.starbasesentinel.towers;

import javafx.scene.image.Image;

public class BasicTower extends Tower {
    public BasicTower() {
        super(new Image("file:src/main/resources/towers/basic-tower1.gif", 48, 48, true, true),
                2, 100, 1);
    }
}
