package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AutomationConstants {
    public static final String ANDROID_TEST_DATA_PROPERTIES = System.getProperty("user.dir") + "/src/main/resources/androidTestData.properties";
    public static final String IOS_TEST_DATA_PROPERTIES = System.getProperty("user.dir") + "/src/main/resources/iOSTestData.properties";
    public static final String GLOBAL_PROPERTIES_PATH = System.getProperty("user.dir") + "/src/main/resources/globalProperties.properties";
    public static final String PLATFORM_NAME_KEY = "platform_Name";
    public static final String NODE_PATH_KEY ="node_path";
    public static final String IP_ADDRESS_KEY ="ip_Address";
    public static final String DEVICE_ID="device_ID";
    public static final String DEVICE_NAME="device_Name";
    public static final String AUTOMATION_NAME ="automation_Name";
    public static final String APP_PACKAGE_ANDROID ="app_package";
    public static final String APP_ACTIVITY_TWO="app_activity2";
    public static final String APP_ACTIVITY_ONE ="app_activity";
    public static final String AUTOMATION_NAME_IOS= "automation_Name";
    public static final String DEVICE_ID_IOS="deviceID";
    public static final String BUNDLE_ID_IOS ="bundle_ID";
    public static final String DEVICE_VERSION_IOS="13.5.1" ;
    public static final String DEVICE_NAME_IOS ="device_Name";
    public static final int IMPLICIT_TIME_OUT=10;
    public static final int WAIT_UNTIL_ELEMENT=10;
    public static final String ANDROID_LAUNCH_TIMEOUT="4000";
    public static final String DATE_FORMAT = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    public static final String EXTENT_REPORT_PATH=System.getProperty("user.dir") +"/Reports/Report"+DATE_FORMAT+".html";
    public static  final String SCREENSHOT_PATH=System.getProperty("user.dir") +"/Screenshots/FailedScreenShots"+DATE_FORMAT+".png";
    public static final String AUTOMATION_REPORT_NAME = "Automation Test Report";
}