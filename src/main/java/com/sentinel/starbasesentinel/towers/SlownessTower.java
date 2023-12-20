package com.sentinel.starbasesentinel.towers;

import javafx.scene.image.Image;

public class SlownessTower extends Tower {
    public SlownessTower() {
        super(new Image("file:src/main/resources/towers/slowness.gif", 60, 60, true, true),
                3, 150, 3);
    }
}
