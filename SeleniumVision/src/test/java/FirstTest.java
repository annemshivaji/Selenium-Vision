import org.example.ScreenCaptureUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstTest {

    WebDriver driver;

    @DataProvider(name="urls")
    public static Object[][] urls() {
        return new Object [][]{
                {"https://demo.guru99.com/test/newtours/","homePage"},
                {"https://demo.guru99.com/test/newtours/reservation.php","reservationPage"},
                {"https://demo.guru99.com/test/newtours/reservation2.php","reservationPage2"},
                {"https://demo.guru99.com/test/newtours/","BacktoHomePage"}
            };
    }

    @Test(dataProvider= "urls")
    public void prepareBaseline(String url,String name){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/");

        driver.findElement(By.name("userName")).sendKeys("tutorial");
        driver.findElement(By.name("password")).sendKeys("tutorial");
        driver.findElement(By.name("submit")).click();

        driver.get(url);

        new ScreenCaptureUtility().prepareBaseline(driver,name);
    }
    @Test
    public void compareImages(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/");

        new ScreenCaptureUtility().takePageScreenshot(driver,"scrHomePage");

        Assert.assertTrue(new ScreenCaptureUtility().areImagesEqual("homePage","scrHomePage"));
        driver.quit();
    }

    @Test
    public void compareImagesToFail(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/");

        driver.findElement(By.name("userName")).sendKeys("Shivaji Annem");

        new ScreenCaptureUtility().takePageScreenshot(driver,"scrHomePage");

        Assert.assertTrue(new ScreenCaptureUtility().areImagesEqual("homePage","scrHomePage"));
        driver.quit();
    }

    @Test
        public void test(){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.get("https://demo.guru99.com/test/newtours/");

            new ScreenCaptureUtility().takePageScreenshotImproved(driver,"myImage1");
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
