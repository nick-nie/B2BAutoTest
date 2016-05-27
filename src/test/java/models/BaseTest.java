package models;

import listener.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.uncommons.reportng.HTMLReporter;
import util.TestContext;
import webdriver.WebDriverFactory;

/**
 * Created by Nick_Nie on 3/3/2016.
 */
@Listeners({ ScreenshotListener.class })
public class BaseTest {

    protected WebDriver driver;
    //public static final String BASE_URL = "https://electronics.epam.goanywhere.io:9102/storefront/powertools/en/USD/login/?site=powertools";
    //public static final String BASE_URL = "https://localhost:9002/store/?site=powertools";
    //public static final String BASE_URL = "https://localhost:9002/yacceleratorstorefront/?site=powertools";
    public static final String BASE_URL = "https://powertools.epam.goanywhere.io:9102/store";

    @BeforeClass
    public WebDriver setup(){
//        driver = new FirefoxDriver();
        driver = WebDriverFactory.creator(new TestContext());
        //driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
        return driver;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
