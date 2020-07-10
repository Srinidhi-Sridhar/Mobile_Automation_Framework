package com.test.mobile.BasicTests;

import common.AppiumManager;
import common.reporting.ExtentReporting;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoggedInPage;

public class BaseTestClass {

    public AppiumManager appiumManager;
    LoggedInPage loggedInPage;

    @BeforeSuite(alwaysRun = true)
    public void startTest() {
        ExtentReporting.startReporting();
        appiumManager = new AppiumManager();
        appiumManager.intializeAppium();
        loggedInPage = new LoggedInPage();
        loggedInPage.loginAndProvision();
    }

    @AfterSuite(alwaysRun = true)
    public void stopTest()  {
        ExtentReporting.stopReporting();
        appiumManager.stopAppium();
    }
}
