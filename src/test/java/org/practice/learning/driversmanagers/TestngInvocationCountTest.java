package org.practice.learning.driversmanagers;


import org.testng.annotations.Test;

public class TestngInvocationCountTest {

    /*
    when we like to run same test cases again and again we dont need to write test cases again ,
    we can use this invocationcount method and we can run testcases multiple times in the project.
     */

    @Test(invocationCount = 5)
    public void sum(){
        int a = 10;
        int b = 20;
        int c =a+b;
        System.out.println("sum is " + c);

    }

}
