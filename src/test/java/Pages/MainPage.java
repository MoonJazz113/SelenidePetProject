package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement elementsHref = $x("//h5[text()='Elements']");
    private final SelenideElement formsHref = $x("//h5[text()='Forms']");
    private final SelenideElement afwHref = $x("//h5[text()='Alerts, Frame & Windows']");
    private final SelenideElement bookStoreHref = $x("//h5[text()='Book Store Application']");


    public MainPage(String url){
        Selenide.open(url);
    }

    public ElementsPage clickOnElements(){
        elementsHref.click();
        return new ElementsPage();
    }
    public FormsPage clickOnForms(){
        formsHref.click();
        return new FormsPage();
    }
    public AlertFrameWindowsPage clickOnAFW(){
        afwHref.click();
        return new AlertFrameWindowsPage();
    }
    public BookStorePage clickOnBookStorePage(){
        bookStoreHref.scrollTo();
        bookStoreHref.click();
        return new BookStorePage();
    }
}
