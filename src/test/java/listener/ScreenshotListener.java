package listener;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

//import com.epam.hybris.common.logger.TestLogger;

/**
 * Screenshot listener for taking screenshot on test failure.
 * @author Peter_Reperger
 */
public class ScreenshotListener extends TestListenerAdapter
{

    /**
     * Logger instance.
     */
    //private static final TestLogger logger = TestLogger.getLogger(ScreenshotListener.class);

    /**
     * WebDriver instance.
     */
    private WebDriver driver;

    /**
     * Take screenshot on configuration failure.
     */
    @Override
    public void onConfigurationFailure(ITestResult testResult)
    {
        super.onConfigurationFailure(testResult);

        try
        {
            // Obtain and set actual WebDriver instance
            setWebDriverInstance(testResult);
            // Take and log screenshot
            logErrorScreenshot(testResult);
        } catch (IllegalAccessException e)
        {
            //logWarning();
        }
    }

    /**
     * Take screenshot on test failure.
     */
    @Override
    public void onTestFailure(ITestResult testResult)
    {
        super.onTestFailure(testResult);

        try
        {
            // Obtain and set actual WebDriver instance
            setWebDriverInstance(testResult);
            // Take and log screenshot
            logErrorScreenshot(testResult);
        } catch (IllegalAccessException e)
        {
            //logWarning();
        }
    }

    private void logErrorScreenshot(ITestResult testResult)
    {
        try
        {
            final File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            final File screenshotFile = new File("target/surefire-reports/html/screenshots/" + testResult.getTestClass().getName()
                    + "_" + testResult.getName() + ".png");
            FileUtils.copyFile(screenshot, screenshotFile);

            // Log screenshot to Report Portal
//            LoggerFactory.getLogger(getClass()).error("RP_MESSAGE#FILE#{}#{}", screenshotFile,
//                    testResult.getThrowable().getMessage());
            // Log screenshot to ReportNG
            Reporter.log("<a href='screenshots/" + screenshotFile.getName() + "' target='_blank'><img src='screenshots/"
                    + screenshotFile.getName() + "' height='240'/></a>");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

//    private void logWarning()
//    {
//        if (logger.isWarnEnabled())
//        {
//            logger.warn("Test class does not have any field of type 'org.openqa.selenium.WebDriver'. "
//                    + "ScreenshotListener can not continue.");
//        }
//    }

    private void setWebDriverInstance(ITestResult testResult) throws IllegalAccessException
    {
        Class<?> actual = testResult.getInstance().getClass();
        do
        {
            processFields(testResult, actual);
            actual = actual.getSuperclass();
        } while (!actual.equals(Object.class));
    }

    private void processFields(ITestResult testResult, Class<?> actual) throws IllegalAccessException
    {
        for (final Field field : actual.getDeclaredFields())
        {
            processField(testResult, field);
        }
    }

    private void processField(ITestResult testResult, Field field) throws IllegalAccessException
    {
        if (WebDriver.class == field.getType())
        {
            ReflectionUtils.makeAccessible(field);
            driver = (WebDriver) field.get(testResult.getInstance());
        }
    }

}
