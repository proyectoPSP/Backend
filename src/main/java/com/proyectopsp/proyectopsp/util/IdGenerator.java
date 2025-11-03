package com.proyectopsp.proyectopsp.util;

import java.io.BufferedReader;
import java.io.FileReader;

public class IdGenerator {
    private static final String FILE_NAME = "id.txt";
    private static Integer lastId = null;

    public static synchronized Integer getNextId() {
        if (lastId == null) {
            lastId = loadLastID();
        }
        lastId++;
        saveLastId(lastId);
        return lastId;
    }

    private static Integer loadLastID() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            return
        }
    }
}
