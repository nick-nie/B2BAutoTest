package webdriver.creator.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import util.BrowserProfile;
import webdriver.creator.WebDriverCreator;

/**
 * Created by Nick_Nie on 3/7/2016.
 */
public class IEDriverCreator implements WebDriverCreator{

    public WebDriver createWebDriver(BrowserProfile browserProfile){
        WebDriver driver = new InternetExplorerDriver();
        browserProfile.setWindowSize(driver);
        return driver;
    }
}
