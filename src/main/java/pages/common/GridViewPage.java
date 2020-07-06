package pages.common;

import common.reporting.ExtentReporting;
import common.utilityfunctions.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static common.AppiumManager.mobileDriver;

public class GridViewPage extends Page {
    public GridViewPage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.andyapps.thetrailersnow:id/iv_car']")
    List<MobileElement> gridViewItems;

    @AndroidFindBy(xpath = "//*[@resource-id='com.andyapps.thetrailersnow:id/iv_car']//following-sibling::*[@resource-id='com.andyapps.thetrailersnow:id/tv_model']")
    List<MobileElement> gridViewMovieNames;

    @AndroidFindBy(xpath = "//*[@resource-id='com.andyapps.thetrailersnow:id/tv_brand']")
    List<MobileElement> gridViewGenreNames;

    @AndroidFindBy(id = "com.andyapps.thetrailersnow:id/like_button")
    private MobileElement likeButton;

    @AndroidFindBy(id = "com.andyapps.thetrailersnow:id/fab")
    private MobileElement arrowButton;

    @AndroidFindBy(id = "com.andyapps.thetrailersnow:id/tv_epsiode_season")
    private MobileElement newSeason;

    @AndroidFindBy(id = "com.andyapps.thetrailersnow:id/tv_imdb")
    private MobileElement wikiButton;


    public void clickOnLikeButton() {
        boolean success = clickBy(likeButton);
        if (success) {
            ExtentReporting.logInfo("Clicked on Like Button");
        } else {
            ExtentReporting.logInfo("Could Not Click on Like Button");
        }
    }

    public int getMovieCount() {
        List<MobileElement> elements = gridViewItems;
        if (elements == null) {
            ExtentReporting.logInfo("No Movies Present");
            return 0;
        }
        return elements.size();
    }

    public boolean clickByIndex(int index) {
        List<MobileElement> elements = gridViewItems;
        int size = elements.size();
        if (elements == null) {
            System.out.println("No Movies Present");
            return false;
        }
        if (size == 0) {
            System.out.println("No Elements Present");
            return false;
        }
        if (index > size) {
            System.out.println("Given index is not present");
            return false;
        }
        MobileElement element = elements.get(index);
        clickBy(element);
        return true;

    }

    public int getName(String name) {
        int index = -1;
        for (int i = 0; i < gridViewMovieNames.size(); i++) {
            if (gridViewMovieNames.get(i).getText().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean clickByName(String name) {
        int index = getName(name);
        if (index < 0) {
            return false;
        }
        clickByIndex(index);
        return true;
    }

    public List<String> returnAllMovieNames() {
        List<String> names = new ArrayList<>();
        for (MobileElement element : gridViewMovieNames) {
            names.add(element.getText());
            System.out.println(names);
        }
        return names;
    }

    public List<String> returnAllGenreNames() {
        List<String> names = new ArrayList<>();
        for (MobileElement element : gridViewGenreNames) {
            names.add(element.getText());
            System.out.println(names);
        }
        return names;

    }

    public List<String> returnAllGenres() {
        List<String> names = new ArrayList<>();
        for (MobileElement element : gridViewGenreNames) {
            names.add(element.getText());
        }
        return names;
    }

    public String getGenreNamesOnIndex(int index) {
        return getGenreString(index);
    }


    public void clickOnWikiButton() {
        boolean success = clickBy(wikiButton);
        if (success) {
            ExtentReporting.logInfo("Clicked on Wiki Button");
        } else {
            ExtentReporting.logInfo("Could Not Click on Wiki Button");
        }
    }

    public void switchToWebView() {
        switchToWebViewContext();
    }

    public String getMovieNamesOnIndex(int index) {
        return getMovieString(index);
    }

    private String getMovieString(int index) {
        List<MobileElement> element = gridViewMovieNames;
        int size = element.size();
        String temp;
        if (index > size) {
            System.out.println("Index is not proper");
            return null;
        }
        temp = gridViewMovieNames.get(index).getText();
        return temp;
    }

    private String getGenreString(int index) {
        List<MobileElement> element = gridViewGenreNames;
        int size = element.size();
        String temp;
        if (index > size) {
            System.out.println("Index is not proper");
        }
        temp = gridViewGenreNames.get(index).getText();
        return temp;
    }
}


