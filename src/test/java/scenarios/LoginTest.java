package scenarios;

import models.BaseTest;
import org.testng.annotations.*;
import pages.LoginPage;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Nick_Nie on 3/2/2016.
 */
public class LoginTest extends BaseTest{

    public static final String EMAIL = "gi.sun@rustic-hw.com";
    public static final String PASSWORD = "12341234";
    private LoginPage loginPage;


    @Test
    public void testScenario(){
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginProcess(EMAIL, PASSWORD);
    }
}
