import Ext.Retry;
import Ext.RetryExtension;
import Pages.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

public class ElementsTest extends BaseTest{

    private final static String BASE_URL = "https://demoqa.com";
    private final static String FULL_NAME = "Example Name";
    private final static String EMAIL = "example@gmail.com";
    private final static String CURRENT_ADDRESS = "test current adress";
    private final static String PERMANENT_ADDRESS = "test permanent adress";

    @Test
    public void inputTestBox(){
        TextBoxPage textBoxPage = new MainPage(BASE_URL)
                .clickOnElements()
                .clickOnTextBoxPage();
        textBoxPage.clickAndFillFullName(FULL_NAME);
        textBoxPage.clickAndFillEmail(EMAIL);
        textBoxPage.clickAndFillCurAddress(CURRENT_ADDRESS);
        textBoxPage.clickAndFillPermAddress(PERMANENT_ADDRESS);
        textBoxPage.clickSubmitButton();
        Map<String, String> outputValues = textBoxPage.getOutputValues();

        assertTrue(outputValues.get("Name").equals(FULL_NAME));
        assertTrue(outputValues.get("Email").equals(EMAIL));
        assertTrue(outputValues.get("Current Address").equals(CURRENT_ADDRESS));
        assertTrue(outputValues.get("Permananet Address").equals(PERMANENT_ADDRESS));
    }

    @Test
    public void inputCheckbox(){
        CheckBoxPage checkBoxPage = new MainPage(BASE_URL)
                .clickOnElements()
                .clickOnCheckBoxPage();
        checkBoxPage.pushCollapseButton("Home");
        checkBoxPage.pushCollapseButton("Downloads");
        checkBoxPage.pushCheckBox("Word File.doc");
        checkBoxPage.pushCheckBox("Excel File.doc");
        checkBoxPage.getSelectedObjects().forEach(object -> System.out.println(object));
        assertTrue(checkBoxPage.getSelectedObjects().get(0).equals("downloads"));
        assertTrue(checkBoxPage.getSelectedObjects().get(1).equals("wordFile"));
        assertTrue(checkBoxPage.getSelectedObjects().get(2).equals("excelFile"));
    }

    @Test
    public void webTabletsTest(){
        WebTablesPage webTablesPage = new MainPage(BASE_URL)
                .clickOnElements()
                .clickOnwebTablesPage();
        webTablesPage.pushDeleteButton(0);
        assertTrue(webTablesPage.findByFirstName("Cierra").isEmpty());

        WebTablesRegistrationForm registerPage = webTablesPage.pushAddButton();
        registerPage.setData();
        webTablesPage = registerPage.pushSubmitButton();
        assertTrue(webTablesPage.findByFirstName("TestName").isPresent());

        WebTablesRegistrationForm editPage = webTablesPage.pushEditButton(0);
        registerPage.editFirstName();
        webTablesPage = editPage.pushSubmitButton();
        assertTrue(webTablesPage.findByFirstName("TestName2").isPresent());
    }

    @Test
    @ExtendWith(RetryExtension.class)
    @Retry
    public void brokenLinksTest(){
        BrokenLinksPage brokenLinksPage = new MainPage(BASE_URL)
                .clickOnElements()
                .clickOnBrokenLinksPage();
        assertTrue(brokenLinksPage.isValid());
        assertTrue(brokenLinksPage.isInvalid());
        assertTrue(brokenLinksPage.getStatusCode200());
        assertTrue(brokenLinksPage.getStatusCode500());
    }
}
