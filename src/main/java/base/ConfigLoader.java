package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static Properties props;

    // Method to load the properties file
    public static void fileLoader() throws IOException {
        // Initialize the Properties object
        props = new Properties();

        // Load the properties file
        try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new IOException("Error loading config.properties file", e);
        }
    }

    // Method to get a specific property value by key
    public static String getProperty(String key) {
        if (props == null) {
            throw new IllegalStateException("Properties file not loaded. Call fileLoader() first.");
        }
        return props.getProperty(key);
    }

    // Method to get the entire Properties object
    public static Properties getProps() {
        if (props == null) {
            throw new IllegalStateException("Properties file not loaded. Call fileLoader() first.");
        }
        return props;
    }
}
