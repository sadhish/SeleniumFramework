package TestNG;

import io.cucumber.java.ht.Le;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import java.util.function.Function;

public class Waits extends Learning {
    @BeforeTest
    void Openbrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\selenium\\Setup\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    void waits() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.alertIsPresent());

        Wait fwait = new FluentWait(driver)
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(Exception.class);
        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
              return driver.findElement(By.xpath(""));
            }

        });

    }
}