package TestNG;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DesiredCap  {

    static WebDriver driver;
    public static void main(String[] args) throws MalformedURLException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\selenium\\Setup\\driver\\chromedriver.exe");

        String URL="hub";
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setBrowserName("");
        desiredCapabilities.setPlatform(Platform.WINDOWS);

        driver=new RemoteWebDriver((new URL(URL)),desiredCapabilities);


    }


}
