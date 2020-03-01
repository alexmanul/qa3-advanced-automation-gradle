package Utils;

import lombok.extern.log4j.Log4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Log4j
public class TestProperties {

    static final String propertyFile = "test.properties";

    public static String getProperty(String property) {
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream(propertyFile);
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.debug("Property key: " + property + ", property value: " + properties.getProperty(property));
        return properties.getProperty(property);
    }
}
