package scenarios;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import models.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;
import pages.ProductListPage;
import pages.WishListPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Nick_Nie on 3/2/2016.
 */
public class PLPWishListTest extends BaseTest{

    private LoginPage loginPage;
    private CommonPage commonPage;
    private ProductListPage productListPage;
    private WishListPage wishListPage;
    public static final String EMAIL = "gi.sun@rustic-hw.com";
    public static final String PASSWORD = "12341234";

    @Test
    public void testScenario() throws InterruptedException {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        commonPage = PageFactory.initElements(driver, CommonPage.class);
        productListPage = PageFactory.initElements(driver, ProductListPage.class);
        wishListPage = PageFactory.initElements(driver, WishListPage.class);
        commonPage.clickOnSignIn();
        loginPage.loginProcess(EMAIL, PASSWORD);
        commonPage.clickOnFirstNavBar(0);
        productListPage.addOrRemoveWishList(0, "Add");
        productListPage.addOrRemoveWishList(1, "Add");
        productListPage.addOrRemoveWishList(2, "Add");
        productListPage.addOrRemoveWishList(3, "Add");
        productListPage.addOrRemoveWishList(4, "Add");
        Thread.sleep(2000);
        commonPage.clickOnWishListNav();
        Assert.assertTrue(wishListPage.isValidWishListHeadline());
        wishListPage.clickOnRemoveItems(2);
        Thread.sleep(2000);
        wishListPage.clickOnCheckBoxItems(0);
        wishListPage.clickOnCheckBoxItems(2);
        wishListPage.clickOnRemoveSelected();
        Thread.sleep(2000);
        wishListPage.clickOnSelectAll();
        wishListPage.clickOnAddToCartBottom();
        (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Sign Out']")));
        commonPage.clickOnSignOut();
    }
}
