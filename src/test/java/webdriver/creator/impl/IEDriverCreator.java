package webdriver.creator.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import webdriver.creator.WebDriverCreator;

/**
 * Created by Nick_Nie on 3/7/2016.
 */
public class IEDriverCreator implements WebDriverCreator{

    public WebDriver createWebDriver(){
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }
}
