package util;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Dim;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by Nick_Nie on 3/7/2016.
 */
public enum BrowserProfile {

    XXS(new Dimension(320, 568)),
    XS(new Dimension(480, 800)),
    SM(new Dimension(640, 960)),
    MD(new Dimension(1024, 768)),
    LG;


    private Dimension dimension;

    BrowserProfile(){this(null);}

    BrowserProfile(Dimension dimension) {
        this.dimension = dimension;
    }


    public void setWindowSize(WebDriver driver)
    {
        if (dimension == null)
        {
            driver.manage().window().maximize();
        } else
        {
            int scrollBarWidth = getScrollBarWidth(driver);
            driver.manage().window().setSize(new Dimension(dimension.width + scrollBarWidth, dimension.height));
        }
    }

    public int getScrollBarWidth(WebDriver driver){

        Long value = (Long) ((JavascriptExecutor) driver).executeScript(JavaScriptConstants.JS_GET_SCROLLBAR_WIDTH);
        return Integer.parseInt(value.toString());
    }
}

