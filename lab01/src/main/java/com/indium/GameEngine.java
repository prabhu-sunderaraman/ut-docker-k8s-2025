package com.indium;

import static com.indium.GameMessageConstants.*;

public class GameEngine {

    private int target = (int) (Math.random() * 100) + 1;
    private String message;
    private int attempts;
    private boolean gameOver;

    public int getTarget() {
        return target;
    }

    public void play(int guess) {
        checkIfGameIsAlreadyOver();
        attempts++;
        if (guess < target) {
            message = AIM_HIGHER;
        } else if (guess > target) {
            message = AIM_LOWER;
        } else if (guess == target) {
            message = YOU_VE_GOT_IT;
            gameOver = true;
        }
    }

    private void checkIfGameIsAlreadyOver() {
        if (gameOver) {
            throw new GameOverException();
        }
    }

    public String getMessage() {
        return message;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
