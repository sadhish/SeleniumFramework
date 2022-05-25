package TestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Learning {
static RemoteWebDriver driver;

    @BeforeTest
    void Openbrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\selenium\\Setup\\driver\\chromedriver.exe");
         driver=new ChromeDriver();
    }
    @Test
    public void test(){
        driver.get("https://www.google.com");
        System.out.println("hi");
    }
    @Test(dependsOnMethods = "test")
    public void test2(){
        System.out.println("hello");
    }
    @AfterTest
    void teardown(){
        if(driver!=null){

            driver.quit();

        }

    }
}
