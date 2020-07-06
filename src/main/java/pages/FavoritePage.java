package pages;

import pages.common.GridViewPage;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import static common.AppiumManager.mobileDriver;


public class FavoritePage extends GridViewPage {

    GridViewPage gridViewPage;

    public FavoritePage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }
}
