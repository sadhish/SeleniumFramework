package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

import java.io.IOException;

public class SauceLabsPOM extends BrowserFactory {
   // @FindBy(id="username")
    private static WebElement username;
   // @FindBy(id="password")
    private static WebElement password;

    public SauceLabsPOM(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    static  void enterUserName() throws IOException {

        //username.sendKeys(Excelutils.fetchData("Sauce","username"));
        username= driver.findElement(By.id("user-name"));
        username.sendKeys(Excelutils.fetchData("Sauce","username"));

    }
   static void enterPassword() throws IOException {
       //password.sendKeys(Excelutils.fetchData("Sauce","password"));
       driver.findElement(By.id("password")).sendKeys(Excelutils.fetchData("Sauce","password"));

    }
   static void loginClick() throws IOException {
       enterUserName();
       enterPassword();
       driver.findElement(By.id("login-button")).click();

    }
    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
