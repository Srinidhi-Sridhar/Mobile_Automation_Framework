package pages;

import common.utilityfunctions.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import static common.AppiumManager.mobileDriver;


import java.util.ArrayList;
import java.util.List;


public class TrailerPage extends Page {

    @AndroidFindBy(xpath = "//*[@resource-id='com.andyapps.thetrailersnow:id/genre']")
    List<MobileElement> getGenre;

    @AndroidFindBy(xpath ="//*[@resource-id ='com.andyapps.thetrailersnow:id/tv_description']")
    MobileElement getDescription;

    @AndroidFindBy(xpath ="//*[@resource-id='com.andyapps.thetrailersnow:id/action_searchable_activity']")
    MobileElement searchBar;

    @AndroidFindBy(xpath ="//*[@resource-id='com.andyapps.thetrailersnow:id/tv_cast']")
    MobileElement castDetails;

    @AndroidFindBy(xpath ="//android.widget.TextView[@resource-id='com.andyapps.thetrailersnow:id/tv_director']")
    MobileElement directorDetails;

    @AndroidFindBy(xpath ="//*[@resource-id='com.andyapps.thetrailersnow:id/tv_release']")
    MobileElement releaseDetails;

    @AndroidFindBy(xpath ="//*[@resource-id='com.andyapps.thetrailersnow:id/txt_watch_trailer']")
    MobileElement watchTrailer;

    public TrailerPage() {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    public String getDirectorName()
    {
        String directorName=directorDetails.getText().split(":")[1].trim();
        System.out.println(directorName);
         return directorName;
    }

    public String getReleaseDetails()
    {
        String releasDetails =releaseDetails.getText().split(":")[1].trim();
        System.out.println(releasDetails);
        return releasDetails;
    }

    public String getCastDetails()
    {
        String castDets =castDetails.getText().split(":")[1].trim();
        System.out.println(castDets);
        return castDets;
    }

    public void watchTrailer()
    {
        clickBy(watchTrailer);
    }

    public List<String> getGenres()
    {
      List<String> getText= new ArrayList<>();
      for(MobileElement element: getGenre)
          getText.add(element.getText());
          return getText;
    }

    public void toScroll()
    {
        if(!(checkIfDisplayed(releaseDetails)))
        {
            verticalSwipe();
        }

    }

}
