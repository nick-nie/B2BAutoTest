package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Nick_Nie on 3/2/2016.
 */
public class WishListPage {
    public static final String WISHLIST_HEADLINE = "//div[@class='yCmsContentSlot accountBodyContentSlot']/div/div[@class='headline']";
    public static final String SELECT_ALL_CHECKBOX = "//div[@id='wishlist']/table/thead/tr/th/input";
    public static final String ADD_TO_CART_BOTTOM = "//div[@id='wishlist']/table/tbody/tr[last()]/td[2]/button";
    public static final String REMOVE_SELECTED = "//div[@id='wishlist']/table/tbody/tr[last()]/td[3]/button";
    public static final String CHECKBOX_ITEMS = "//td[@class='selection']/input";
    public static final String ADD_TO_CART_ITEMS = "//td/div[@class='wishlist-addToCartWrapper']/button";
    public static final String REMOVE_ITEMS = "//td/div[@class='wishlist-removeWrapper']/a";

    @FindBy (xpath = WishListPage.WISHLIST_HEADLINE)
    private WebElement wishListHeadline;

    @FindBy (xpath = WishListPage.SELECT_ALL_CHECKBOX)
    private WebElement selectAllCheckbox;

    @FindBy (xpath = WishListPage.ADD_TO_CART_BOTTOM)
    private WebElement addToCartBottom;

    @FindBy (xpath = WishListPage.REMOVE_SELECTED)
    private WebElement removeSelected;

    @FindBy (xpath = WishListPage.CHECKBOX_ITEMS)
    private List<WebElement> checkboxItems;

    @FindBy (xpath = WishListPage.ADD_TO_CART_ITEMS)
    private List<WebElement> addToCartItems;

    @FindBy (xpath = WishListPage.REMOVE_ITEMS)
    private List<WebElement> removeItems;

    public boolean isValidWishListHeadline(){
        return wishListHeadline.getText().equals("MY WISH LIST");
    }

    public boolean isEmptyWishList(){
        return checkboxItems.isEmpty();
    }

    public void clickOnCheckBoxItems(int count){
        checkboxItems.get(count).click();
    }

    public void clickOnAddToCartItems(int count){
        if (addToCartItems.size() >= count){
            addToCartItems.get(count).click();
        }
    }

    public void clickOnRemoveItems(int count){
        if (removeItems.size() >= count){
            removeItems.get(count).click();
        }
    }

    public void clickOnSelectAll(){
        selectAllCheckbox.click();
    }

    public void clickOnAddToCartBottom(){
        if (addToCartBottom.isEnabled()){
            addToCartBottom.click();
        }
    }

    public void clickOnRemoveSelected(){
        if (removeSelected.isEnabled()){
            removeSelected.click();
        }
    }
}
