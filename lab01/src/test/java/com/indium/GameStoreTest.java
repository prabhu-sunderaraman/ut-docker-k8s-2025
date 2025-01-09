package com.indium;

import org.junit.jupiter.api.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameStoreTest {
    private GameStore gameStore;

    @BeforeEach
    void setUp() {
        gameStore = new GameStore();
    }

    @AfterEach
    void tearDown() {
        gameStore = null;
        String folderPath = "/Users/prabhu/Documents/lab01";
        //delete all the files in folderPath
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
    }

    @Test
    void gamestore_is_not_null() {
        assertNotNull(gameStore);
    }

    @Test
    void store_game_results_in_json() {
        int target = 77;
        int attempts = 5;
        String time = LocalDateTime.now().toString();
        GameStoreRecord gameStoreRecord = new GameStoreRecord(target, attempts, time);
        String timestamp = time.substring(0, time.indexOf('.'));
        String fileName = "/Users/prabhu/Documents/lab01/game_results_" + timestamp + ".json";
        boolean result = gameStore.storeResults(fileName, gameStoreRecord);
        assertTrue(result);

    }

    @Test
    void json_file_generated() {
        int target = 77;
        int attempts = 5;
        String time = LocalDateTime.now().toString();
        GameStoreRecord gameStoreRecord = new GameStoreRecord(target, attempts, time);
        String timestamp = time.substring(0, time.indexOf('.'));
        String filePath = "/Users/prabhu/Documents/lab01/game_results_" + timestamp + ".json";
        boolean result = gameStore.storeResults(filePath, gameStoreRecord);
        assertTrue(result);
        boolean fileExists = Files.exists(Paths.get(filePath));
        assertTrue(fileExists);

    }

    @Test
    void error_generating_json_file() {
        int target = 77;
        int attempts = 5;
        String time = LocalDateTime.now().toString();
        GameStoreRecord gameStoreRecord = new GameStoreRecord(target, attempts, time);
        String timestamp = time.substring(0, time.indexOf('.'));
        String incorrectPath = "/sdsUsers/prabhu/Documents/lab01/game_results_" + timestamp + ".json";
        assertThrows(GameStoreException.class, () -> {
            gameStore.storeResults(incorrectPath, gameStoreRecord);
        });

    }
}
