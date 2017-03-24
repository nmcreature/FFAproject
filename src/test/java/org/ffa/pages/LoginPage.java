package org.ffa.pages;

import org.ffa.webelements.Button;
import org.ffa.webelements.Link;
import org.ffa.webelements.TextInput;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@sw-localize='Portal.ApplicationToolbar.signIn.label']")
    private Button signIn;

    @FindBy(xpath = "//android.webkit.WebView[1]/android.widget.EditText[1]")
    private TextInput loginField;

    @FindBy(xpath = "//android.webkit.WebView[1]//android.widget.EditText[2]")
    private TextInput passwordField;

    @FindBy(xpath = "//div[@class='sw-popup_btnBlockInner']")
    private Button signInButton;

    @FindBy(xpath = "//android.webkit.WebView[1]//android.view.View[2]/android.widget.Button[1]")
    private Button loginButton;

    @FindBy(id = "web")
    private Link webVersion;

    @Step("Click Web-version")
    public void clickWebVersion() {
        webVersion.click();
    }

    @Step("Click signIn")
    public void clickSignIn() {
        signIn.click();
    }

    @Step("Enter Login")
    public void enterLogin(String login) {
        loginField.sendKeys(login);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step("Click signIn")
    public void clickSignInButton() {
        signInButton.click();
    }

    @Step("Click logIn")
    public void clickLogIn() {
        loginButton.click();
    }

    @Step("Login through Sign In button")
    public void loginThroughSignInButton() {
        clickSignIn();
        enterLogin("nalb@isddesign.com");
        enterPassword("go7y7kz37q");
        clickSignInButton();
    }

    @Step
    public void login() {
        enterLogin("user@irls"); // user@irls  sokd@isddesign.com
        enterPassword("password"); //go7y7kz37q 123456
        hideKeyboard();
        clickLogIn();
    }

    public boolean verifyLoginFieldIsDisplayed() {
        return loginField.isDisplayed();
    }
}
