package Pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Condition.be;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class WindowsPage {
    private final SelenideElement newTabButton = $("#tabButton");
    private final SelenideElement newWindowTabButton = $("#windowButton");

    public String clickOnNewTabButton() {
        newTabButton.click();
        Selenide.switchTo().window(1);
        String value = $("h1").getText();
        closeWindow();
        switchTo().window(0);
        return value;
    }
    public String clickOnNewWindowTabButton() {
        newWindowTabButton.click();
        Selenide.switchTo().window(1);
        String value = $("h1").getText();
        closeWindow();
        switchTo().window(0);
        return value;
    }
}
