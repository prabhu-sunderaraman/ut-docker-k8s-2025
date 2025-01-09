package com.indium.ui;

import com.indium.GameEngine;
import com.indium.GameStore;
import com.indium.GameStoreRecord;

import java.util.Scanner;

public class GameConsoleUI {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        GameStore gameStore = new GameStore();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number between 1 and 100");
        while (!gameEngine.isGameOver()) {
            int guess = scanner.nextInt();
            gameEngine.play(guess);
            System.out.println(gameEngine.getMessage());
        }
        //You want this to be automatically invoked. How do you link GameEngine and GameStore?
        gameStore.storeResults("/Users/prabhu/Documents/lab01/game.json", new GameStoreRecord(gameEngine.getTarget(), gameEngine.getAttempts(), "2025-01-09"));
        System.out.println("Attempts: %s ".formatted(gameEngine.getAttempts()));
        scanner.close();
    }
}
