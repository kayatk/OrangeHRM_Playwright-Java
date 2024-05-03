import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeTest
    public void setUp(){
         playwright = Playwright.create();
         browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
         page = browser.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterTest
    public void tearDown(){
        page.close();
        browser.close();
        playwright.close();
    }
}
