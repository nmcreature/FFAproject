package org.ffa.pages;

import org.ffa.webelements.Button;
import org.ffa.webelements.Element;
import org.ffa.webelements.TextInput;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static org.ffa.framework.WaitingConditions.textAppears;

public class ConfirmationPage extends PortalBasePage {

    @FindBy(xpath = "//div[@class='app-register-title']")
    private Element title;

    @FindBy(xpath = "//button[@sw-localize='RegisterUserProfile.button.proceed.label']")
    private Button proceed;

    @FindBy(xpath = "html/body/div/div/div[1]/div/div/div[11]/div/div[4]/div/label/span/span")
    private Element codeValidation;

    @FindBy(xpath = "//input[@name='confirmTask']")
    private TextInput codeField;

    public boolean checkTitle() {
        return title.exists();
    }

    @Step("Click Proceed Button")
    public void clickProceedButton() {
        proceed.click();
    }

    public String getCodeValidation() {
        textAppears(codeValidation);
        return codeValidation.getText();
    }

    public void enterCode(String code) {
        codeField.clear();
        codeField.sendKeys(code);
    }

}
