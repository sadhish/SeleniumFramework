package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SauceTestInventory extends BaseClass{

    @BeforeTest
    void openBrowser(){
        BrowserFactory.launchBrowser("chrome");

    }
    @Test
    void launchPage() throws IOException, InterruptedException {
        driver.get(Excelutils.fetchData("Sauce","URL"));
        SauceLabsPOM.loginClick();
        WebElement element=driver.findElement(By.className("product_sort_container"));
        Select select=new Select(element);
        select.selectByVisibleText("Name (A to Z)");
        Thread.sleep(5000);
        List<WebElement> pricelist=driver.findElements(By.className("inventory_item_price"));
        double maxprice=pricelist.stream().
               mapToDouble(e->Double.parseDouble(e.getText().trim().replace("$",""))).max().getAsDouble();
       String Xpath="//div[normalize-space()='$"+maxprice+"']/following-sibling::button[text()='Add to cart']";
       driver.findElement(By.xpath(Xpath)).click();
      /* driver.findElement(By.id("react-burger-menu-btn")).click();
       Thread.sleep(5000);
       driver.findElement(By.id("logout_sidebar_link")).click();
       Assert.assertEquals("Swag Labs",driver.getTitle().toString());*/
    }
    @AfterTest
    public void tearDown() {

        driver.quit();
    }
}
