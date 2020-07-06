package pages;

import common.reporting.ExtentReporting;
import common.utilityfunctions.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import static common.AppiumManager.mobileDriver;


public class WelcomePageThree extends Page {

    public WelcomePageThree() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(id = "btn_next")
    MobileElement nextButton;

    @AndroidFindBy(xpath = "//*[contains(@text,ON) and @class='android.widget.Switch']")
    MobileElement switchAppOn;

    @AndroidFindBy(xpath = "//*[contains(@text,OFF) and @class='android.widget.Switch']")
    MobileElement switchAppOff;


    public void clickOnNext() {
        boolean success = clickBy(nextButton);
        if (success) {
            ExtentReporting.logInfo( "Clicked on videoSongs");
        } else {
            ExtentReporting.logInfo( "Could Not Click on videoSongs");
        }
    }

    public void switchToHMode() {
        if (!checkIfDisplayed(switchAppOn)) {
            clickBy(switchAppOn);
            ExtentReporting.logInfo( " Clicked on Switched App Button");

        } else {
            ExtentReporting.logInfo( "Could Not Click on Switch App");
        }
    }

}
