package com.StringCrud;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.StringCrud.models.Person;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Loader {

    private static final String FILE_NAME = "file.properties";

    public void saveToFile(Map<Integer, Person> map) {
        try (FileOutputStream fos = new FileOutputStream(getFileOrCreateIfNotExists())) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
        } catch (Exception e) {
            throw new RuntimeException("Error saving data to file: " + e.getMessage());
        }
    }

    public Map<Integer, Person> loadFromFile() {
        try (FileInputStream fis = new FileInputStream(getFileOrCreateIfNotExists())) {
            Map<Integer, Person> map;
            ObjectInputStream ois = new ObjectInputStream(fis);
            map = (HashMap) ois.readObject();
            return map;
        } catch (Exception e) {
            throw new RuntimeException("Error reading data from file: " + e.getMessage());
        }
    }

    private File getFileOrCreateIfNotExists() throws IOException {
        String path = System.getProperty("user.home") + File.separator + FILE_NAME;
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

}