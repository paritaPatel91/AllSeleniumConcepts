package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BootStrapDropDown {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void testdata11() throws InterruptedException {
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
        Thread.sleep(2000);

        // to select only one value use this code to continue
        List<WebElement> elements = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
        System.out.println(elements.size());
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText());
            if (elements.get(i).getText().contains("Angular")) {
                elements.get(i).click();
                break;

              //  Thread.sleep(10000);

                //to select all value use this code
//                List<WebElement> elements = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
//                System.out.println(elements.size());
//                for (int i = 0; i < elements.size(); i++) {
//                    System.out.println(elements.get(i).getText());
//                    elements.get(i).click();

            }
        }
    }

    @AfterMethod
    public void tearDown() {
        //      driver.quit();
    }
}
