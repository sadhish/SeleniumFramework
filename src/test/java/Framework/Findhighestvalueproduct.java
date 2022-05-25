package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Findhighestvalueproduct extends BrowserFactory {
    @BeforeTest
    void openBrowser(){
        BrowserFactory.launchBrowser("chrome");

    }

    @Test
    void highestValue() throws InterruptedException {
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sadhishthiagu@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("Winter@19");
        driver.findElement(By.id("auth-signin-button")).click();
        String Username=driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']")).getText();
        String expectedUserName= Username.substring(Username.lastIndexOf(",")+1).trim();
        Assert.assertEquals("sadhishjay",expectedUserName);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone13");
        driver.findElement(By.xpath("//*[@id='nav-search-bar-form']/div[3]/div")).click();
        List<WebElement> list= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        //list.stream().forEach(e->System.out.println(e.getText()));

        Integer value=list.stream().mapToInt(e->Integer.parseInt(e.getText().replaceAll(",",""))).max().getAsInt();
        driver.findElement(By.xpath("//span[normalize-space()='"+value+"']")).click();

}
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
