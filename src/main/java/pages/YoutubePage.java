package pages;

import common.utilityfunctions.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static common.AppiumManager.mobileDriver;


public class YoutubePage extends Page {


    @AndroidFindBy(xpath ="//*[@resource-id='com.google.android.youtube:id/player_video_title_view']")
    MobileElement getTitle;

    @AndroidFindBy(xpath ="com.google.android.youtube:id/player_share_button")
    MobileElement shareButton;

    @AndroidFindBy(xpath ="com.google.android.youtube:id/player_control_play_pause_replay_button")
    MobileElement pausePlayButton;

    @AndroidFindBy(xpath ="com.google.android.youtube:id/player_overflow_button")
    MobileElement contextualMenu;

    @AndroidFindBy(xpath ="com.google.android.youtube:id/time_bar")
    MobileElement seekBar;

    @AndroidFindBy(xpath ="//*[@resource-id='com.andyapps.thetrailersnow:id/txt_watch_trailer']")
    MobileElement watchTrailer;

    public YoutubePage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    public String getMovieName()
    {
        String directorName=getTitle.getText();
        System.out.println(directorName);
         return directorName;
    }

    public String getDuration()
    {
        String duration = seekBar.getAttribute("content-desc").split("of")[1];
        System.out.println(duration);
        return duration;
    }



}
