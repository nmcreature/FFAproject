package org.ffa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.ffa.framework.BrowserFactory;
import org.ffa.framework.Utilities;
import org.ffa.webelements.Button;
import org.ffa.webelements.Element;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static org.ffa.framework.BrowserFactory.getDriver;

public abstract class BasePage extends Utilities {

    @Timeout(1)
    @FindBy(xpath = "//div[@class='longRunningInputBlocker']")
    public Element inputBlocker;

    @Timeout(1)
    @FindBy(xpath = "//div[@class='longRunningOverlay']")
    public Element overlay;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]")
    private Button menuButton;

    public BasePage(){
        HtmlElementLoader.populatePageObject(this, getDriver());
    }

    @Step("Tap menu")
    public void tapMenu() {
        menuButton.click();
//        ((AndroidDriver) getDriver()).tap(1, 50, 50, 100);
    }

    public void tapMenuByCoordinates() {
        ((AndroidDriver) getDriver()).tap(1, 20, 20, 100);
    }

    public void swipeFromBottomToTop() {
        Dimension size = getDriver().manage().window().getSize();
        int starty = (int) (size.height * 0.80);
        int endy = (int) (size.height * 0.20);
        int startx = size.width / 2;
        sleep(200);
        ((AppiumDriver)getDriver()).swipe(startx, starty, startx, endy, 3000);
        sleep(500);
    }

    public void swipeFromBottomToTop(int times) {
        for (int i = 0; i < times; i++) {
            swipeFromBottomToTop();
        }
        sleep(2000);
        getDriver().getPageSource();
    }

    public static void hideKeyboard() {
        try {
            ((AppiumDriver) getDriver()).hideKeyboard();
        } catch (Exception e) {
        }
    }

    public void swipeToBook(String bookName) {
        int swipeTimes;
        switch (bookName) {
            case "Aesop's Fables":
            case "More Jataka Tales":
                swipeTimes = 0;
                break;
            case "Andersen's Fairy Tales":
            case "Peter Pan":
                swipeTimes = 3;
                break;
            case "Just So Stories":
                swipeTimes = 1;
                break;
            case "Tarzan of the Apes":
                swipeTimes = 7;
                break;
            case "David Crockett: His Life and Adventures":
                swipeTimes = 6;
                break;
            case "King Solomon's Mines":
            case "Candide":
                swipeTimes = 5;
                break;
            case "Narrative of the Life of Frederick Douglass":
            case "The Kreutzer Sonata":
            case "The Turn of the Screw":
                swipeTimes = 4;
                break;
            case "A Connecticut Yankee in King Arthur's Court":
                swipeTimes = 11;
                break;
            case "original":
                swipeTimes = 3;
                break;
            default:
                 swipeTimes = 0;
        }
//        if (swipeTimes > 2)
//            swipeFromBottomToTop(3);
//        sleep(1000);
        swipeFromBottomToTop(swipeTimes);
    }
}
