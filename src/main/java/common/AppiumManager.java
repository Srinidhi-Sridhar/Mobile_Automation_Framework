package common;

import common.reporting.ExtentReporting;
import common.utilityfunctions.ReadProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static common.AutomationConstants.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;


public class AppiumManager {

    private static final Logger LOGGER = Logger.getLogger(AppiumManager.class.getName());

    private AppiumDriverLocalService localService;
    private AppiumServiceBuilder builderAppium;
    private DesiredCapabilities desiredCapabilities;
    public static AppiumDriver mobileDriver;
    ReadProperties readProperties;


    public Capabilities setCapabilities() {
        if (readProperties.getProperties(AutomationConstants.GLOBAL_PROPERTIES_PATH).getProperty(PLATFORM_NAME_KEY).equals("android")) {
            getAndroidCaps();
            LOGGER.info("Android Capabilities Obtained");
            LOGGER.debug("Android Capabilities Obtained debug");
            ExtentReporting.logInfo("Android Capabilities Obtained");
        } else {
            getIOSCaps();
            LOGGER.info("Android Capabilities Obtained");
            ExtentReporting.logInfo("iOS Capabilities Obtained");
        }
        return desiredCapabilities;
    }

    public void startAppiumService() {
        readProperties = new ReadProperties();
        builderAppium = new AppiumServiceBuilder().usingDriverExecutable(new File(readProperties.getProperties(AutomationConstants.GLOBAL_PROPERTIES_PATH).getProperty(NODE_PATH_KEY))).withIPAddress(readProperties.getProperties(AutomationConstants.GLOBAL_PROPERTIES_PATH).getProperty(IP_ADDRESS_KEY)).usingAnyFreePort().withArgument(GeneralServerFlag.SESSION_OVERRIDE).withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        localService = AppiumDriverLocalService.buildService(builderAppium);
        localService.start();
        LOGGER.info("Appium Services Started");
        ExtentReporting.logInfo("Appium Services Started");
    }

    public void startDriver() {
        try {

            if (readProperties.getProperties(GLOBAL_PROPERTIES_PATH).getProperty(PLATFORM_NAME_KEY).equals("android")) {
                mobileDriver = new AndroidDriver(localService.getUrl(), setCapabilities());
                LOGGER.info("Android Driver Started");
                ExtentReporting.logInfo("Android Driver Started");
                mobileDriver.manage().timeouts().implicitlyWait(IMPLICIT_TIME_OUT, TimeUnit.SECONDS);
            } else {
                mobileDriver = new IOSDriver(localService.getUrl(), setCapabilities());
                LOGGER.info("iOS Driver Started");
                ExtentReporting.logInfo("iOS Driver Started");
                mobileDriver.manage().timeouts().implicitlyWait(IMPLICIT_TIME_OUT, TimeUnit.SECONDS);
            }
        } catch (WebDriverException e) {
            LOGGER.error("Server Not Started", e);
        }
    }


    public void stopAppiumService() {
        if (localService.isRunning()) {
            localService.stop();
        }
    }


    public void stopDriver() {
        ExtentReporting.logInfo("Drivers Stopped");
        LOGGER.info("Drivers Stopped");
    }

    public void getAndroidCaps() {
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME, readProperties.getProperties(GLOBAL_PROPERTIES_PATH).getProperty(PLATFORM_NAME_KEY));
        LOGGER.info("Platform Name is " + readProperties.getProperties(GLOBAL_PROPERTIES_PATH).getProperty(PLATFORM_NAME_KEY));
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, readProperties.getProperties(ANDROID_TEST_DATA_PROPERTIES).getProperty(DEVICE_ID));
        LOGGER.info("UDID is " + readProperties.getProperties(ANDROID_TEST_DATA_PROPERTIES).getProperty(DEVICE_ID));
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, readProperties.getProperties(ANDROID_TEST_DATA_PROPERTIES).getProperty(DEVICE_NAME));
        LOGGER.info("Device Name is " + readProperties.getProperties(ANDROID_TEST_DATA_PROPERTIES).getProperty(DEVICE_NAME));
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, readProperties.getProperties(ANDROID_TEST_DATA_PROPERTIES).getProperty(AUTOMATION_NAME));
        LOGGER.info("Automation Name is " + readProperties.getProperties(ANDROID_TEST_DATA_PROPERTIES).getProperty(AUTOMATION_NAME));
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, readProperties.getProperties(ANDROID_TEST_DATA_PROPERTIES).getProperty(APP_PACKAGE_ANDROID));
        LOGGER.info("App Package is " + readProperties.getProperties(ANDROID_TEST_DATA_PROPERTIES).getProperty(APP_PACKAGE_ANDROID));
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, readProperties.getProperties(GLOBAL_PROPERTIES_PATH).getProperty(ANDROID_LAUNCH_TIMEOUT));
        LOGGER.info("Launch is set to " + readProperties.getProperties(ANDROID_TEST_DATA_PROPERTIES).getProperty(ANDROID_LAUNCH_TIMEOUT));
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, readProperties.getProperties(ANDROID_TEST_DATA_PROPERTIES).getProperty(APP_ACTIVITY_TWO));
    }

    public void getIOSCaps() {
        desiredCapabilities.setCapability(PLATFORM_NAME, readProperties.getProperties(GLOBAL_PROPERTIES_PATH).getProperty(PLATFORM_NAME_KEY));
        LOGGER.info("Platform Name is " + readProperties.getProperties(GLOBAL_PROPERTIES_PATH).getProperty(PLATFORM_NAME_KEY));
        desiredCapabilities.setCapability(AUTOMATION_NAME, readProperties.getProperties(IOS_TEST_DATA_PROPERTIES).getProperty(AUTOMATION_NAME_IOS));
        LOGGER.info("Automation Name is " + readProperties.getProperties(IOS_TEST_DATA_PROPERTIES).getProperty(AUTOMATION_NAME));
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, readProperties.getProperties(IOS_TEST_DATA_PROPERTIES).getProperty(DEVICE_NAME_IOS));
        LOGGER.info("Device Name is " + readProperties.getProperties(IOS_TEST_DATA_PROPERTIES).getProperty(DEVICE_NAME));
        desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, readProperties.getProperties(IOS_TEST_DATA_PROPERTIES).getProperty(BUNDLE_ID_IOS));
        LOGGER.info("Bundle Id is " + readProperties.getProperties(IOS_TEST_DATA_PROPERTIES).getProperty(BUNDLE_ID_IOS));
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, readProperties.getProperties(IOS_TEST_DATA_PROPERTIES).getProperty(DEVICE_ID_IOS));
        LOGGER.info("UDID is " + readProperties.getProperties(IOS_TEST_DATA_PROPERTIES).getProperty(DEVICE_ID_IOS));
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, readProperties.getProperties(IOS_TEST_DATA_PROPERTIES).getProperty(DEVICE_VERSION_IOS));
        LOGGER.info("Device Version is " + readProperties.getProperties(IOS_TEST_DATA_PROPERTIES).getProperty(DEVICE_VERSION_IOS));
    }

    public String getUDID() {
        return mobileDriver.getCapabilities().asMap().get(MobileCapabilityType.UDID).toString();
    }

    public String getDeviceName() {
        return mobileDriver.getCapabilities().asMap().get(MobileCapabilityType.DEVICE_NAME).toString();
    }

    public static String getCurrentActivity() {
        return mobileDriver.getCapabilities().asMap().get(AndroidMobileCapabilityType.APP_ACTIVITY).toString();
    }

    public void intializeAppium() {
        startAppiumService();
        startDriver();
    }

    public void stopAppium() {
        stopDriver();
        stopAppiumService();
    }
}



