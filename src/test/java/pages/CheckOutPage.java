package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Nick_Nie on 3/3/2016.
 */
public class CheckOutPage {

    public static final String CHECK_OUT_PHASE = "//div[@id='breadcrumb']/ul/li[last()]/a";
    public static final String PAYMENT_TYPE = "//select[@id='paymentTypeSelect']";
    public static final String COST_CENTER = "//select[@id='costCenterSelect']";
    public static final String PO_NO = "//input[@id='PurchaseOrderNumber']";
    public static final String NEXT_BTN_ON_PAYMENT_TYPE = "//button[@id='choosePaymentType_continue_button']";
    public static final String CANCEL_BTN = "Cancel";

    public static final String HEAD_LINE = "//div[@id='checkoutContentPanel']/div[1]";
    public static final String ADDR_BOOK_BTN = "//button[@id='viewAddressBook']";
    public static final String SAVED_ADDR_LIST = "//div[@id='cboxLoadedContent']/div[@id='savedAddressList']/div[1]";
    public static final String USE_THIS_ADDR_BTN = "//div[@id='cboxLoadedContent']/div/div/div/form/button[@class='positive left']";
    public static final String CBOX_CLOSE = "//a[@id='cboxClose']";
    public static final String STANDART_DELIVERY = "//form[@id='selectDeliveryMethodForm']/ul/li[1]/input";
    public static final String PREMIUM_DELIVERY = "//form[@id='selectDeliveryMethodForm']/ul/li[2]/input";
    public static final String NEXT_BTN_ON_DELIVERY = "//button[@id='chooseDeliveryMethod_continue_button']";
    public static final String TERM_CHECKBOX = "//input[@name='termsCheck']";
    public static final String PLACE_ORDER = "//button[@class='positive right place-order']";

    @FindBy (xpath = CheckOutPage.CHECK_OUT_PHASE)
    private WebElement checkOutPhase;

    @FindBy (xpath = CheckOutPage.HEAD_LINE)
    private WebElement headLine;

    @FindBy (xpath = CheckOutPage.PAYMENT_TYPE)
    private WebElement paymentType;

    @FindBy (xpath = CheckOutPage.COST_CENTER)
    private WebElement costCenter;

    @FindBy (xpath = CheckOutPage.PO_NO)
    private WebElement poNo;

    @FindBy (xpath = CheckOutPage.NEXT_BTN_ON_PAYMENT_TYPE)
    private WebElement nextButtonOnPaymentType;

    @FindBy (partialLinkText = CheckOutPage.CANCEL_BTN)
    private WebElement cancelButtonOnPaymentType;

    @FindBy (xpath = CheckOutPage.ADDR_BOOK_BTN)
    private WebElement addrBookButton;

    @FindBy (xpath = CheckOutPage.SAVED_ADDR_LIST)
    private WebElement savedAddrList;

    @FindBy (xpath = CheckOutPage.USE_THIS_ADDR_BTN)
    private WebElement userThisAddrButton;

    @FindBy (xpath = CheckOutPage.CBOX_CLOSE)
    private WebElement cboxClose;

    @FindBy (xpath = CheckOutPage.STANDART_DELIVERY)
    private WebElement standardDeliveryRadio;

    @FindBy (xpath = CheckOutPage.PREMIUM_DELIVERY)
    private WebElement premiumDelivery;

    @FindBy (xpath = CheckOutPage.NEXT_BTN_ON_DELIVERY)
    private WebElement nextButtonOnDelivery;

    @FindBy (xpath = CheckOutPage.TERM_CHECKBOX)
    private WebElement termCheckbox;

    @FindBy (xpath = CheckOutPage.PLACE_ORDER)
    private WebElement placeOrder;

    public boolean isPaymentTypeDisplayed(){
        return checkOutPhase.getText().equals("PAYMENT TYPE");
    }

    public boolean isShippingAddrDisplayed(){
        return checkOutPhase.getText().equals("SHIPPING ADDRESS");
    }
    public boolean isShippingMethodDisplayed(){
        return checkOutPhase.getText().equals("SHIPPING METHOD");
    }
    public boolean isFinalReviewDisplayed(){
        return checkOutPhase.getText().equals("FINAL REVIEW");
    }

    public String extractHeadLine(){
        return headLine.getText();
    }

    public void selectPaymentType(String type){
        Select paymentSelect = new Select(paymentType);
        paymentSelect.selectByVisibleText(type);
    }

    public void selectCostCenter(String center){
        Select centerSelect = new Select(costCenter);
        centerSelect.selectByVisibleText(center);
    }

    public void sendKeyToPoNO(String po_no){
        poNo.clear();
        poNo.sendKeys(po_no);
    }

    public void clickOnNextButtonOnPaymentType(){
        nextButtonOnPaymentType.click();
    }

    public void clickOnAddrBook(){
        addrBookButton.click();
    }

    public void clickOnUseThisAddr(){
        userThisAddrButton.click();
    }

    public void clickOnStandardDelivery(){
        if(!standardDeliveryRadio.isSelected()){
            standardDeliveryRadio.click();
        }
    }

    public void clickOnNextButtonOnDelivery(){
        nextButtonOnDelivery.click();
    }

    public void checkTermCheckbox(){
        termCheckbox.click();
    }

    public void clickOnPlaceOrder(){
        placeOrder.click();
    }
}
