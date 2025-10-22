package Pages;

import Api.Specifications;
import com.codeborne.selenide.SelenideElement;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.openqa.selenium.WebElement;
import io.restassured.RestAssured.*;

import static com.codeborne.selenide.Selenide.*;

public class BrokenLinksPage {
    private final SelenideElement validImage = $x("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/img[1]");
    private final SelenideElement invalidImage = $x("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/img[2]");
    private final SelenideElement validLink = $x("//div[contains(@class, 'col-12')]//div//a[contains(@href, 'demoqa')]");
    private final SelenideElement invalidLink = $x("//div[contains(@class, 'col-12')]//div//a[contains(@href, 'internet')]");

    public boolean isValid() {
        WebElement image = validImage.toWebElement();
        return Boolean.TRUE.equals(executeJavaScript("return arguments[0].complete && arguments[0].naturalWidth > 0;", image));
    }
    public boolean isInvalid() {
        WebElement image = invalidImage.toWebElement();
        return Boolean.FALSE.equals(executeJavaScript("return arguments[0].complete && arguments[0].naturalWidth > 0;", image));
    }
    public boolean getStatusCode200() {
        String link = validLink.getAttribute("href");
        int statusCode = RestAssured.get(link).getStatusCode();
        return statusCode == 200;
    }
    public boolean getStatusCode500() {
        String link = invalidLink.getAttribute("href");
        int statusCode = RestAssured.given(new RequestSpecBuilder()
                .build()).get(link).then().spec(Specifications.responseSpec500()).extract().statusCode();
        return statusCode == 500;
    }
}
