package pages;

import common.reporting.ExtentReporting;
import common.utilityfunctions.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static common.AppiumManager.mobileDriver;


public class WelcomePageOne extends Page {

    public WelcomePageOne() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(id = "btn_next")
    public MobileElement nextButton;

    @AndroidFindBy(xpath = "//*[contains(@text,'One Stop Shop') and @class='android.widget.TextView']")
    public MobileElement welcomePageTextTwo;

    @AndroidFindBy(xpath = "//*[contains(@text,'Welcome') and @class='android.widget.TextView']")
    public MobileElement welcomePageTextOne;


    public void clickOnNext() {

        boolean success = clickBy(nextButton,"nextButton");
        if (success) {
            ExtentReporting.logInfo("Clicked on Next Button");
        } else {
            ExtentReporting.logInfo("Could Not Click on Next Button");
        }
    }

    public String getWelcomeTextOne() {

        return (welcomePageTextOne.getText());
    }

    public String getWelcomeTextTwo() {

        return (welcomePageTextTwo.getText());
    }

    public boolean toLogin() {
        return (checkIfDisplayed(nextButton));

    }
}
