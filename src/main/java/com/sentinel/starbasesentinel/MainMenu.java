package com.sentinel.starbasesentinel;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class MainMenu extends Application {
    @Override
    public void start(@NotNull Stage stage) {
        stage.setMinHeight(600);
        stage.setMaxHeight(600);
        stage.setMaxWidth(600);
        stage.setMinWidth(600);

        stage.setTitle("Starbase Sentinel");
        stage.setScene(showMainMenu());
        stage.show();
    }

    private Scene showMainMenu() {
        StackPane withBackground = new StackPane();

        Image background = new Image("file:src/main/resources/bg.jpg");
        ImageView backgroundView = new ImageView(background);

        BorderPane mainMenu = new BorderPane();
        VBox menuButtons = new VBox();

        Button startButton = new Button("Start");
        Button aboutButton = new Button("About");
        Button exitButton = new Button("Exit");

        startButton.setOnAction(e -> {
            Game game = new Game();
            game.start((Stage) mainMenu.getScene().getWindow());
        });

        aboutButton.setOnAction(e -> mainMenu.setCenter(showAboutMenu().getRoot()));
        exitButton.setOnAction(e -> Platform.exit());

        menuButtons.getChildren().addAll(startButton, aboutButton, exitButton);
        menuButtons.setAlignment(Pos.CENTER);
        menuButtons.setSpacing(10);

        mainMenu.setCenter(menuButtons);

        withBackground.getChildren().addAll(backgroundView, mainMenu);

        return new Scene(withBackground);
    }

    private Scene showAboutMenu() {
        BorderPane aboutMenu = new BorderPane();
        VBox aboutText = new VBox();

        Text about = new Text("Starbase Sentinel, a tower defense game.");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> aboutMenu.setCenter(showMainMenu().getRoot()));

        aboutText.getChildren().addAll(about, backButton);
        aboutText.setAlignment(Pos.CENTER);
        aboutText.setSpacing(10);

        aboutMenu.setCenter(aboutText);

        return new Scene(aboutMenu);
    }

    @Override
    public void stop() {
        System.out.println("Exited game.");
    }

    public static void main(String[] args) {
        launch();
    }
}