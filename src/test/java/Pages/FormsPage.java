package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FormsPage {
    private final SelenideElement practiceFormPage = $x("//div[@class='element-list collapse show']//li[@id='item-0']");

    public PracticeFormPage clickOnPracticeFormPage() {
        practiceFormPage.click();
        return new PracticeFormPage();
    }
}
