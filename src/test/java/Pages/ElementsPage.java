package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ElementsPage {
    private final SelenideElement textBoxButton = $x("//div[@class='element-list collapse show']//li[@id='item-0']");
    private final SelenideElement checkBoxButton = $x("//div[@class='element-list collapse show']//li[@id='item-1']");
    private final SelenideElement webTablesButton = $x("//div[@class='element-list collapse show']//li[@id='item-3']");
    private final SelenideElement brokenLinksButton = $x("//div[@class='element-list collapse show']//li[@id='item-6']");

    public TextBoxPage clickOnTextBoxPage() {
        textBoxButton.click();
        return new TextBoxPage();
    }
    public CheckBoxPage clickOnCheckBoxPage() {
        checkBoxButton.click();
        return new CheckBoxPage();
    }
    public WebTablesPage clickOnwebTablesPage() {
        webTablesButton.click();
        return new WebTablesPage();
    }
    public BrokenLinksPage clickOnBrokenLinksPage() {
        brokenLinksButton.click();
        return new BrokenLinksPage();
    }
}
