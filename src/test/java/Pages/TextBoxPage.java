package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница TextBox сайта demoqa.com
 */
public class TextBoxPage {
    private final SelenideElement fullName = $x("//input[@id='userName']");
    private final SelenideElement email = $x("//input[@id='userEmail']");
    private final SelenideElement curAddress = $x("//textarea[@id='currentAddress']");
    private final SelenideElement permAddress = $x("//textarea[@id='permanentAddress']");
    private final SelenideElement submitButton = $x("//button[@id='submit']");

    private final ElementsCollection outputCollection = $$x("//div[@id='output']//div//p");

    public void clickAndFillFullName(String value){
        fullName.click();
        fullName.setValue(value);
    }

    public void clickAndFillEmail(String value){
        email.click();
        email.setValue(value);
    }

    public void clickAndFillCurAddress(String value){
        curAddress.click();
        curAddress.setValue(value);
    }

    public void clickAndFillPermAddress(String value){
        permAddress.click();
        permAddress.setValue(value);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public Map<String, String> getOutputValues(){
        Map<String, String> outputMap = new HashMap<>();
        for (var element : outputCollection) {
            String[] parts = element.getText().split(":", 2);
            if (parts.length == 2) {
                outputMap.put(parts[0].trim(), parts[1].trim());
            }
        }
        return outputMap;
    }

}
