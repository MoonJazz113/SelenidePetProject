package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AlertFrameWindowsPage {
    private final SelenideElement windowsPage = $x("//div[@class='element-list collapse show']//ul//li[@id='item-0']");
    private final SelenideElement alertsPage = $x("//div[@class='element-list collapse show']//ul//li[@id='item-1']");

    public WindowsPage clickOnWindowsPage() {
        windowsPage.click();
        return new WindowsPage();
    }
    public AlertsPage clickOnAlertsPage() {
        alertsPage.click();
        return new AlertsPage();
    }
}
