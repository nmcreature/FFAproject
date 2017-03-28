package org.ffa.pages.socialPages;

import org.ffa.pages.BasePage;
import org.ffa.pages.LibraryPage;
import org.ffa.webelements.Button;
import org.ffa.webelements.TextInput;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class TwitterPage extends BasePage {

    @FindBy(id = "username_or_email")
    private TextInput email;

    @FindBy(id = "password")
    private TextInput password;

    @FindBy(id = "allow")
    private Button allowButton;

    @Step("Enter email")
    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    @Step("Enter password")
    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    @Step("Click Allow")
    public LibraryPage clickAllow() {
        allowButton.click();
        return new LibraryPage();
    }

}
