package pages;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Nick_Nie on 3/2/2016.
 */
public class CommonPage {

    public static final String WISH_LIST_NAV = "//ul[@class='nav clearfix']/li[6]/a";
    public static final String NAVIGATION_BAR = "//div[@class='navigationbarcollectioncomponent']/ul/li";
    public static final String SIGN_OUT = "//a[.='Sign Out']";
    public static final String SHOPPING_CART = "//div[@id='header']/div/ul/li[7]/a";
    public static final String SIGN_IN = "Sign in";
    public static final String WELCOME = "//li[@class='logged_in']";

    @FindBy (xpath = CommonPage.WISH_LIST_NAV)
    private WebElement wishListNav;

    @FindBy (xpath = CommonPage.NAVIGATION_BAR)
    private List<WebElement> navigationBar;

    @FindBy (partialLinkText = CommonPage.SIGN_IN)
    private WebElement signIn;

    @FindBy (xpath = CommonPage.SIGN_OUT)
    private WebElement signOut;

    @FindBy (xpath = CommonPage.SHOPPING_CART)
    private WebElement shoppingCart;

    @FindBy (xpath = CommonPage.WELCOME)
    private WebElement welcome;

    public void clickOnWishListNav(){
        wishListNav.click();
    }

    public void clickOnFirstNavBar(int count) {
        navigationBar.get(count).click();
    }

    public void clickOnSignIn(){signIn.click();}

    public void clickOnSignOut(){
        signOut.click();
    }

    public void clickOnShoppingCart(){
        shoppingCart.click();
    }

    public boolean isDisplayedWelcome() {return welcome.isDisplayed();}
}
