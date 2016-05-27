package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Nick_Nie on 3/7/2016.
 */
public class TestContext {

    public static final String PROJECT_PROPERTIES= "project.properties";
    private BrowserType browserType;
    private BrowserProfile browserProfile;

    public TestContext(){
        initialize();
    }

    public BrowserType getBrowserType(){
        return browserType;
    }

    public BrowserProfile getBrowserProfile(){
        return browserProfile;
    }


    public void initialize(){
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(PROJECT_PROPERTIES);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            properties.putAll(System.getProperties());
            setFields(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setFields(Properties properties){
        browserType = BrowserType.valueOf(properties.getProperty("browser.type"));
        browserProfile = BrowserProfile.valueOf(properties.getProperty("browser.profile"));

    }

}
