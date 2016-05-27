package webdriver.creator.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.BrowserProfile;
import webdriver.creator.WebDriverCreator;

/**
 * Created by Nick_Nie on 3/7/2016.
 */
public class FirefoxDriverCreator implements WebDriverCreator{

    public WebDriver createWebDriver(BrowserProfile browserProfile){
        WebDriver driver = new FirefoxDriver();
        browserProfile.setWindowSize(driver);
        return driver;
    }
}
