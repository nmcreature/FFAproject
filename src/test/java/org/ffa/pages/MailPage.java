package org.ffa.pages;

import org.ffa.framework.BrowserFactory;
import org.ffa.webelements.Element;
import org.ffa.webelements.TextInput;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static org.ffa.framework.Wait.untilVisible;

public class MailPage extends BasePage {

    @FindBy(id = "login")
    private TextInput fieldLogin;

    @FindBy(xpath = "//input[@value='Check Inbox']")
    private Element checkInbox;

    @FindBy(xpath = ".//*[@id='mailmillieu']/div[2]/p[5]")
    private Element code;

    @FindBy(xpath = "//*[@id='mailmillieu']/div[2]/p[3]")
    private Element passwordChangeCode;

    @Step("Log in to mail")
    public MailPage loginToMail(String login) {
        fieldLogin.sendKeys(login);
        checkInbox.click();
        return new MailPage();
    }

    public String getCode() {
        untilVisible(code);
        return code.getText();
    }

    @Step("Get code for change password")
    public String getPasswordChangeCode() {
        untilVisible(passwordChangeCode);
        return passwordChangeCode.getText();
    }

    public void switchToFrame() {
        BrowserFactory.getDriver().switchTo().frame("ifmail");
    }
}
