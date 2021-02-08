package org.practice.learning.driversmanagers;

import org.testng.annotations.*;

public class TestNgBasics {

/*
    Pre-conditions annotations --starting with @Before
    Three diff conditions in testng
    1) @Before 2) @After 3) @Test

    @BeforeMethod
    @Test-1
    @AfterMethod

    @BeforeMethod
    @Test-2
    @AfterMethod

    @BeforeMethod
    @Test-3
    @AfterMethod

    pair create at @method

   @suite , @class ,@Test execute only once

   sequesence will be STCM


 */


    @BeforeSuite
    public void setUp(){
        System.out.println("setup system property for chrome");

    }
    @BeforeTest
    public void launchBrowser(){
        System.out.println("launch chrome browser");

    }

    @BeforeClass
    public void enterUR(){
        System.out.println("Enter URL");

    }
    @BeforeMethod
    public void login(){
        System.out.println("Login Method");

    }

    //Test-cases--starting with @Test
    @Test
    public void googleTitleTest(){
        System.out.println("Title of the link");

    }
    @Test
    public void searchTitle() {
        System.out.println("Search Title");
    }
    @Test
    public void logoTest() {
        System.out.println("logo of the app");
    }

        //Post-conditions annotations --starting with @After

    @AfterMethod
    public void logOut(){
        System.out.println("logout Method");

    }
    @AfterClass
    public void deletAllCookies(){
        System.out.println("Delete all cookies");

    }
    @AfterTest
    public void closeBrowser(){
        System.out.println("Close Browser");

    }
    @AfterSuite
    public void generateReport(){
        System.out.println("Generate Report");

    }
}
