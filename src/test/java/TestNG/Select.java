package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Select {
    static RemoteWebDriver driver;



    @BeforeTest
    void Openbrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\selenium\\Setup\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    void select() throws InterruptedException {

        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

        WebElement ele= driver.findElement(By.xpath("//select[@name='continents']"));
        org.openqa.selenium.support.ui.Select select;
        select = new org.openqa.selenium.support.ui.Select(ele);
        List<WebElement> list= select.getOptions();
        list.stream().filter(e->e.getText().equalsIgnoreCase("Europe")).findAny().get().click();

        WebElement ele2= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[4]/div/form/table/tbody/tr[10]/td[2]/select"));
        org.openqa.selenium.support.ui.Select mSelect;
        mSelect = new org.openqa.selenium.support.ui.Select(ele2);
        List<WebElement> li = mSelect.getOptions();
        if(mSelect.isMultiple()){
            Thread.sleep(5000);
            mSelect.selectByVisibleText("Browser Commands");
            Thread.sleep(5000);
            mSelect.selectByVisibleText("Wait Commands");
        }
        driver.findElement(By.name("submit")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();


        boolean isSelected=driver.findElement(By.xpath("//*[contains(text(),'Manual Tester')]")).isSelected();
       if( isSelected==false){

           driver.findElement(By.xpath("//*[contains(text(),'Manual Tester')]")).click();

       }
        Thread.sleep(5000);
        //  li.stream().forEach(e->System.out.println());

/*for(WebElement element:list){
    System.out.println(element.getText());

}*/
    }
   /* @AfterTest
    public void tearDown() {

        driver.quit();
    }*/
}
