package pages;

import common.reporting.ExtentReporting;
import enums.NavigateInsideMovieTrailer;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static common.AppiumManager.mobileDriver;


public class HomePage extends LoggedInPage {

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

    @AndroidFindBy(xpath = "//*[@text='Kannada' and @resource-id='com.andyapps.thetrailersnow:id/material_drawer_name']")
    MobileElement kannadaTrailer;

    @AndroidFindBy(xpath = "//*[@class='@resource-id='com.andyapps.thetrailersnow:id/material_drawer_name' and @text='Tamil']")
    private MobileElement tamilTrailer;

    @AndroidFindBy(xpath = "//*[@class='@resource-id='com.andyapps.thetrailersnow:id/material_drawer_name' and @text='Telugu']")
    private MobileElement teluguTrailer;

    @AndroidFindBy(id = "com.andyapps.thetrailersnow:id/fab")
    private MobileElement navigateToTop;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @text='Movie Trailers']")
    MobileElement movieTrailers;

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
       clickBy(movieTrailers,"movieTrailers");
    }

    public void clickVideoSongs() {
        clickHambugerMenu();
       clickBy(videoSongs,"videoSongs");
    }

    public void clickTvShows() {
        clickHambugerMenu();
        clickBy(tvShows,"tvShows");
    }

    public void clickFavourites() {
        clickHambugerMenu();
        clickBy(favouriteTrailers,"favouriteTrailers");
    }

    public void clickJustBollywood() {
        clickHambugerMenu();
        clickBy(justHollywood,"Just HollyWood");
    }

    public void clickShareApp() {
        clickHambugerMenu();
         clickBy(shareApp,"Share App Button");
    }

    public void clickPrivacyPolicy() {
         clickHambugerMenu();
         clickBy(privacyPolicy,"Privacy Button");
    }

    public void clickSendFeedBack() {
        clickHambugerMenu();
        clickBy(sendFeedback,"Send Feed Back Button");
    }

    public void clickRateApp() {
        clickHambugerMenu();
       clickBy(rateApp,"Rate App Button");
    }

    public void clickHambugerMenu() {
        if (hamburgerMenu.isDisplayed()) {
            ExtentReporting.logInfo("Clicking on Hamburger Menu");
            clickBy(hamburgerMenu,"Hamburger Menu");
        }
    }

    public void navigateToTop() {
       clickBy(navigateToTop,"navigateToTop");
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
                clickMovieLanguageTrailers(kannadaTrailer);
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
        clickBy(languageTrailer,"Clicked on Language Trailer");
    }

    public void closeExpandedMovieTrailer() {
        if (kannadaTrailer.isDisplayed())
            clickMovieTrailers();
    }

    public void clickKannadaTrailer()
    {
       clickBy(kannadaTrailer,"kannadaTrailer");
    }
}

