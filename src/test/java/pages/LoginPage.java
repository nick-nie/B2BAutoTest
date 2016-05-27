package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Nick_Nie on 3/2/2016.
 */
public class LoginPage {

    public static final String EMAIL_ADDRESS = "j_username";
    public static final String PASSWORD = "j_password";
    public static final String LOGIN_BUTTON = "//button[.='Login']";

    @FindBy (id = LoginPage.EMAIL_ADDRESS)
    private WebElement loginEmail;

    @FindBy (id = LoginPage.PASSWORD)
    private WebElement loginPassword;

    @FindBy (xpath = LoginPage.LOGIN_BUTTON)
    private WebElement loginButton;

    public void loginProcess(String email, String password){
        loginEmail.clear();
        loginEmail.sendKeys(email);
        loginPassword.clear();
        loginPassword.sendKeys(password);
        loginButton.click();
    }

}
