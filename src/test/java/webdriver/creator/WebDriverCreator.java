package webdriver.creator;

import org.openqa.selenium.WebDriver;
import util.BrowserProfile;

/**
 * Created by Nick_Nie on 3/7/2016.
 */
public interface WebDriverCreator {

    WebDriver createWebDriver(BrowserProfile browserProfile);
}
