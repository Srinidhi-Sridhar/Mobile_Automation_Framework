package common.utilityfunctions;

import common.AutomationConstants;
import common.reporting.ExtentReporting;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import static common.AppiumManager.mobileDriver;


/**
 * The type Page.
 */
public class Page {

    private static Logger Log = Logger.getLogger(LogManager.class.getName());

    /**
     * Gets screen shot.
     *
     * @return the screen shot
     */
    public static String getScreenShot() {
        TakesScreenshot takesScreenshots = mobileDriver;
        String dest = takesScreenshots.getScreenshotAs(OutputType.BASE64);
        return "data:image/jpg;base64, " + dest ;
    }


    /**
     * Gets screen shot as out put.
     */
    public static void getScreenShotAsOutPut() {
        TakesScreenshot takesScreenshots = mobileDriver;
        File source = takesScreenshots.getScreenshotAs(OutputType.FILE);
        String destination = AutomationConstants.SCREENSHOT_PATH;
       File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
           Log.error("Could not Capture Screenshot",e);
        }
    }

    /**
     * Click by boolean.
     *
     * @param locator the locator
     * @return the boolean
     */
    protected boolean clickBy(WebElement locator,String buttonName) {
        try {
            new WebDriverWait(mobileDriver, AutomationConstants.WAIT_UNTIL_ELEMENT).until(ExpectedConditions.elementToBeClickable((locator))).click();
            ExtentReporting.logInfo("Clicked on "+buttonName);
        } catch (WebDriverException e) {
             ExtentReporting.logFail("Could not Click " + locator.getText(), true);
            Log.error("Could not click"+ buttonName,e);
            return false;
        }
        return true;
    }

    /**
     * Send keys by boolean.
     *
     * @param locator      the locator
     * @param keysToBeSent the keys to be sent
     * @return the boolean
     */
    protected boolean sendKeysBy(WebElement locator, String keysToBeSent,String buttonName) {
        try {
            new WebDriverWait(mobileDriver, AutomationConstants.WAIT_UNTIL_ELEMENT).until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(keysToBeSent);
            ExtentReporting.logInfo("Sent Keys to "+buttonName);
        } catch (WebDriverException e) {
            ExtentReporting.logFail("Could not Send Keys " +buttonName, true);
            Log.error("Could not Send Keys"+ buttonName,e);
            return false;
        }
        return true;
    }

    /**
     * Check if displayed boolean.
     *
     * @param locator the locator
     * @return the boolean
     */
    public boolean checkIfDisplayed(WebElement locator) {
        try {
            ExtentReporting.logInfo("Looking For element"+locator.getText());
            new WebDriverWait(mobileDriver, AutomationConstants.WAIT_UNTIL_ELEMENT).until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed();
        } catch (WebDriverException e) {
            ExtentReporting.logInfo("Element is not displayed"+locator.getText());
            return false;
        }
        return true;
    }

    /**
     * Hover over boolean.
     *
     * @param locator the locator
     * @return the boolean
     */
    protected boolean hoverOver(WebElement locator) {
        try {
            Actions actions = new Actions(mobileDriver);
            actions.moveToElement(locator).perform();
            new WebDriverWait(mobileDriver, AutomationConstants.WAIT_UNTIL_ELEMENT).until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed();
            ExtentReporting.logInfo("Hovering Over"+locator.getText());
        } catch (WebDriverException e) {
            Log.error("Could not Hover Over"+ locator.getText(),e);
            return false;
        }
        return true;
    }

    /**
     * Press enter key boolean.
     *
     * @param locator the locator
     * @return the boolean
     */
    protected boolean pressEnterKey(WebElement locator) {
        try {
            new WebDriverWait(mobileDriver, AutomationConstants.WAIT_UNTIL_ELEMENT).until(ExpectedConditions.elementToBeClickable((locator))).sendKeys(Keys.ENTER);
        } catch (WebDriverException e) {
            ExtentReporting.logFail("Could not Press Enter Key" + locator.getText(), true);
            Log.error("Could not Press Enter Key"+ locator.getText(),e);
            return false;
        }
        return true;
    }

    /**
     * Horizontal swipe.
     *
     * @param start    the start
     * @param end      the end
     * @param anchor   the anchor
     * @param duration the duration
     */
    public void horizontalSwipe(int start, int end, int anchor, int duration) {
        TouchAction action = new TouchAction(mobileDriver);
        action.press(new PointOption().withCoordinates(start, anchor))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
                .moveTo(new PointOption().withCoordinates(end, anchor))
                .release()
                .perform();
    }

    /**
     * Vertical swipe.
     *
     * @param startPoint the start point
     * @param endPoint   the end point
     * @param anchor     the anchor
     * @param duration   the duration
     */
    public void verticalSwipe(int startPoint, int endPoint, int anchor, int duration) {
        TouchAction action = new TouchAction(mobileDriver);
        action.press(new PointOption().withCoordinates(anchor, startPoint))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
                .moveTo(new PointOption().withCoordinates(anchor, endPoint))
                .release()
                .perform();
    }

    /**
     * Swipe left.
     *
     * @param pageRef the page ref
     */
    public void swipeLeft(MobileElement pageRef) {
        int startX = pageRef.getCenter().getX();
        int endX = startX / 5;
        int startXCordinate = startX / 30;
        int endXCordinate = pageRef.getCenter().getX() + endX;
        int yCordinate = pageRef.getCenter().getY();
        horizontalSwipe(endXCordinate, startXCordinate, yCordinate, 2000);
    }

    /**
     * Swipe right.
     *
     * @param pageRef the page ref
     */
    public void swipeRight(MobileElement pageRef) {
        int startXCordinate = pageRef.getCenter().getX();
        startXCordinate = startXCordinate - 100;
        int endXCordinate = pageRef.getCenter().getX() + startXCordinate;
        horizontalSwipe(startXCordinate, endXCordinate, 500, 2000);
    }

    /**
     * Rotate device to land scape.
     */
    public void rotateDeviceToLandScape() {
        mobileDriver.rotate(ScreenOrientation.LANDSCAPE);
    }

    /**
     * Rotate device to potrait.
     */
    public void rotateDeviceToPotrait() {
        mobileDriver.rotate(ScreenOrientation.PORTRAIT);
    }

    /**
     * Navigate back.
     */
    public void navigateBack() {
        mobileDriver.navigate().back();
    }

    /**
     * Vertical swipe.
     */
    public void verticalSwipe() {
        Dimension size = mobileDriver.manage().window().getSize();
        int anchor = (int) (size.width * 0.5);
        int startPoint = (int) (size.height * 0.7);
        int endPoint = (int) (size.height * 0.1);
        TouchAction action = new TouchAction(mobileDriver);
        action.press(new PointOption().withCoordinates(anchor, startPoint))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
                .moveTo(new PointOption().withCoordinates(endPoint, anchor))
                .release()
                .perform();
    }

    /**
     * Scroll to an element by text web element.
     *
     * @param mobileDriver the mobile driver
     * @param text         the text
     * @return the web element
     */
    public WebElement scrollToAnElementByText(AppiumDriver mobileDriver, String text) {
        return mobileDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }

    /**
     * Switch to web view context.
     */
    public void switchToWebViewContext() {
        Set<String> contextNames = mobileDriver.getContextHandles();
        for (String context : contextNames) {
            if (context.contains("WEBVIEW")) {
                mobileDriver.context(context);
                ExtentReporting.logInfo("Switch to Web Context " + context);
                Log.info("Switch to Web Context" + context);
            } else {
                ExtentReporting.logInfo("Could not Switch to Web Context " + context);
                Log.info("Could not Switch to Web Context " + context);
            }
        }
    }


    protected Point getCoridnates(MobileElement mobileElement)
    {
        Point location = mobileElement.getLocation();
        return location;
    }
}


