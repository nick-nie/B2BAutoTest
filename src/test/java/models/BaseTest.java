package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by Nick_Nie on 3/3/2016.
 */
public class BaseTest {

    protected WebDriver driver;
    public static final String BASE_URL = "https://electronics.epam.goanywhere.io:9102/storefront/powertools/en/USD/login/?site=powertools";

    @BeforeClass
    public WebDriver setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
        return driver;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
