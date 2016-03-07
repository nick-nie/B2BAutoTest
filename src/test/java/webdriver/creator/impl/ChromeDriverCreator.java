package webdriver.creator.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webdriver.creator.WebDriverCreator;

/**
 * Created by Nick_Nie on 3/7/2016.
 */
public class ChromeDriverCreator implements WebDriverCreator{

    public WebDriver createWebDriver() {
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
