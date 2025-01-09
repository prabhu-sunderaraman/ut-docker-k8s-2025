package com.indium;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameStore {
    public boolean storeResults(String filePath, GameStoreRecord gameStoreRecord) {
        String json = """ 
                {
                "target": %s,
                "attempts": %s,
                "datetime": %s 
                }
                """.formatted(gameStoreRecord.target(), gameStoreRecord.attempts(), gameStoreRecord.time());
        try {
            Files.write(Paths.get(filePath), json.getBytes());
        } catch (IOException e) {
            throw new GameStoreException(e.getMessage());
        }
        return true;
    }
}
