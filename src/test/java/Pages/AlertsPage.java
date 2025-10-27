package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class AlertsPage {
    private final SelenideElement alertButton = $("#alertButton");
    private final SelenideElement alertDelayButton = $("#timerAlertButton");
    private final SelenideElement alertConfirmButton = $("#confirmButton");
    private final SelenideElement alertConfirmResult = $("#confirmResult");
    private final SelenideElement alertPromptButton = $("#promtButton");
    private final SelenideElement alertPromptResult = $("#promptResult");

    public String clickOnAlertButton() {
        alertButton.click();
        String value = switchTo().alert().getText();
        switchTo().alert().accept();
        return value;
    }
    public String clickOnAlertDelayButton() {
        alertDelayButton.click();
        Selenide.sleep(6000);
        String value = switchTo().alert().getText();
        switchTo().alert().accept();
        return value;
    }
    public String clickOnAlertConfirmButton() {
        alertConfirmButton.click();
        switchTo().alert().accept();
        return alertConfirmResult.getText();
    }
    public String clickOnAlertPromptButton(String text) {
        alertPromptButton.click();
        switchTo().alert().sendKeys(text);
        switchTo().alert().accept();
        return alertPromptResult.getText();
    }
}
