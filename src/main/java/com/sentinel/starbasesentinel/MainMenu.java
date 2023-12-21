/********************
 *
 * Starbase Sentinel is a tower defense game.
 * Build towers to defend against enemies trying to reach your base!
 *
 * @author: Zach Dwayne Glindro, Kervin Ralph Samson
 * @date: 2023-12-21 11:59
 *
 *
 */

package com.sentinel.starbasesentinel;

import javafx.animation.AnimationTimer;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu extends Application {
    private final Image backgroundImage = new Image("file:src/main/resources/simple-space2.png");
    private final ImageView background = new ImageView(backgroundImage);
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) {

        primaryStage = stage; // store stage as a class-level variable para magamit sa ibang methods

        stage.setTitle("Starbase Sentinel");
        stage.setMinWidth(1280);
        stage.setMinHeight(720);
        stage.setMaxHeight(720);
        stage.setMaxWidth(1280);
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

        // Logo animation
        double speed = 0.05; // Speed of animation
        double maxHeight = 15;
        new AnimationTimer() {
            boolean movingUp = true;
            public void handle(long currentNanoTime) {
                if (movingUp) {
                    logoView.setTranslateY(logoView.getTranslateY() - speed);
                    if (logoView.getTranslateY() <= -maxHeight) {
                        movingUp = false;
                    }
                } else {
                    logoView.setTranslateY(logoView.getTranslateY() + speed);
                    if (logoView.getTranslateY() >= 0) {
                        movingUp = true;
                    }
                }
            }
        }.start();

        // Create buttons
        Button startButton = new Button("Start");
        Button aboutButton = new Button("About");
        Button developersButton = new Button("Developers");
        Button exitButton = new Button("Exit");

        // Set button actions
        startButton.setOnAction(e -> {
            Game game = new Game();
            game.start((Stage) mainMenu.getScene().getWindow()); // ano to
        });
        aboutButton.setOnAction(e -> mainMenu.setCenter(showAboutMenu().getRoot()));
        developersButton.setOnAction(e -> mainMenu.setCenter(showDevelopersMenu().getRoot()));
        exitButton.setOnAction(e -> Platform.exit());

        // Add buttons and logo to menu
        menuButtons.getChildren().addAll(startButton, aboutButton, developersButton, exitButton);
        menuButtons.setAlignment(Pos.CENTER);
        menuButtons.setSpacing(10);
        withLogo.getChildren().add(menuButtons);

        // Get button css stylesheet
        menuButtons.getStylesheets().add("file:src/main/style/button-styles.css");

        // Add menu to background
        mainMenu.setCenter(withLogo);
        withBackground.getChildren().addAll(background, mainMenu);

        return new Scene(withBackground);
    }

    private Scene showAboutMenu() {
        Text about = new Text("Starbase Sentinel, a tower defense game.");
        Text enemies = new Text("Prevent your enemies from reaching your base by");
        Text towers = new Text("left-clicking and right-clicking on plots to build defending towers.");
        Text economy = new Text("Manage your coins while doing so, though, as towers are costly.");
        Text win = new Text("Kill all your enemies and prevent your base from belonging to them!");

        VBox aboutContent= new VBox(about, enemies, towers, economy, win);

        for (int i = 0; i < aboutContent.getChildren().size(); i++) {
            Text text = (Text) aboutContent.getChildren().get(i);
            text.setFill(Color.WHITE);
        }

        StackPane withBackground = new StackPane();
        BorderPane bp = new BorderPane();

        Button backButton = new Button("Back");
        backButton.getStylesheets().add("file:src/main/style/button-styles.css");
        backButton.setOnAction(e -> bp.setCenter(showMainMenu().getRoot()));

        aboutContent.getChildren().add(backButton);
        aboutContent.setAlignment(Pos.CENTER);
        aboutContent.setSpacing(10);

        bp.setCenter(aboutContent);

        withBackground.getChildren().addAll(background, bp);

        return new Scene(withBackground);
    }

    private Scene showDevelopersMenu() {
        Text developers = new Text("Developers");
        Text zach = new Text("Zach Dwayne Glindro");
        Text zachFluff = new Text("Favorite game: Witcher 3");
        Text kervin = new Text("Kervin Ralph Samson");
        Text kervinFluff = new Text("Gaming.");

        VBox developersContent = new VBox(developers, zach, zachFluff, kervin, kervinFluff);

        developers.setFont(Font.font(30));
        zach.setFont(Font.font(20));
        kervin.setFont(Font.font(20));
        for (int i = 0; i < developersContent.getChildren().size(); i++) {
            Text text = (Text) developersContent.getChildren().get(i);
            text.setFill(Color.WHITE);
        }

        StackPane withBackground = new StackPane();
        BorderPane bp = new BorderPane();

        Button backButton = new Button("Back");
        backButton.getStylesheets().add("file:src/main/style/button-styles.css");
        backButton.setOnAction(e -> bp.setCenter(showMainMenu().getRoot()));

        developersContent.getChildren().add(backButton);
        developersContent.setAlignment(Pos.CENTER);
        developersContent.setSpacing(10);

        bp.setCenter(developersContent);

        withBackground.getChildren().addAll(background, bp);

        return new Scene(withBackground);
    }

    public static void showEndScreen(String text) {
        StackPane withBackground = new StackPane();
        BorderPane bp = new BorderPane();

        Text endText = new Text(text);
        endText.setFont(Font.font(30));
        endText.setFill(Color.WHITE);

        Button backButton = new Button("Back");
        backButton.getStylesheets().add("file:src/main/style/button-styles.css");
        backButton.setOnAction(e -> bp.setCenter(new MainMenu().showMainMenu().getRoot()));

        VBox endContent = new VBox(endText, backButton);
        endContent.setAlignment(Pos.CENTER);
        endContent.setSpacing(10);

        bp.setCenter(endContent);

        withBackground.getChildren().addAll(new ImageView(new Image("file:src/main/resources/simple-space2.png")), bp);

        Scene endScene = new Scene(withBackground);
        primaryStage.setScene(endScene);
//        Stage endStage = new Stage();
//        endStage.setScene(endScene);
//        endStage.show();
    }


    @Override
    public void stop() {
        System.out.println("Exited game.");
    }

    public static void main(String[] args) {
        launch();
    }
}