package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragAndDropMethod {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
       System.setProperty("webdriver.ie.driver", "C:\\Users\\Parita Patel\\Desktop\\IEDriver\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
    }

    @Test
    public void testdata11() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.switchTo().frame(0);//switch to frame if present(check notes how to check frame is present)


        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.id("draggable")))
                .moveToElement(driver.findElement(By.id("droppable")))
                .release()
                .build()
                .perform();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        driver.quit();
    }
}


