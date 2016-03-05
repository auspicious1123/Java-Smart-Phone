package server;

import java.util.Properties;

import adapter.AutoServer;
import adapter.BuildAuto;
import model.Automobile;

/**
 * @author-Rui Wang rw1
 */
public class BuildCarModelOptions {
    public Automobile buildAutoOptions(Properties properties) {
        AutoServer server = new BuildAuto();
        return server.acceptPropertiesFromClient(properties);
    }

}
