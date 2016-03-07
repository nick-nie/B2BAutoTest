package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import util.TestContext;
import webdriver.creator.WebDriverCreator;
import webdriver.creator.impl.ChromeDriverCreator;
import webdriver.creator.impl.FirefoxDriverCreator;
import webdriver.creator.impl.IEDriverCreator;

/**
 * Created by Nick_Nie on 3/7/2016.
 */
public class WebDriverFactory {

    public static WebDriverCreator creator;

    public static WebDriver creator(TestContext context){

        switch (context.getBrowserType()){
            case firefox:
                creator = new FirefoxDriverCreator();
                break;
            case chrome:
                creator = new ChromeDriverCreator();
                break;
            case ie:
                creator = new IEDriverCreator();
                break;
            default:
                break;
        }
        return creator.createWebDriver();
    }
}
