package pages;

import common.AppiumManager;
import common.utilityfunctions.Page;
import common.utilityfunctions.ReadProperties;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static common.AppiumManager.mobileDriver;
import static common.AutomationConstants.ANDROID_TEST_DATA_PROPERTIES;
import static common.AutomationConstants.APP_ACTIVITY_ONE;

public class LoggedInPage extends Page {
    ReadProperties readProperties;
    WelcomePageOne welcomePageOne;
    WelcomePageTwo welcomePageTwo;
    WelcomePageThree welcomePageThree;


    public LoggedInPage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    public void loginAndProvision() {
        readProperties = new ReadProperties();
        if (AppiumManager.getCurrentActivity().equals(readProperties.getProperties(ANDROID_TEST_DATA_PROPERTIES).getProperty(APP_ACTIVITY_ONE))) {
            welcomePageOne = new WelcomePageOne();
            welcomePageOne.clickOnNext();
            welcomePageTwo = new WelcomePageTwo();
            welcomePageTwo.selectCheckBoxBy(WelcomePageTwo.SelectCheckBox.KANNADA);
            welcomePageTwo.selectCheckBoxBy(WelcomePageTwo.SelectCheckBox.JUST_HOLLYWOOD);
            welcomePageTwo.clickOnNext();
            welcomePageThree = new WelcomePageThree();
            welcomePageThree.clickOnNext();
        }
    }
}

