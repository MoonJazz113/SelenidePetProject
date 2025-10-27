package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class RegistrationPage {
    private final SelenideElement firstNameField = $("#firstname");
    private final SelenideElement lastNameField = $("#lastname");
    private final SelenideElement userNameField = $("#userName");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement registerButton = $("#register");
    private final SelenideElement backToLoginButton = $("#gotologin");
    private final SelenideElement passwordWarning = $("#output");

    public void setFirstNameField(String value) {
        firstNameField.sendKeys(value);
    }
    public void setLastNameField(String value) {
        lastNameField.sendKeys(value);
    }
    public void setUserNameField(String value) {
        userNameField.sendKeys(value);
    }
    public void setPasswordField(String value) {
        passwordField.sendKeys(value);
    }
    public RegistrationPage clickOnBackToLoginButton() {
        backToLoginButton.click();
        return new RegistrationPage();
    }
    public String clickOnRegisterButton() {
        registerButton.click();
        if (!passwordWarning.getText().isEmpty()) {
            return passwordWarning.getText();
        } else {
            String output = switchTo().alert().getText();
            switchTo().alert().accept();
            return output;
        }
    }
}
