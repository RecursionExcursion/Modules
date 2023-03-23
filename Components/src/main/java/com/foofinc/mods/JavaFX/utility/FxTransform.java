package com.foofinc.mods.JavaFX.utility;

import javafx.scene.Node;
import javafx.stage.Stage;

public class FxTransform {

    public static Stage nodeToStage(Node node) {
        return (Stage) node.getScene().getWindow();
    }
}
