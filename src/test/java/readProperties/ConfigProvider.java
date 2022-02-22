package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ?ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                :ConfigFactory.load("application.properties");
    }

    String URL = readConfig().getString("url");
    String ADMIN_LOGIN = readConfig().getString("user.admin.login");
    String ADMIN_PASSWORD = readConfig().getString("user.admin.password");
    Boolean IS_DEMO_ADMIN = readConfig().getBoolean("user.admin.isAdmin");
}



