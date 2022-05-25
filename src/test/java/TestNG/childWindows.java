package TestNG;

import io.cucumber.java.ht.Le;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class childWindows extends Learning {
    @BeforeTest
    void Openbrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\selenium\\Setup\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    void windows(){
        String pw=driver.getWindowHandle();
        Set<String> set=driver.getWindowHandles();
        Iterator<String> iterator=set.iterator();
        while(iterator.hasNext()){
            String cw=iterator.next();
            if(!pw.equalsIgnoreCase(cw)){

                driver.switchTo().window(cw);
                driver.getTitle().toString();
                driver.close();

            }

        }

    }


}
