package Framework;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;


public class BaseClass implements ITestListener {

    public static WebDriver driver;



    public static void takeScreenshot(String methodName) throws IOException {
       String path=System.getProperty("user.dir");
       TakesScreenshot ts= (TakesScreenshot)driver;
       File SrcFile=ts.getScreenshotAs(OutputType.FILE);
       File DestFile=new File("F:\\Selenium\\Screenshot\\"+methodName+"-"+"homePageScreenshot.png");
       FileHandler.copy(SrcFile, DestFile);
   }


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            takeScreenshot(result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
