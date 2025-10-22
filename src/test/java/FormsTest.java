import Pages.MainPage;
import Pages.PracticeFormPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormsTest extends BaseTest{
    private final static String BASE_URL = "https://demoqa.com";
    private final static String IMAGE1_URL = "C:\\Users\\MoonJazz\\IdeaProjects\\SelenidePetProject\\src\\test\\resources\\files\\image1.jpg";

    private final static String NAME = "Test Name";
    private final static String EMAIL = "example@ex.com";
    private final static String NUMBER = "9129955432";
    private final static String SUBJECTS = "Math";
    private final static String ADDRESS = "test adress";


    @Test
    public void practiceFormTest() {
        PracticeFormPage practiceFormPage = new MainPage(BASE_URL)
                .clickOnForms()
                .clickOnPracticeFormPage();
        practiceFormPage.setSubjectsInput(SUBJECTS);
        practiceFormPage.setFristName(NAME);
        practiceFormPage.setLastName(NAME);
        practiceFormPage.setUserEmail(EMAIL);
        practiceFormPage.setGenderMale();
        practiceFormPage.setMobile(NUMBER);
        practiceFormPage.setDateOfBirth();
        practiceFormPage.setHobbies();
        practiceFormPage.setUploadPicture(IMAGE1_URL);
        practiceFormPage.setCurrentAddress(ADDRESS);
        practiceFormPage.clickOnStatesNCR();
        practiceFormPage.clickOnStatesDelhi();
        practiceFormPage.clickSubmitButton();
        ElementsCollection results = $$x("//tbody//tr//td[2]");

        assertTrue(results.get(0).getText().equals(NAME + " " + NAME));
        assertTrue(results.get(1).getText().equals(EMAIL));
        assertTrue(results.get(2).getText().equals("Male"));
        assertTrue(results.get(3).getText().equals("9129955432"));
        assertTrue(results.get(4).getText().equals("10 June,1996"));
        assertTrue(results.get(5).getText().equals("Maths"));
        assertTrue(results.get(6).getText().equals("Sports, Reading"));
        assertTrue(results.get(7).getText().equals("image1.jpg"));
        assertTrue(results.get(8).getText().equals(ADDRESS));
        assertTrue(results.get(9).getText().equals("NCR Delhi"));
    }
}
