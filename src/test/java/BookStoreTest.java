import Pages.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookStoreTest extends BaseTest{
    private final static String BASE_URL = "https://demoqa.com";
    private final static String USER_NAME_CORRECT = "Test3";
    private final static String USER_NAME_UNCORRECT = "Test4";
    private final static String PASSWORD_CORRECT = "6285113Cc!";
    private final static String PASSWORD_UNCORRECT = "1234";

    @Test
    public void loginTest() {
        LoginPage login = new MainPage(BASE_URL)
                .clickOnBookStorePage()
                .clickOnLoginPage();
        login.setUserNameField(USER_NAME_CORRECT)
                .setPasswordField(PASSWORD_UNCORRECT);
        assertFalse(login.clickOnLoginButtonFailed().isEmpty());
        BookStorePage books = login.clearFields()
                .setUserNameField(USER_NAME_CORRECT)
                .setPasswordField(PASSWORD_CORRECT)
                .clickOnLoginButtonSuccess();
        assertTrue(books.getUserName().equals(USER_NAME_CORRECT));
    }
}
