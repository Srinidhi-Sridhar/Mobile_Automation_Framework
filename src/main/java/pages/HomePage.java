package pages;

import common.reporting.ExtentReporting;
import common.utilityfunctions.Page;
import enums.NavigateInsideMovieTrailer;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static common.AppiumManager.mobileDriver;


public class HomePage extends Page {

    @AndroidFindBy(id = "com.andyapps.thetrailersnow:id/ic_menu")
    MobileElement hamburgerMenu;

    @AndroidFindBy(id = "com.andyapps.thetrailersnow:id/img_search")
    MobileElement searchIcon;

    @AndroidFindBy(id = "com.andyapps.thetrailersnow:id/img_tv_show")
    MobileElement tvShowsIcon;

    @AndroidFindBy(id = "com.andyapps.thetrailersnow:id/img_add")
    MobileElement newsIcon;

    @AndroidFindBy(id = "com.andyapps.thetrailersnow:id/storyView")
    MobileElement storyView;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Popular']")
    MobileElement popularTrailers;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Most Popular']")
    MobileElement mostPopular;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Now Running']")
    MobileElement nowRunning;

    @AndroidFindBy(xpath = "//*[@resource-id='com.andyapps.thetrailersnow:id/material_drawer_name' and @text='English']")
    MobileElement englishTrailers;

    @AndroidFindBy(xpath = "//*[@resource-id='com.andyapps.thetrailersnow:id/material_drawer_name' and @text='Malayalam']")
    MobileElement malyalamTrailers;

    @AndroidFindBy(xpath = "//*[@resource-id='com.andyapps.thetrailersnow:id/material_drawer_name' and @text='Hindi']")
    MobileElement hindiTrailers;

    @AndroidFindBy(xpath = "//*[contains(@text,'Kannada') and @resource-id='com.andyapps.thetrailersnow:id/material_drawer_name']")
    MobileElement kannadaTrailer;

    @AndroidFindBy(xpath = "//*[@class='@resource-id='com.andyapps.thetrailersnow:id/material_drawer_name' and @text='Tamil']")
    private MobileElement tamilTrailer;

    @AndroidFindBy(xpath = "//*[@class='@resource-id='com.andyapps.thetrailersnow:id/material_drawer_name' and @text='Telugu']")
    private MobileElement teluguTrailer;

    @AndroidFindBy(id = "com.andyapps.thetrailersnow:id/fab")
    private MobileElement navigateToTop;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Movie Trailers']")
    private MobileElement movieTrailers;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Video Songs']")
    private MobileElement videoSongs;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='TV Shows']")
    private MobileElement tvShows;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Favourites']")
    private MobileElement favouriteTrailers;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Just Hollywood']")
    private MobileElement justHollywood;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Share the App']")
    private MobileElement shareApp;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Privacy Policy']")
    private MobileElement privacyPolicy;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Send Feedback']")
    private MobileElement sendFeedback;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Rate App']")
    private MobileElement rateApp;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Movie Trailers']//following::android.widget.LinearLayout[1]")
    private MobileElement movieTrailersDownArrowButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Video Songs']//following::android.widget.LinearLayout[1]")
    private MobileElement videoSongsDownArrowButton;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    public void clickMovieTrailers() {
        clickHambugerMenu();
        boolean success = clickBy(movieTrailers);
        if (success) {
            ExtentReporting.logInfo("Clicked on Movie Trailers");
        } else {
            ExtentReporting.logInfo("Could Not Click on Movie Trailers");
        }
    }

    public void clickVideoSongs() {
        clickHambugerMenu();
        boolean success = clickBy(videoSongs);
        if (success) {
            ExtentReporting.logInfo("Clicked on videoSongs");
        } else {
            ExtentReporting.logInfo("Could Not Click on videoSongs");
        }
    }

    public void clickTvShows() {
        clickHambugerMenu();
        boolean success = clickBy(tvShows);
        if (success) {
            ExtentReporting.logInfo("Clicked on TV Shows");
        } else {
            ExtentReporting.logInfo("Could Not Click on TV Shows");
        }
    }

    public void clickFavourites() {
        clickHambugerMenu();
        boolean success = clickBy(favouriteTrailers);
        if (success) {
            ExtentReporting.logInfo("Clicked on Favourite Trailers");
        } else {
            ExtentReporting.logInfo("Could Not Click Favourite Trailers");
        }
    }

    public void clickJustBollywood() {
        clickHambugerMenu();
        boolean success = clickBy(justHollywood);
        if (success) {
            ExtentReporting.logInfo("Clicked on Just Hollywood");
        } else {
            ExtentReporting.logInfo("Could Not Click Just Hollywood");
        }
    }

    public void clickShareApp() {
        clickHambugerMenu();
        boolean success = clickBy(shareApp);
        if (success) {
            ExtentReporting.logInfo("Clicked on Share App");
        } else {
            ExtentReporting.logInfo("Could Not Click Share App");
        }
    }

    public void clickPrivacyPolicy() {
        clickHambugerMenu();
        boolean success = clickBy(privacyPolicy);
        if (success) {
            ExtentReporting.logInfo("Clicked on Privacy Policy");
        } else {
            ExtentReporting.logInfo("Could Not Click Privacy Policy");
        }
    }

    public void clickSendFeedBack() {
        clickHambugerMenu();
        boolean success = clickBy(sendFeedback);
        if (success) {
            ExtentReporting.logInfo("Clicked on Send Feedback");
        } else {
            ExtentReporting.logInfo("Could Not Click Send Feedback");
        }
    }

    public void click(WebElement element) {
        clickHambugerMenu();
        boolean success = clickBy(element);
        if (success) {
            ExtentReporting.logInfo("Clicked on " + element.getText());
        } else {
            ExtentReporting.logInfo("Could Not Click" + element.getText());
        }
    }

    public void clickRateApp() {
        clickHambugerMenu();
        boolean success = clickBy(rateApp);
        if (success) {
            ExtentReporting.logInfo("Clicked on Rate App");
        } else {
            ExtentReporting.logInfo("Could Not Click Rate App");
        }
    }

    public void clickHambugerMenu() {
        if (hamburgerMenu.isDisplayed()) {
            ExtentReporting.logInfo("Clicking on Hamburger Menu");
            clickBy(hamburgerMenu);
            ExtentReporting.logInfo("Clicked on Hamburger Menu");
        } else {
            ExtentReporting.logInfo("Could not Click on Hamburger Menu");
        }
    }

    public void navigateToTop() {
        boolean success = clickBy(navigateToTop);
        {
            if (success) {
                ExtentReporting.logInfo("Clicked on Navigate To Top");
            } else {
                ExtentReporting.logInfo("Could Not Navigate To Top");
            }
        }
    }

    public void navigateToMovieTrailer(NavigateInsideMovieTrailer navigateInsideMovieTrailer) {
        switch (navigateInsideMovieTrailer) {
            case ENGLISH:
                clickMovieLanguageTrailers(englishTrailers);
                break;
            case HINDI:
                clickMovieLanguageTrailers(hindiTrailers);
                break;
            case KANNADA:
                clickMovieLanguageTrailers(this.kannadaTrailer);
                break;
            case MALAYALAM:
                clickMovieLanguageTrailers(malyalamTrailers);
                break;
            case TAMIL:
                clickMovieLanguageTrailers(tamilTrailer);
                break;
            case TELUGU:
                clickMovieLanguageTrailers(teluguTrailer);
                break;
            case MOST_POPULAR:
                clickMovieLanguageTrailers(mostPopular);
                break;
            case NOW_RUNNING:
                clickMovieLanguageTrailers(nowRunning);
                break;
            default:
                ExtentReporting.logFail("Could not click", true);
                break;
        }
    }

    private void clickMovieLanguageTrailers(MobileElement languageTrailer) {
        clickMovieTrailers();
        clickBy(languageTrailer);
    }

    public void closeExpandedMovieTrailer() {
        if (kannadaTrailer.isDisplayed())
            clickMovieTrailers();
    }
}

