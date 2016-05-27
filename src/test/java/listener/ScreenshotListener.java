//package listener;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;
//import org.testng.Reporter;
//import org.testng.TestListenerAdapter;
//
//import java.io.File;
//import java.io.IOException;
//
///**
// * Created by Nick_Nie on 3/8/2016.
// */
//public class ScreenshotListener extends TestListenerAdapter{
//
//    private WebDriver driver;
//
//    @Override
//    public void onConfigurationFailure(ITestResult result){
//        super.onConfigurationFailure(result);
//        captureScreen(result);
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result){
//        super.onTestFailure(result);
//        captureScreen(result);
//    }
//
//    public void captureScreen(ITestResult result){
//        File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        File screenshotFile = new File("target/surefire-reports/html/screenshots/" + result.getClass().getName() + "_" + result.getName() + ".png"));
//        try {
//            FileUtils.copyFile(source_file, screenshotFile);
//            Reporter.log("<a href='screenshots/" + screenshotFile.getName() + "' target='_blank'><img src='screenshots/"
//                    + screenshotFile.getName() + "' height='240'/></a>");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
