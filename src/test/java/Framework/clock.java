package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class clock {


     static boolean matchXpath(WebDriver driver, String Xpath){

         List<WebElement> list=driver.findElements(By.xpath(Xpath));
         if(list.size()>0){
             WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(500L));
             wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Xpath)));
             return true;
         }
        return false;



    }


    public static void main(String[] args) {

         WebDriver driver =new ChromeDriver();
        //matchXpath("//df");


    }
}
