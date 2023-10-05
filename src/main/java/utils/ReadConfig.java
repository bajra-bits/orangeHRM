package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ReadConfig {
    Properties props;

    public ReadConfig() {
        props = new Properties();
        try {
            InputStream input = new FileInputStream("src/main/resources/configs/config.properties");
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read from file");
        }
    }

    public HashMap<String, String> getDriverConfig() {
        HashMap config = new HashMap();
        config.put("url", props.getProperty("url"));
        config.put("type", props.getProperty("type"));
        config.put("waitTime", props.getProperty("waitTime"));
        config.put("sleepTime", props.getProperty("sleepTime"));

        return config;
    }
}
