package pages;

import common.reporting.ExtentReporting;
import common.utilityfunctions.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import static common.AppiumManager.mobileDriver;


public class WelcomePageTwo extends Page {

    public WelcomePageTwo() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(id = "btn_next")
    MobileElement nextButton;

    @AndroidFindBy(id = "bt_select")
    MobileElement selectAllButton;

    @AndroidFindBy(id = "optionOne")
    MobileElement justHollywoodCheckBox;

    @AndroidFindBy(id = "optionTwo")
    MobileElement hindiCheckBox;

    @AndroidFindBy(id = "optionThree")
    MobileElement kannadaCheckBox;

    @AndroidFindBy(id = "optionFour")
    MobileElement malayalamCheckBox;

    @AndroidFindBy(id = "optionFive")
    MobileElement tamilCheckBox;

    @AndroidFindBy(id = "optionSix")
    MobileElement teluguCheckBox;


    public enum SelectCheckBox {
        JUST_HOLLYWOOD,
        HINDI,
        KANNADA,
        MALAYALAM,
        TAMIL,
        TELUGU,
        SELECT_ALL
    }

    public void selectCheckBoxBy(SelectCheckBox selectCheckBox) {
        switch (selectCheckBox) {
            case SELECT_ALL:
                clickBy(selectAllButton,"selectAllButton");
                break;
            case JUST_HOLLYWOOD:
                clickBy(justHollywoodCheckBox,"justHollywoodCheckBox");
                break;
            case HINDI:
                clickBy(hindiCheckBox,"hindiCheckBox");
                ExtentReporting.logInfo( "Clicked on Hindi");
                break;
            case KANNADA:
                clickBy(kannadaCheckBox,"kannadaCheckBox");
                ExtentReporting.logInfo( "Clicked on Kannada");
                break;
            case MALAYALAM:
                clickBy(malayalamCheckBox,"kannadaCheckBox");
                break;
            case TAMIL:
                clickBy(tamilCheckBox,"kannadaCheckBox");
                break;
            case TELUGU:
                clickBy(teluguCheckBox,"kannadaCheckBox");
                break;
            default:
                ExtentReporting.logFail("Could not click on Any Checkbox",true);
        }
    }

    public void clickOnNext() {
        clickBy(nextButton,"nextButton");
    }

}
