package com.proyectopsp.proyectopsp.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

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
            return Integer.parseInt((br.readLine()));
        } catch (Exception e) {
            return 0;
        }
    }

    private static void saveLastId(Integer id) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write(id.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
