package com.letskodeit.teachable.ch25.testngannoasserts.base;

import org.testng.annotations.*;

public class BaseTestSuite {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(">>>TEST SUITE --- Before.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(">>>TEST SUITE --- After.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("**********Before test.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("**********After test.");
    }


}
