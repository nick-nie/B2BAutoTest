package scenarios;

import models.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;

/**
 * Created by Nick_Nie on 3/2/2016.
 */
public class LoginFailedTest extends BaseTest{

    public static final String EMAIL = "gi.sun@rustic.com";
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
