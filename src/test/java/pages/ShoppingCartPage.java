package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import java.util.List;

/**
 * Created by Nick_Nie on 3/3/2016.
 */
public class ShoppingCartPage {
    private static final String CHECK_OUT_TOP = "//button[@id='checkoutButtonTop']";
    private static final String CHECK_OUT_BOTTOM = "//button[@id='checkoutButtonBottom']";
    private static final String CART_ITEMS = "//div[@id='cartItems']/table/tbody/tr";
    private static final String REMOVE = "//a[@class='submitRemoveProduct']";
    private static final String UPDATE = "//a[@class='updateQuantityProduct']";
    private static final String QUANTITY = "//input[@name='quantity']";

    @FindBy (xpath = ShoppingCartPage.CHECK_OUT_TOP)
    private WebElement checkOutTop;

    @FindBy (xpath = ShoppingCartPage.CHECK_OUT_BOTTOM)
    private WebElement checkOutBottom;

    @FindBy (xpath = ShoppingCartPage.CART_ITEMS)
    private List<WebElement> cartItems;

    @FindBy (xpath = ShoppingCartPage.REMOVE)
    private List<WebElement> removeItems;

    @FindBy (xpath = ShoppingCartPage.UPDATE)
    private List<WebElement> updateItems;

    @FindBy (xpath = ShoppingCartPage.QUANTITY)
    private List<WebElement> quantityOfItems;

    public void clickOnCheckOutTop(){
        if (checkOutTop.isDisplayed()){
            checkOutTop.click();
        }
    }

    public void clickOnCheckOutBottom(){
        if (checkOutBottom.isDisplayed()){
            checkOutBottom.click();
        }
    }

    public void clickOnRemoveItems(int count){
        if (removeItems.size() >= count){
            removeItems.get(count).click();
        }
    }

    public void clickOnUpdateItems(int count){
        if (updateItems.size() >= count){
            updateItems.get(count).click();
        }
    }

    public void sendKeyToQuantity(String quantity, int count){
        if (quantityOfItems.size() >= count){
            quantityOfItems.get(count).clear();
            quantityOfItems.get(count).sendKeys(quantity);
        }
    }
}
