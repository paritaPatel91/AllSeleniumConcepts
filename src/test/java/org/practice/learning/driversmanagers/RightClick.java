package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Parita Patel\\Desktop\\updatedchromeversion\\chromedriver.exe");
        driver=new ChromeDriver();

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

    WebElement rightClickButton = driver.findElement(By.xpath("//span[text()='right click me']"));

    actions.contextClick(rightClickButton).build().perform();

        WebElement copy = driver.findElement(By.cssSelector(".context-menu-icon-copy"));

        String copyText =copy.getText();

        System.out.println(copyText);

        copy.click();


      /*
        for the copy element
        here i have use cssselector, look at very carefully thre are so many with the same name class over in the
        html dom,so in cssselectors we can use half name of the class which is not common from the others,which
         is i have used over here.
       */
    }






}
