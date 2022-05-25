package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory extends BaseClass{

    public static WebDriver launchBrowser(String browser) {

        if(browser.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\selenium\\Setup\\driver\\chromedriver.exe");
            driver=new ChromeDriver();


        }

        return driver;
    }
}
