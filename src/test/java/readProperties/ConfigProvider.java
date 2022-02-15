package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ?ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                :ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
    String ADMIN_LOGIN = readConfig().getString("userParams.admin.login");
    String ADMIN_PASSWORD = readConfig().getString("userParams.admin.password");
    Boolean IS_DEMO_ADMIN = readConfig().getBoolean("userParams.admin.isAdmin");
}



