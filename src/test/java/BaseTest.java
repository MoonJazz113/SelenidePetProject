import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

abstract public class BaseTest {
    @BeforeAll
    static void globalSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        String tempDir = System.getProperty("java.io.tmpdir");
        long threadId = Thread.currentThread().getId();
        options.addArguments("--user-data-dir=" + tempDir + "chrome-thread-" + threadId);

        Configuration.browserCapabilities = options;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 8000;

        Configuration.reopenBrowserOnFail = true;
        Configuration.holdBrowserOpen = false;
    }

    @BeforeEach
    public void init(){
        setUp();
    }

    @AfterAll
    public static void tearDown(){
        Selenide.closeWebDriver();
    }
}
