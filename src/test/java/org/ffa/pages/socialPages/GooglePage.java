package org.ffa.pages.socialPages;

import org.ffa.pages.BasePage;
import org.ffa.pages.LibraryPage;
import org.ffa.webelements.Button;
import org.ffa.webelements.TextInput;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class GooglePage extends BasePage {

    @FindBy(id = "Email")
    private TextInput email;

    @FindBy(id = "next")
    private Button next;

    @FindBy(id = "Passwd")
    private TextInput password;

    @FindBy(id = "signIn")
    private Button signInButton;

    @Step("Enter email")
    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    @Step("Enter password")
    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    @Step("CLick Sign In")
    public LibraryPage clickSignIn() {
        signInButton.click();
        return new LibraryPage();
    }

    @Step("Click Next")
    public void clickNext() {
        next.click();
    }
}
