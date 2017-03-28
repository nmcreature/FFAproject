package org.ffa.pages;

import org.ffa.webelements.Button;
import org.ffa.webelements.Element;
import org.ffa.webelements.TextInput;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static org.ffa.framework.Wait.untilNotVisible;
import static org.ffa.framework.Wait.untilTextAppears;
import static org.ffa.framework.WaitingConditions.elementToBeClickable;

public class ForgotPasswordPage extends PortalBasePage {

    @FindBy(xpath = "//input[@name='email']")
    private TextInput emailField;

    @FindBy(xpath = "//button[@sw-localize='ResetPassword.button.proceed.label']")
    private Button proceed;

    @FindBy(xpath = "//input[@ng-model='resetPasswordInfo.taskConfirmationHashCode']")
    private TextInput codeField;

    @FindBy(xpath = "//span[@class='sw-validation-error ng-binding']")
    private Element emailValidation;

    @FindBy(xpath = "//button[@sw-localize='ResetPassword.button.confirm.label']")
    private Button confirm;

    @FindBy(xpath = "//button[@sw-localize='ResetPassword.button.changepassword.label']")
    private Button changePassword;

    @FindBy(xpath = "//span[@sw-error-for-name=\"'password'\"]")
    private Element newPassValidation;

    @FindBy(xpath = "//span[@sw-error-for-name=\"'confirmPassword'\"]")
    private Element confirmPassValidation;

    @FindBy(xpath = "//input[@name='password']")
    private TextInput newPassField;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private TextInput confirmPassField;

    @Step("Enter email")
    public void enterEmail(String email) {
        untilNotVisible(inputBlocker);
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    @Step("Click Proceed")
    public ForgotPasswordPage clickProceed() {
        proceed.click();
        return new ForgotPasswordPage();
    }

    public boolean checkCodeConfirmField() {
        return codeField.exists();
    }

    @Step("Check email validation")
    public String getEmailValidation() {
        untilTextAppears(emailValidation);
        return emailValidation.getText();
    }

    @Step("Enter code")
    public void enterCode(String code) {
        codeField.sendKeys(code);
    }

    @Step("Click Confirm")
    public ForgotPasswordPage clickConfirm() {
        elementToBeClickable(confirm);
        confirm.click();
        return new ForgotPasswordPage();
    }

    @Step("Click Change Password")
    public ForgotPasswordPage clickChangePassword() {
        changePassword.click();
        return new ForgotPasswordPage();
    }

    @Step("Check new password validation")
    public String getNewPasswordValidation() {
        untilTextAppears(newPassValidation);
        return newPassValidation.getText();
    }

    @Step("Check Confirm validation")
    public boolean checkConfirmValidation(String str1, String str2) {
        untilTextAppears(confirmPassValidation);
        String res = confirmPassValidation.getText();
        return res.equals(str1) || res.equals(str2);
    }

    @Step("Check Confirm Password validation")
    public String getConfirmPasswordValidation() {
        untilTextAppears(confirmPassValidation);
        return confirmPassValidation.getText();
    }

    @Step("Enter Password")
    public void enterNewPassword(String pass) {
        newPassField.click();
        newPassField.clear();
        newPassField.sendKeys(pass);
    }

    @Step("Enter Confirm Password")
    public void enterConfirmPass(String pass) {
        confirmPassField.click();
        newPassField.clear();
        confirmPassField.sendKeys(pass);
    }

    @Step("Check Forgot Password Page is opened")
    public boolean checkProceedButton() {
        return proceed.exists();
    }

}
