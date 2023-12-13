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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu extends Application {
    Image backgroundImage = new Image("file:src/main/resources/mainmenu_bg.png");
    ImageView background = new ImageView(backgroundImage);

    @Override
    public void start(Stage stage) {
        stage.setTitle("Starbase Sentinel");
        stage.setScene(showMainMenu());
        stage.show();
    }

    private Scene showMainMenu() {
        StackPane withBackground = new StackPane();
        background.setPreserveRatio(true);

        BorderPane mainMenu = new BorderPane();
        VBox menuButtons = new VBox();

        // Create logo and its container
        Image logo = new Image("file:src/main/resources/logo.png");
        ImageView logoView = new ImageView(logo);
        logoView.setPreserveRatio(true);

        VBox withLogo = new VBox(30);
        withLogo.getChildren().add(logoView);
        withLogo.setAlignment(Pos.CENTER);

        // Create buttons
        Button startButton = new Button("Start");
        Button aboutButton = new Button("About");
        Button exitButton = new Button("Exit");

        // Set button actions
        startButton.setOnAction(e -> {
            Game game = new Game();
            game.start((Stage) mainMenu.getScene().getWindow()); // ano to
        });
        aboutButton.setOnAction(e -> mainMenu.setCenter(showAboutMenu().getRoot()));
        exitButton.setOnAction(e -> Platform.exit());

        // Add buttons and logo to menu
        menuButtons.getChildren().addAll(startButton, aboutButton, exitButton);
        menuButtons.setAlignment(Pos.CENTER);
        menuButtons.setSpacing(10);
        withLogo.getChildren().add(menuButtons);

        // Add menu to background
        mainMenu.setCenter(withLogo);
        withBackground.getChildren().addAll(background, mainMenu);

        return new Scene(withBackground);
    }

    private Scene showAboutMenu() {
        StackPane withBackground = new StackPane();

        BorderPane aboutMenu = new BorderPane();
        VBox aboutText = new VBox();

        Text about = new Text("Starbase Sentinel, a tower defense game.");
        about.setFill(Color.WHITE);

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> aboutMenu.setCenter(showMainMenu().getRoot()));

        aboutText.getChildren().addAll(about, backButton);
        aboutText.setAlignment(Pos.CENTER);
        aboutText.setSpacing(10);
        aboutMenu.setCenter(aboutText);

        withBackground.getChildren().addAll(background, aboutMenu);

        return new Scene(withBackground);
    }

    @Override
    public void stop() {
        System.out.println("Exited game.");
    }

    public static void main(String[] args) {
        launch();
    }
}