package com.indium;

import java.util.Scanner;

public class GameConsoleUI {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number between 1 and 100");
        while (!gameEngine.isGameOver()) {
            int guess = scanner.nextInt();
            gameEngine.play(guess);
            System.out.println(gameEngine.getMessage());
        }
        System.out.println("Attempts: %s ".formatted(gameEngine.getAttempts()));
        scanner.close();
    }
}
