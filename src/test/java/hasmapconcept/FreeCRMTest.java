package hasmapconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.practice.learning.driversmanagers.WebdriverMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FreeCRMTest {

    WebDriver driver;
    public String credentials;
  public String split[];


    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://freecrm.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();//maximize window(2)
        driver.manage().deleteAllCookies();//delete all cookies(3)


    }

    @Test(priority = 1)
    public void loginWithAdminUserTest() throws InterruptedException {


       // driver.findElement(By.xpath("//button[text()='Got It']")).click();

        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(By.xpath("//div[@class='intercom-lr0ri6 es6hgh14']//span"))).build().perform();

        driver.findElement(By.xpath("//div[@class='intercom-lr0ri6 es6hgh14']//span")).click();

        driver.switchTo().frame("iframe");

        credentials = HasMapConceptInSelenium.getUserLoginInfo().get("admin");
         split = credentials.split("_");

        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();

        driver.findElement(By.name("email")).sendKeys(split[0]);

        driver.findElement(By.name("password")).sendKeys(split[1]);

        driver.findElement(By.xpath("//div[text()='Login']")).click();

        Thread.sleep(2000);

    }

    @Test(priority = 2)
    public void loginWithCustomerUserTest() throws InterruptedException {

        credentials = HasMapConceptInSelenium.getUserLoginInfo().get("customer");
        split = credentials.split("_");


        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();

        driver.findElement(By.name("email")).sendKeys(split[0]);

        driver.findElement(By.name("password")).sendKeys(split[1]);

        WebElement loginbtn =  driver.findElement(By.xpath("//div[text()='Login']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",loginbtn);
    }

    @AfterMethod
    public void tearDown() {

        //driver.quit();

    }

}
