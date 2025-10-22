package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WebTablesRegistrationForm {
    private final String FIRST_NAME_1 = "TestName";
    private final String FIRST_NAME_2 = "TestName2";
    private final String LAST_NAME = "TestLastName";
    private final String EMAIL = "example@ex.com";
    private final String AGE = "20";
    private final String SALARY = "1";
    private final String DEPARTMENT = "TestDep";

    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement age = $("#age");
    private final SelenideElement salary = $("#salary");
    private final SelenideElement department = $("#department");
    private final SelenideElement submit = $("#submit");

    public void setData(){
        firstName.setValue(FIRST_NAME_1);
        lastName.setValue(LAST_NAME);
        userEmail.setValue(EMAIL);
        age.setValue(AGE);
        salary.setValue(SALARY);
        department.setValue(DEPARTMENT);
    }

    public void editFirstName(){
        firstName.setValue(FIRST_NAME_2);
    }

    public WebTablesPage pushSubmitButton(){
        submit.click();
        return new WebTablesPage();
    }
}
