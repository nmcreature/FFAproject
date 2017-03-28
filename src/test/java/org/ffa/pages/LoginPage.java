package org.ffa.pages;

import io.appium.java_client.AppiumDriver;
import org.ffa.pages.socialPages.FacebookPage;
import org.ffa.pages.socialPages.GooglePage;
import org.ffa.pages.socialPages.TwitterPage;
import org.ffa.webelements.Button;
import org.ffa.webelements.Element;
import org.ffa.webelements.Link;
import org.ffa.webelements.TextInput;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Set;

import static org.ffa.framework.BrowserFactory.getDriver;
import static org.ffa.framework.Wait.untilNotVisible;
import static org.ffa.framework.Wait.untilTextAppears;

public class LoginPage extends ReaderBasePage {

//    public LoginPage() {
//        sleep(3000);
//        Set<String> contexts = ((AppiumDriver)getDriver()).getContextHandles();
////        for (String context : contexts) {
////            System.out.println(context);
////        }
//        for (String context : contexts) {
//            if(context.contains("CHROMIUM")) {
//                System.out.println(context);
//                ((AppiumDriver) getDriver()).context(context);
//                System.out.println("context is set");
//                break;
//            }
//        }
//    }

    @FindBy(xpath = "//button[@sw-localize='Portal.ApplicationToolbar.signIn.label']")
    private Button signIn;

    //"//input[@ng-model='loginInfo.userName']"
    @FindBy(xpath = "//android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.widget.EditText[1]")
    private TextInput loginField;

    //"//input[@ng-model='loginInfo.password']"
    @FindBy(xpath = "//android.webkit.WebView[1]//android.widget.EditText[2]")
    private TextInput passwordField;

    @FindBy(xpath = "//div[@class='sw-popup_btnBlockInner']")
    private Button signInButton;

    //"//div[@class='app-login-bttn']/button"
    @FindBy(xpath = "//android.webkit.WebView[1]//android.view.View[2]/android.widget.Button[1]")
    private Button loginButton;

    @FindBy(xpath = "//span[@sw-localize='Login.forgotpassword.label']")
    private Element forgotPassword;

    @FindBy(id = "web")
    private Link webVersion;

    @FindBy(id = "facebook")
    private Link facebook;

    @FindBy(id = "twitter")
    private Link twitter;

    @FindBy(id = "google")
    private Link google;

    @FindBy(xpath = "//span[@sw-error-for-name=\"'passwordLogin'\"]")
    private Element loginValidation;

    @FindBy(xpath = "//span[@sw-localize='Login.createaccount.label']")
    private Element createNewAccount;

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

    @Step("Click Create New Account Link")
    public RegisterPage clickCreateNewAccount() {
        untilNotVisible(overlay);
        createNewAccount.click();
        return new RegisterPage();
    }

    @Step("Click Facebook")
    public FacebookPage clickFacebook() {
        facebook.click();
        return new FacebookPage();
    }

    @Step("Click Twitter")
    public TwitterPage clickTwitter() {
        twitter.click();
        return new TwitterPage();
    }

    @Step("Click Google")
    public GooglePage clickGoogle() {
        google.click();
        return new GooglePage();
    }

    public String getLoginValidation() {
        untilTextAppears(loginValidation);
        return loginValidation.getText();
    }

    public ForgotPasswordPage clickForgotPassword() {
        untilNotVisible(overlay);
        forgotPassword.click();
        return new ForgotPasswordPage();
    }

    @Step
    public void login() {
        enterLogin("sokd@isddesign.com"); // user@irls  sokd@isddesign.com
        enterPassword("123456"); //go7y7kz37q 123456
        hideKeyboard();
        clickLogIn();
    }

    public boolean verifyLoginFieldIsDisplayed() {
        return loginField.isDisplayed();
    }

    public boolean checkWebVersion() {
        return webVersion.exists();
    }

    public boolean checkLogIn() {
        return loginField.exists();
    }
}
