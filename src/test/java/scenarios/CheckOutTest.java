package scenarios;

import models.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Nick_Nie on 3/3/2016.
 */
public class CheckOutTest extends BaseTest{

    private LoginPage loginPage;
    private CommonPage commonPage;
    private ProductListPage productListPage;
    private ShoppingCartPage shoppingCartPage;
    private CheckOutPage checkOutPage;

    @Test
    public void testScenario() throws InterruptedException {

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        commonPage = PageFactory.initElements(driver, CommonPage.class);
        productListPage = PageFactory.initElements(driver, ProductListPage.class);
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        checkOutPage = PageFactory.initElements(driver, CheckOutPage.class);

        loginPage.loginProcess("gi.sun@rustic-hw.com", "12341234");
        commonPage.clickOnFirstNavBar(0);
        productListPage.clickOnAddToCart(0);
        productListPage.clickOnAddToCart(1);
        productListPage.clickOnAddToCart(2);
        productListPage.clickOnAddToCart(3);
        commonPage.clickOnShoppingCart();
        shoppingCartPage.sendKeyToQuantity("2", 0);
        shoppingCartPage.clickOnUpdateItems(0);
        Thread.sleep(2000);
        shoppingCartPage.clickOnCheckOutBottom();
        Thread.sleep(2000);

        if(checkOutPage.isPaymentTypeDisplayed()){
            Assert.assertTrue(checkOutPage.extractHeadLine().equals("PAYMENT TYPE"));
            checkOutPage.selectPaymentType("Account Payment");
            checkOutPage.selectCostCenter("Services West");
            checkOutPage.clickOnNextButtonOnPaymentType();
        }
        Thread.sleep(2000);

        if(checkOutPage.isShippingAddrDisplayed()){
            Assert.assertTrue(checkOutPage.extractHeadLine().equals("ADDRESS DETAILS"));
            checkOutPage.clickOnAddrBook();
            Thread.sleep(2000);
            checkOutPage.clickOnUseThisAddr();
        }
        Thread.sleep(2000);
        if(checkOutPage.isShippingMethodDisplayed()){
            Assert.assertTrue(checkOutPage.extractHeadLine().equals("2 - SELECT DELIVERY METHOD"));
            checkOutPage.clickOnStandardDelivery();
            checkOutPage.clickOnNextButtonOnDelivery();
        }
        Thread.sleep(2000);
        if(checkOutPage.isFinalReviewDisplayed()){
            Assert.assertTrue(checkOutPage.extractHeadLine().equals("FINAL REVIEW"));
            checkOutPage.checkTermCheckbox();
            checkOutPage.clickOnPlaceOrder();
        }
        Thread.sleep(2000);

        //commonPage.clickOnFirstNavBar(0);
        commonPage.clickOnSignOut();

    }

}
