package Framework;

import com.sun.javafx.scene.KeyboardShortcutsHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

@Listeners(Framework.BaseClass.class)
public class Loginpage extends BrowserFactory {
    @BeforeTest

    public void launchBrowser() {
        launchBrowser("chrome");
    }
    @Test
    public void loginIntoPage() throws IOException, InterruptedException {
        driver.get(Excelutils.fetchData("ST2","URL"));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Excelutils.fetchData("ST2","username"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Excelutils.fetchData("ST2","password"));
        driver.findElement(By.xpath("//input[@type='submit']")).submit();
        String res=driver.findElement(By.xpath("//p[@class='caption']")).getText();
        Assert.assertEquals(res, "Experience  difference");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000L));
        driver.navigate().forward();
        driver.switchTo().frame("iframe");
        driver.switchTo().defaultContent();
        driver.switchTo().alert().sendKeys("");
        driver.findElement(By.xpath("//input[@type='submit']")).isEnabled();
    }
    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
