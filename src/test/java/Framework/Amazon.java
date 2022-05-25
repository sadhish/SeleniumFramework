package Framework;

import Framework.utilites.Reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Amazon extends BrowserFactory {
    ExtentReports extentReports;
    ExtentTest test;
    @BeforeTest
    void openBrowser(){
        BrowserFactory.launchBrowser("chrome");

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Amazon Check cart")
    void login() throws InterruptedException {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./TestReport.html");
        extentReports = new ExtentReports();// load reports on to it
        extentReports.attachReporter(extentSparkReporter);

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
        List<WebElement> list= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        list.stream().filter(e->e.getText().equalsIgnoreCase("Apple iPhone 13 (128GB) - Midnight")).findFirst().get().click();
        String pw= driver.getWindowHandle();
        Set<String> set=driver.getWindowHandles();
        Iterator<String> iterator= set.iterator();
        while(iterator.hasNext()){
            String cw=iterator.next();
            if(!pw.equals(cw)){
                driver.switchTo().window(cw);
                String expectedTitle=driver.findElement(By.id("productTitle")).getText().trim();
                Assert.assertEquals("Apple iPhone 13 (128GB) - Midnight",expectedTitle);
                driver.findElement(By.id("add-to-cart-button")).click();
                int cartCount=Integer.parseInt(driver.findElement(By.id("nav-cart-count")).getText());
                System.out.println(cartCount);
                driver.findElement(By.id("nav-cart")).click();
               String qtyCount= driver.findElement(By.id("a-autoid-0-announce")).getText();
             /*  int expectedQtyCount=Integer.parseInt(qtyCount.substring(qtyCount.lastIndexOf(":")+1).trim());
               Assert.assertEquals(cartCount,expectedQtyCount);*/
               driver.findElement(By.xpath("//input[@value='Delete' and @aria-label='Delete Apple iPhone 13 (128GB) - Midnight']")).click();
               Thread.sleep(5000);
               String expectedText=driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div[1]/div/h1")).getText().trim();
               Assert.assertEquals("Your Amazon Cart is empty.",expectedText);
                extentReports.createTest("MyFirstTest")
                        .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
                extentReports.flush();
            }
        }
    }



    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
