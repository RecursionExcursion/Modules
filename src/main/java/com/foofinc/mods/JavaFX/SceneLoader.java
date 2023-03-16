package com.foofinc.mods.JavaFX;

import com.example.darknotepad.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {

    public static void stageCreator(String viewString, int width, int height){
        try {
            Scene scene = getScene(viewString, width, height);
            Stage stage = new Stage();
            setStage(scene, stage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void stageCreator(String viewString, int width, int height, Stage stage) {
        try {
            Scene scene = getScene(viewString, width, height);
            setStage(scene, stage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Scene getScene(String viewString, int width, int height) throws IOException {
        //TODO 'HelloApplication' is the project starting point
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(viewString));
        Scene scene = new Scene(fxmlLoader.load(), width, height);

        //Optional Css Styling
        scene.getStylesheets().add(CssManager.INSTANCE.getCssUrl());

        return scene;
    }

    private static void setStage(Scene scene, Stage stage) {
        stage.setTitle("Title");
        stage.setScene(scene);
        stage.show();
    }
}
