package pages;

import common.utilityfunctions.Page;
import pages.common.GridViewPage;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


import static common.AppiumManager.mobileDriver;


public class KannadaMoviePage extends GridViewPage {

    GridViewPage gridViewPage;

    public KannadaMoviePage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }


    public void getGenreName(int index) {
        gridViewPage = new GridViewPage();
        gridViewPage.getGenreNamesOnIndex(index);
    }

    public void scrollToAnyText(String text) {
        scrollToAnElementByText(mobileDriver, text);
    }
}
