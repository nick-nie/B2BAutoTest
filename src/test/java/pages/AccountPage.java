package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Nick_Nie on 3/2/2016.
 */
public class AccountPage {

    public static final String MY_WISH_LIST = "//a[@title='My Wish List']";

    @FindBy (xpath = AccountPage.MY_WISH_LIST)
    private WebElement myWishList;

    public void clickOnMyWishList(){
        myWishList.click();
    }
}
