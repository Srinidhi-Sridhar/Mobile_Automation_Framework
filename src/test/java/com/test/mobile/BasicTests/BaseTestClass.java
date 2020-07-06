package com.test.mobile.BasicTests;

import common.AppiumManager;
import common.reporting.ExtentReporting;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {

    public AppiumManager appiumManager;

    @BeforeSuite(alwaysRun = true)
    public void startTest() {
        ExtentReporting.startReporting();
        appiumManager = new AppiumManager();
        appiumManager.intializeAppium();
    }

    @AfterSuite(alwaysRun = true)
    public void stopTest()  {
        ExtentReporting.stopReporting();
        appiumManager.stopAppium();
    }
}
