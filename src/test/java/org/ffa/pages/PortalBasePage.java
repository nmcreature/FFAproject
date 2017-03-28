package org.ffa.pages;

import org.ffa.webelements.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static org.ffa.framework.Wait.untilNotVisible;

public abstract class PortalBasePage extends BasePage {

    @FindBy(xpath = "//button[@sw-localize='Reader.ApplicationToolbar.createAccount.label']")
    private Button backButton;

    @FindBy(xpath = "//button[@sw-localize='Portal.ApplicationToolbar.portal.label']")
    private List<WebElement> portalButtons;

    @Step("Click Portal")
    public LoginPage clickPortal() {
        untilNotVisible(inputBlocker);
        portalButtons.get(1).click();
        return new LoginPage();
    }

    @Step("Click Back button")
    public LoginPage clickBackButton() {
        backButton.click();
        return new LoginPage();
    }
}
