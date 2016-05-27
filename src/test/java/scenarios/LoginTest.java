package scenarios;

import models.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.CommonPage;
import pages.LoginPage;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Nick_Nie on 3/2/2016.
 */
public class LoginTest extends BaseTest{

    public static final String EMAIL = "gi.sun@rustic-hw.com";
    public static final String PASSWORD = "12341234";
    private LoginPage loginPage;
    private CommonPage commonPage;

    @Test
    public void testScenario(){
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        commonPage = PageFactory.initElements(driver, CommonPage.class);
        commonPage.clickOnSignIn();
        loginPage.loginProcess(EMAIL, PASSWORD);
    }
}
