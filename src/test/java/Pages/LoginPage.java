package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement userNameField = $("#userName");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("#login");
    private final SelenideElement newUserButton = $("#newUser");
    private final SelenideElement systemOut = $("#name");

    public LoginPage setUserNameField(String value) {
        userNameField.sendKeys(value);
        return this;
    }
    public LoginPage setPasswordField(String value) {
        passwordField.sendKeys(value);
        return this;
    }
    public RegistrationPage clickOnNewUserButton() {
        newUserButton.click();
        return new RegistrationPage();
    }
    public BookStorePage clickOnLoginButtonSuccess() {
        loginButton.click();
        return new BookStorePage();
    }
    public String clickOnLoginButtonFailed() {
        loginButton.click();
        return systemOut.shouldBe(visible, Duration.ofSeconds(6)).getText();
    }
    public LoginPage clearFields() {
        userNameField.sendKeys(Keys.CONTROL + "a");
        userNameField.sendKeys(Keys.BACK_SPACE);
        passwordField.sendKeys(Keys.CONTROL + "a");
        passwordField.sendKeys(Keys.BACK_SPACE);
        return this;
    }
}
