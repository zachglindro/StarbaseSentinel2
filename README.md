# Starbase Sentinel

Starbase Sentinel is a JavaFX-based tower defense game where players build towers to stop waves of enemies from reaching their base. The game combines a simple grid-based placement system with multiple enemy types, a coin economy, and win/lose conditions.

## Features

- Grid-based tower placement on interactive plots
- Two tower types:
  - Basic Tower: left-click to place, costs 100 coins
  - Speed Tower: right-click to place, costs 150 coins
- Multiple enemy types with different behavior:
  - Astronaut
  - Fast Astronaut
  - Tank
- Coin-based economy and enemy infiltration tracking
- Win/lose state driven by enemy progress and player survival
- JavaFX UI with a main menu, about screen, developer screen, and end screen

## How to Play

1. Launch the game from the main menu.
2. Use the mouse to place towers on available plots.
3. Defend the base by preventing enemies from infiltrating too far.
4. Manage your coins carefully, since tower placement costs resources.
5. Survive long enough to defeat the wave and win the round.

## Requirements

- Java 21
- Maven
- JavaFX 21

## Build and Run

From the project root, run:

```bash
./mvnw clean javafx:run
```

On Windows, you can use:

```bash
mvnw.cmd clean javafx:run
```

You can also compile without launching the game:

```bash
./mvnw clean compile
```

## Project Structure

- src/main/java/com/sentinel/starbasesentinel/ - Main game classes
  - Game.java: starts the game scene
  - GameTimer.java: main game loop and input handling
  - MainMenu.java: menu and UI flow
  - Player.java: player stats, coins, and game-over state
- src/main/java/com/sentinel/starbasesentinel/levels/ - Level logic and wave setup
- src/main/java/com/sentinel/starbasesentinel/enemies/ - Enemy types and behavior
- src/main/java/com/sentinel/starbasesentinel/towers/ - Tower and bullet implementations
- src/main/resources/ - Game assets such as images and level backgrounds

## Notes

- The game currently uses a single level with one wave of enemies.
- Resource paths are currently loaded from the project resources folder, which works well when running from the IDE.
- The game window is fixed at 1280x720.

## Development

The project is built with Maven and uses JavaFX modules configured in the module descriptor. The main application entry point is the MainMenu class.
