package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Brokenlinks extends  BrowserFactory {
    @BeforeTest
    void openBrowser(){
        BrowserFactory.launchBrowser("chrome");

    }

    @Test
    void brokenLinks() throws MalformedURLException {
    driver.get("http://www.zlti.com");
    String homePage="http://www.zlti.com";
    String url="";
    HttpURLConnection httpURLConnection=null;
    List<WebElement> list=driver.findElements(By.tagName("a"));
    for(WebElement element:list){
        url=element.getAttribute("href");
        if(url == null || url.isEmpty()){
            System.out.println("URL is either not configured for anchor tag or it is empty");
            continue;
        }
        try {
            httpURLConnection= (HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.connect();
            int resCode=httpURLConnection.getResponseCode();
            if(resCode>=400){
                System.out.println(url+"brokenlink");
            }else{
                System.out.println(url+" is a valid link");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    @AfterTest
    void teardown(){
        if(driver!=null){

            driver.quit();

        }

    }
}
