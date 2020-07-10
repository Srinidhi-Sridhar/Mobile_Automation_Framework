package pages;

import common.utilityfunctions.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static common.AppiumManager.mobileDriver;


public class PrivacyPolicyPage extends Page {


    @AndroidFindBy(xpath ="//*[@resource-id='com.android.chrome:id/url_bar']")
    MobileElement getURLTitle;

    public PrivacyPolicyPage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    public String getURl()
    {
        String directorName=getURLTitle.getText();
        System.out.println(directorName);
         return directorName;
    }

}
