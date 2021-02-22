package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DowloadFileConcept {

    WebDriver driver;

    File folder;

    @BeforeMethod
    public void setUp(){
        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();

        //chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\updatedchromeversion\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        Map<String ,Object>prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_settings.popups",0);
        prefs.put("download.default_directory",folder.getAbsoluteFile());

        options.setExperimentalOption("prefs",prefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();

        cap.setCapability(ChromeOptions.CAPABILITY,options);

        driver = new ChromeDriver();
    }
    @Test
    public void dowloadFileTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();

        Thread.sleep(2000);
        File[] files = folder.listFiles();
        //make sure the directory is not empty
       // Assert.assertEquals(files.length,is(not(0)));
        Assert.assertFalse(files.length>0);

        for (File file :files){
            //make sure that dowload file is not empty
           //Assert.assertEquals(file.length().is(not((long)0)));
            Assert.assertTrue(file.length()>0);
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
        for (File file: folder.listFiles()) {
            file.delete();
        }
        folder.delete();
    }

}
