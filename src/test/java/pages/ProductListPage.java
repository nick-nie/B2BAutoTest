package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Nick_Nie on 3/2/2016.
 */
public class ProductListPage {
    public static final String ADD_TO_CART = "//button[@class='addToCartButton ']";
    public static final String WISH_LIST_ADD_REMOVE = "//div[@class='wishList-addRemoveWrapper']/a";

    @FindBy (xpath = ProductListPage.ADD_TO_CART)
    private List<WebElement> addToCart;

    @FindBy (xpath = ProductListPage.WISH_LIST_ADD_REMOVE)
    private List<WebElement> wishListAddOrRemove;

    public void clickOnAddToCart(int count){
        addToCart.get(count).click();
    }

    public void addOrRemoveWishList(int count, String action) throws InterruptedException {
        if(wishListAddOrRemove.get(count).getText().startsWith(action)){
            wishListAddOrRemove.get(count).click();
        }else {
            wishListAddOrRemove.get(count).click();
            Thread.sleep(2000);
            wishListAddOrRemove.get(count).click();
        }
    }

    public boolean isAddToWishListDisplayed(int count){
        return wishListAddOrRemove.get(count).getText().equals("Add to Wish List");
    }

    public boolean isRemoveFromWishListDisplayed(int count){
        return wishListAddOrRemove.get(count).getText().equals("Remove from Wish List");
    }
}
