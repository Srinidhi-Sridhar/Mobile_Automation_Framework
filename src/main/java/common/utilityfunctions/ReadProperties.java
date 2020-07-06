package common.utilityfunctions;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    Properties properties = new Properties();

    private static Logger Log = Logger.getLogger(ReadProperties.class.getName());
    public Properties getProperties(String path) {
        try {
            FileInputStream fin = new FileInputStream(path);
            properties.load(fin);
        } catch (IOException e) {
            Log.error("Caught an IO Exception While Reading Properties File", e);
        }
        return properties;
    }
}
