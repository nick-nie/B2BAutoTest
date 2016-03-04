package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Nick_Nie on 3/2/2016.
 */
public class CommonPage {

    public static final String WISH_LIST_NAV = "//ul[@class='nav clearfix']/li[6]/a";
    public static final String NAVIGATION_BAR = "//div[@class='navigationbarcollectioncomponent']/ul/li";
    public static final String SIGN_OUT = "//div[@class='headerContent ']/ul/li[5]/a";
    public static final String SHOPPING_CART = "//div[@class='headerContent ']/ul/li[7]/a";

    @FindBy (xpath = CommonPage.WISH_LIST_NAV)
    private WebElement wishListNav;

    @FindBy (xpath = CommonPage.NAVIGATION_BAR)
    private List<WebElement> navigationBar;

    @FindBy (xpath = CommonPage.SIGN_OUT)
    private WebElement signOut;

    @FindBy (xpath = CommonPage.SHOPPING_CART)
    private WebElement shoppingCart;

    public void clickOnWishListNav(){
        wishListNav.click();
    }

    public void clickOnFirstNavBar(int count) {
        navigationBar.get(count).click();
    }

    public void clickOnSignOut(){
        signOut.click();
    }

    public void clickOnShoppingCart(){
        shoppingCart.click();
    }
}
