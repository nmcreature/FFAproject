package org.ffa.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.ffa.webelements.Button;
import org.ffa.webelements.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.ffa.framework.BrowserFactory.getDriver;

/**
 * Created by sokd on 3/2/17.
 */
public class StudyPage extends BasePage {
    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[1]/android.widget.Button[contains(@content-desc, \"Begin Study\")]")
    private Button beginStudy;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[2]/android.widget.Button[contains(@content-desc, \"Resume Study\")]")
    private Button resumeStudy;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[contains(@content-desc, \"Study Course\")]")
    private Button studyCourseDropDown;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[1]/android.widget.Button[contains(@content-desc, \"Course Details\")]")
    private Button courseDetailsButton;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[contains(@content-desc, \"IsdDesign Denis\")]")
    private Label activityUser;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.ListView[1]/android.view.View[2]/android.view.View[contains(@content-desc, \"Activity\")]")
    private Button activity;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[6]/android.view.View[contains(@content-desc, \"The Girl Monkey And The String Of Pearls\")]")
    private Label bookFooter;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[10]/android.view.View[contains(@content-desc, \"Details\")]")
    private Label details;

    public void tapBeginStudy() {
//        beginStudy.click();
        WebElement element = find(MobileBy.xpath("//android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[1]/android.widget.Button[contains(@content-desc, \"Begin Study\")]"));

        ((AndroidDriver) getDriver()).tap(1, element.getLocation().getX() + 200, element.getLocation().getY() + 20, 100);
    }

    public void tapResumeStudy() {
        WebElement element = find(MobileBy.xpath("//android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[1]/android.widget.Button[contains(@content-desc, \"Resume Study\")]"));

        ((AndroidDriver) getDriver()).tap(1, element.getLocation().getX() + 200, element.getLocation().getY() + 20, 100);
    }

    public boolean verifyCourseDetailsIsDisplayed() {
        return details.isDisplayed();
    }

    public boolean verifyCoursePageIsDisplayed() {
        return courseDetailsButton.isDisplayed();
    }

    public boolean verifyActivityPageIsDisplayed() {
        return activityUser.isDisplayed();
    }

    public void tapCourseDetails() {
        WebElement element = find(MobileBy.xpath("//android.webkit.WebView[1]/android.widget.ListView[2]/android.view.View[1]/android.widget.Button[contains(@content-desc, \"Course Details\")]"));
        ((AndroidDriver) getDriver()).tap(1, element.getLocation().getX() + 200, element.getLocation().getY() + 20, 100);
    }

    public void tapStudyCourseDropDown() {
        studyCourseDropDown.click();
    }

    public void selectActivity() {
        activity.click();
//        ((AndroidDriver) getDriver()).tap(1, activity.getLocation().getX() + 20, activity.getLocation().getY() + 20, 100);
    }

    public boolean verifyBookPageIsDisplayed() {
        return bookFooter.isDisplayed();
    }
}
