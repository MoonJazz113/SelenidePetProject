package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class BookStorePage {
    private final SelenideElement loginButton = $("#login");
    private final ElementsCollection bookList = $$x("//div[@role='rowgroup'][.//div//div//img]");
    private final SelenideElement userName = $("#userName-value");

    public LoginPage clickOnLoginPage() {
        loginButton.click();
        return new LoginPage();
    }
    public String getUserName() {
        return userName.getText();
    }
}
