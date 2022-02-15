package readProperties;

import org.testng.annotations.Test;
import tests.BaseTest;

import java.io.IOException;

public class PropertiesTest extends BaseTest {
    /**
     * Чтение пропертей из файла
     */
    @Test
    public void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String urlFromProperties = System.getProperty("url");
        System.out.println(urlFromProperties);
    }
    /**
     * Чтение conf файла
     */
    @Test
    public void readFromConfig(){
        String urlFromConf = ConfigProvider.URL;
        System.out.println(urlFromConf);
        boolean isDemoAdmin = ConfigProvider.IS_DEMO_ADMIN;
        System.out.println(isDemoAdmin);
    }
}

