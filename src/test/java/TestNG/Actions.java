package TestNG;

import Framework.Excelutils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Actions {
    static RemoteWebDriver driver;
    @BeforeTest
    void Openbrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\selenium\\Setup\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
     void actions() throws IOException, InterruptedException {
        driver.get(Excelutils.fetchData("Sauce","URL"));
        org.openqa.selenium.interactions.Actions actions=new org.openqa.selenium.interactions.Actions(driver);
        //driver.findElement(By.id("user-name")).sendKeys("jay");
        WebElement ele=driver.findElement(By.id("user-name"));
        Thread.sleep(5000);
        //actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
        actions.moveToElement(ele).click().sendKeys("jay");
    }
}
