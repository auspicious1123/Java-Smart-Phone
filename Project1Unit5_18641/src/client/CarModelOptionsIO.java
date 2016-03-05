package client;

import java.util.Properties;

import util.FileIO;

/**
 * @author-Rui Wang rw1
 */
public class CarModelOptionsIO {
    public Properties readPropertiesFile(String filename){
        FileIO io = new FileIO();
        Properties properties = io.readPropertiesFile(filename);
        return properties;
    }
}
