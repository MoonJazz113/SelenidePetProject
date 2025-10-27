import Pages.AlertsPage;
import Pages.MainPage;
import Pages.WindowsPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertFrameWindowsTest extends BaseTest{
    private final static String BASE_URL = "https://demoqa.com";
    private final static String PAGE_TEXT = "This is a sample page";
    private final static String ALERT_TEXT = "You clicked a button";
    private final static String ALERTDELAY_TEXT = "This alert appeared after 5 seconds";
    private final static String ALERT_CONFIRM_RESULT = "You selected Ok";
    private final static String ALERT_PROMPT = "test";
    private final static String ALERT_PROMPT_RESULT = "You entered test";

    @Test
    public void windowsTest() {
        WindowsPage windowsPage = new MainPage(BASE_URL)
                .clickOnAFW()
                .clickOnWindowsPage();
        assertEquals(PAGE_TEXT, windowsPage.clickOnNewTabButton());
        assertEquals(PAGE_TEXT, windowsPage.clickOnNewWindowTabButton());
    }

    @Test
    public void alertsTest() {
        AlertsPage alertsPage = new MainPage(BASE_URL)
                .clickOnAFW()
                .clickOnAlertsPage();
        assertEquals(alertsPage.clickOnAlertButton(), ALERT_TEXT);
        assertEquals(alertsPage.clickOnAlertDelayButton(), ALERTDELAY_TEXT);
        assertEquals(alertsPage.clickOnAlertConfirmButton(), ALERT_CONFIRM_RESULT);
        assertEquals(alertsPage.clickOnAlertPromptButton(ALERT_PROMPT), ALERT_PROMPT_RESULT);
    }
}
