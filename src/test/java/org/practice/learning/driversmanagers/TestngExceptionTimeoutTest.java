package org.practice.learning.driversmanagers;

import org.testng.annotations.Test;

public class TestngExceptionTimeoutTest {

    /*
    do not use this in project ,this is just for understanding.
    if we expected any exception we can declared here.
    it will passed the testcase cz we already give exeption here
    just for understanding and IQ not using in the project
    we can mark as failure test case.
     */


    @Test(timeOut =2,expectedExceptions =NumberFormatException.class)
    public void infiniteLoopTest(){
        int i =1;
        while (i ==1 ){
            System.out.println(i);

        }
    }


}
