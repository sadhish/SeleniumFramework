package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Iframes extends  Learning {

    @BeforeTest
    void Openbrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\selenium\\Setup\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    void frames(){

        List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
        iframes.size();
        driver.switchTo().frame(iframes.get(0));
        //to come back to parent
        driver.switchTo().defaultContent();

    }
}
