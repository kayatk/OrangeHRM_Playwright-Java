import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.nio.file.Paths;


public class TestBase {
    Playwright playwright;
    Browser browser;
    Page page;
    BrowserContext context;

    @BeforeTest
    public void setUp(){
         playwright = Playwright.create();
         browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
         //page = browser.newPage();
        context=browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/record")));
        page=context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterTest
    public void tearDown(){
        page.close();
        browser.close();
        playwright.close();
    }
}
