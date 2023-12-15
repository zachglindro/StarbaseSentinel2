package com.sentinel.starbasesentinel.towers;


import com.sentinel.starbasesentinel.enemies.Enemy;
import com.sentinel.starbasesentinel.levels.Grid;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Basic extends Tower {
    public Basic() {
        super(new Image("file:src/main/resources/towers/test.png", 50, 50, true, true),
                1);
    }

}
