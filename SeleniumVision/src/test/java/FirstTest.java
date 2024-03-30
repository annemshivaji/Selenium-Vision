import org.example.ScreenCaptureUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {

    WebDriver driver;

    @Test
        public void test(){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.get("https://demo.guru99.com/test/newtours/");

            new ScreenCaptureUtility().takePageScreenshot(driver,"myImage1");
        }

    @Test
    public void test2(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/");

        WebElement logo=driver.findElement(By.xpath("//img[@alt='Mercury Tours']"));
        new ScreenCaptureUtility().takeElementScreenshot(driver,"logoImage",logo);
    }


}
