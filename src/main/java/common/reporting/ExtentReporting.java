package common.reporting;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import common.AutomationConstants;
import common.utilityfunctions.Page;
import org.testng.Assert;


/**
 * The type Extent reporting.
 */
public class ExtentReporting {

    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    /**
     * Start reporting.
     */
    public static void startReporting() {
        extentReports = new ExtentReports(AutomationConstants.EXTENT_REPORT_PATH, Boolean.FALSE);
        extentTest = extentReports.startTest(AutomationConstants.AUTOMATION_REPORT_NAME);
    }

    /**
     * Stop reporting.
     */
    public static void stopReporting() {
        extentReports.endTest(extentTest);
        extentReports.flush();
    }

    /**
     * Log error.
     *
     * @param logMessage         the log message
     * @param screenShotRequired the screen shot required
     */
    public static void logError(String logMessage, Boolean screenShotRequired) {
        screenShotAndLog(logMessage, screenShotRequired, LogStatus.ERROR);
    }

    /**
     * Log info.
     *
     * @param logMessage the log message
     */
    public static void logInfo(String logMessage) {
        extentTest.log(LogStatus.INFO, logMessage);
    }

    /**
     * Log skip.
     *
     * @param logMessage the log message
     */
    public static void logSkip(String logMessage) {
        extentTest.log(LogStatus.SKIP, logMessage);
    }

    /**
     * Log fail.
     *
     * @param logMessage         the log message
     * @param screenShotRequired the screen shot required
     */
    public static void logFail(String logMessage, Boolean screenShotRequired) {
        screenShotAndLog(logMessage, screenShotRequired, LogStatus.FAIL);
        Assert.fail();
    }

    /**
     * Log pass.
     *
     * @param logMessage         the log message
     * @param screenShotRequired the screen shot required
     */
    public static void logPass(String logMessage, Boolean screenShotRequired) {
        screenShotAndLog(logMessage, screenShotRequired, LogStatus.PASS);
    }

    private static void screenShotAndLog(String logMessage, boolean screenShotRequired, LogStatus logStatus) {
        if (screenShotRequired) {
            extentTest.log(logStatus, logMessage, extentTest.addScreenCapture(Page.getScreenShot()));
            Page.getScreenShotAsOutPut();
        } else {
            extentTest.log(logStatus, logMessage);
        }
    }

}
