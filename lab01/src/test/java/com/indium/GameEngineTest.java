package com.indium;

import org.junit.jupiter.api.*;

import java.lang.reflect.Field;

import static com.indium.GameMessageConstants.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameEngineTest {
    private GameEngine gameEngine;

    @BeforeEach
    public void setup() {
        gameEngine = new GameEngine();
    }

    @AfterEach
    public void tearDown() {
        gameEngine = null;
    }

    @Test
    void game_engine_is_not_null() {
        assertNotNull(gameEngine);
    }

    @Test
    void random_number_is_generated_between_1_and_100() {
        int target = gameEngine.getTarget();
        assertTrue(target >= 1 && target <= 100);
    }

    @Test
    void play_by_entering_a_number_lower_than_the_target() {
        int guess = 0;
        gameEngine.play(guess);
        String message = gameEngine.getMessage();
        assertEquals(AIM_HIGHER, message);
    }

    @Test
    void play_by_entering_a_number_higher_than_the_target() {
        int guess = 101;
        gameEngine.play(guess);
        String message = gameEngine.getMessage();
        assertEquals(AIM_LOWER, message);
    }

    @Test
    void play_by_entering_correct_target() throws NoSuchFieldException {
        initializeTargetTo(77);
        int guess = 77;
        gameEngine.play(77);
        String message = gameEngine.getMessage();
        assertEquals(YOU_VE_GOT_IT, message);
    }

    @Test
    void check_attempts() throws NoSuchFieldException {
        initializeTargetTo(10);
        gameEngine.play(50);
        gameEngine.play(25);
        gameEngine.play(15);
        int attempts = gameEngine.getAttempts();
        assertEquals(attempts, 3);
    }

    @Test
    void play_after_game_is_over() throws NoSuchFieldException {
        initializeTargetTo(77);
        assertThrows(GameOverException.class, () -> {
            gameEngine.play(50);
            gameEngine.play(75);
            gameEngine.play(77); //game is over
            gameEngine.play(90);
        });
    }

    private void initializeTargetTo(int targetValue) throws NoSuchFieldException {
        Class gameEngineCls = gameEngine.getClass();
        Field field = gameEngineCls.getDeclaredField("target");
        field.setAccessible(true);
        try {
            field.set(gameEngine, targetValue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
