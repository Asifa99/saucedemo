package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class ConfigLoader {
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.json";
    private static Map<String, Object> configMap;

    // Private constructor to prevent instantiation
    private ConfigLoader() {
    }

    // Method to load and return the JSON as a Map
    public static Map<String, Object> getConfig() {
        if (configMap == null) {
            loadConfig();
        }
        return configMap;
    }

    // Load the JSON file into a Map
    private static void loadConfig() {
        try (FileReader reader = new FileReader(CONFIG_FILE_PATH)) {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, Object>>() {}.getType();
            configMap = gson.fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + CONFIG_FILE_PATH, e);
        }
    }
}
