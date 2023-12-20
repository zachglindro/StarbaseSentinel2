package com.sentinel.starbasesentinel.towers;

import javafx.scene.image.Image;

public class SpeedTower extends Tower{
    public SpeedTower(){
        super(new Image("file:src/main/resources/towers/speed-tower.gif", 48, 48, true, true),
                3, 150, 0.2, 1);
    }
}
