package org.ffa.pages;

import org.ffa.webelements.Button;
import org.ffa.webelements.Label;
import org.ffa.webelements.TextInput;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Timeout;

import static org.ffa.framework.Wait.untilNotVisible;
import static org.ffa.framework.Wait.untilTextAppears;

public class RegisterPage extends PortalBasePage {

    @FindBy(xpath = "//button[@sw-localize='RegisterUserProfile.button.create.label']")
    private Button createAccount;

    @FindBy(xpath = "//span[@sw-error-for-name=\"'firstName'\"]")
    private Label firstNameValidation;

    @FindBy(xpath = "//span[@sw-error-for-name=\"'lastName'\"]")
    private Label lastNameValidation;

    @FindBy(xpath = "//span[@sw-error-for-name=\"'mail'\"]")
    private Label emailValidation;

    @FindBy(xpath = "//span[@sw-error-for-name=\"'password'\"]")
    private Label passwordValidation;

    @FindBy(xpath = "//span[@sw-error-for-name=\"'confirmPassword'\"]")
    private Label confirmPasswordValidation;

    @FindBy(xpath = "//input[@name='firstName']")
    private TextInput firstNameField;

    @FindBy(xpath = "//input[@name='lastName']")
    private TextInput lastNameField;

    @FindBy(xpath = "//input[@name='mail']")
    private TextInput emailField;

    @FindBy(xpath = "//input[@name='password']")
    private TextInput passwordField;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private TextInput passwordConfirmationField;

    @Timeout(1)
    @FindBy(xpath = "//span[@sw-localize='Popup.button.close.label']")
    private Button popUpCloseButton;

    @Step("Click Create Account")
    public void clickCreateAccount() {
        try {
            createAccount.click();
        } catch (Exception e) {}
    }

    @Step("Check first name validation")
    public String getFirstNameValidation() {
        return firstNameValidation.getText();
    }

    @Step("Check last name validation")
    public String getLastNameValidation() {
        return lastNameValidation.getText();
    }

    @Step("Check email validation")
    public String getEmailValidation() {
        if (popUpCloseButton.exists()) {
            untilNotVisible(inputBlocker);
            popUpCloseButton.click();
            getLogger().error("Pop up appeared!!");
        }
        getLogger().info("popap didn't appear");
        untilTextAppears(emailValidation);
        return emailValidation.getText();
    }

    @Step("Check password validation")
    public String getPasswordValidation() {
        return passwordValidation.getText();
    }

    @Step("Check Confirm Password Validation")
    public String getConfirmPasswordValidation() {
        return confirmPasswordValidation.getText();
    }

    @Step("Enter First Name")
    public void enterFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    @Step("Enter Last Name")
    public void enterLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    @Step("Clear First Name and Last Name Fields")
    public void clearFirstAndLastNameFields() {
        firstNameField.clear();
        lastNameField.clear();
    }

    @Step("Enter Email")
    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    @Step("Enter Password")
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @Step("Enter Password Confirmation")
    public void enterPasswordConfirmation(String passwordConfirmation) {
        passwordConfirmationField.clear();
        passwordConfirmationField.sendKeys(passwordConfirmation);
    }

    @Step("Clear Password Confirmation Field")
    public void clearPasswordConfirmation() {
        passwordConfirmationField.clear();
    }

    public boolean checkCreateAccountButton() {
        return createAccount.exists();
    }
}
