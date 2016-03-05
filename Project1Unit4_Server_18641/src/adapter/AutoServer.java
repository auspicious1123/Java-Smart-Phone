package adapter;

import java.util.Properties;

import model.Automobile;

/**
 * @author-Rui Wang rw1
 * This is used for server to provide automobile features.
 */
public interface AutoServer {
    public Automobile acceptPropertiesFromClient(Properties properties);
    public String listAutomobileNames();
}
