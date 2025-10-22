package Pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement genderMale = $x("//label[@for='gender-radio-1']");
    private final SelenideElement mobile = $("#userNumber");
    private final SelenideElement dateOfBirth = $("#dateOfBirthInput");
    private final SelenideElement monthSelect = $x("//select[@class='react-datepicker__month-select']");
    private final SelenideElement yearSelect = $x("//select[@class='react-datepicker__year-select']");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesSports = $x("//label[@for='hobbies-checkbox-1']");
    private final SelenideElement hobbiesReading = $x("//label[@for='hobbies-checkbox-2']");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement statesList = $("#state");
    private final SelenideElement cityList = $("#city");
    private final SelenideElement submitButton = $("#submit");

    public void setFristName(String value) {
        firstName.click();
        firstName.setValue(value);
    }
    public void setLastName(String value) {
        lastName.click();
        lastName.setValue(value);
    }
    public void setUserEmail(String value) {
        userEmail.click();
        userEmail.setValue(value);
    }
    public void setGenderMale() {
        genderMale.click();
    }
    public void setMobile(String value) {
        mobile.click();
        mobile.setValue(value);
    }
    public void setDateOfBirth() {
        dateOfBirth.click();
        monthSelect.click();
        monthSelect.$x(".//option[text()= 'June']").click();
        yearSelect.click();
        yearSelect.$x(".//option[text()= '1996']").click();
        $$(".react-datepicker__day").findBy(text("10")).click();
    }
    public void setSubjectsInput(String value) {
        subjectsInput.click();
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();
    }
    public void setHobbies() {
        hobbiesSports.click();
        hobbiesReading.click();
    }
    public void setUploadPicture(String value) {
        File file = new File(value);
        uploadPicture.uploadFile(file);
    }
    public void setCurrentAddress(String value) {
        currentAddress.click();
        currentAddress.setValue(value);
    }
    public void clickOnStatesNCR() {
        statesList.click();
        $$x("//div[@class=' css-26l3qy-menu']//div//div").findBy(attribute("id", "react-select-3-option-0")).click();
    }
    public void clickOnStatesDelhi() {
        cityList.click();
        $$x("//div[@class=' css-26l3qy-menu']//div//div").findBy(attribute("id", "react-select-4-option-0")).click();
    }
    public void clickSubmitButton() {
        submitButton.click();
    }

}
