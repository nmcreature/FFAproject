package org.ffa.pages.socialPages;

import org.ffa.pages.BasePage;
import org.ffa.pages.LibraryPage;
import org.ffa.webelements.Button;
import org.ffa.webelements.TextInput;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class FacebookPage extends BasePage {

    @FindBy(id = "email")
    private TextInput email;

    @FindBy(id = "pass")
    private TextInput password;

    @FindBy(id = "loginbutton")
    private Button loginButton;

    @Step("Enter email")
    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    @Step("Enter password")
    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    @Step("Click Login")
    public LibraryPage clickLogin() {
        loginButton.click();
        return new LibraryPage();
    }
}
