package com.test.mobile.BasicTests;


import pages.common.GridViewPage;
import pages.*;
import enums.NavigateInsideMovieTrailer;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Few Smoke Tests
 */
public class SmokeTest1 extends BaseTestClass {

    HomePage homePage;
    KannadaMoviePage kannadaMoviePage;
    GridViewPage gridViewPage;
    LoggedInPage loggedInPage;
    FavoritePage favoritePage;
    TrailerPage trailerPage;
    YoutubePage youtubePage;
    final String movie_Name = "Dia";
    final String hindi_Movie_Name ="Gulabo Sitabo";
    final String director_Name = "Shoojit Sircar";
    private final String release_Date = "12 June 2020 (UK)";


    @BeforeTest
    public void initiateLogin() {
        loggedInPage = new LoggedInPage();
        loggedInPage.loginAndProvision();
        homePage = new HomePage();
    }


    /**
     * Verify the Favorite .
     */
    @Test(testName = "TN001", description = "Verifying the Favorite Movie is Displayed in Favourite Section", priority = 0,enabled = false)
    public void checkFavouriteMovie() {
        homePage.navigateBack();
        homePage.navigateToMovieTrailer(NavigateInsideMovieTrailer.KANNADA);
        kannadaMoviePage = new KannadaMoviePage();
        kannadaMoviePage.scrollToAnyText(movie_Name);
        kannadaMoviePage.clickOnLikeButton();
        homePage.clickHambugerMenu();
        homePage.closeExpandedMovieTrailer();
        homePage.clickFavourites();
        favoritePage = new FavoritePage();
        Assert.assertEquals(favoritePage.getMovieNamesOnIndex(0), movie_Name, "Movie Name Not Favorite");
        favoritePage.navigateBack();
    }

    @Test(testName = "TN002", description = "Verifying the Favorite Movie is Displayed in Favourite Section", priority = 1)
    public void verifyMovieDetails() {
        homePage.clickHambugerMenu();
        homePage.navigateToMovieTrailer(NavigateInsideMovieTrailer.HINDI);
        gridViewPage = new GridViewPage();
        gridViewPage.clickByIndex(0);
        trailerPage = new TrailerPage();
        trailerPage.toScroll();
        Assert.assertEquals(trailerPage.getDirectorName(), director_Name, "Director Name Not Matching");
        Assert.assertEquals(trailerPage.getReleaseDetails(), release_Date, "Release Date Not Matching");
    }

    @Test(testName = "TN003", description = "Watch a Trailer", priority = 1)
    public void watchMovieTrailer() {
        trailerPage.watchTrailer();
        youtubePage= new YoutubePage();
        Assert.assertTrue(youtubePage.getMovieName().startsWith(hindi_Movie_Name));
    }
}



