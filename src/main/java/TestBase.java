import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.nio.file.Paths;
import java.util.List;


public class TestBase {
    Playwright playwright;
    Browser browser;
    Page page;
    BrowserContext context;

    @BeforeTest
    public void setUp() throws InterruptedException{
        /* playwright = Playwright.create();
         browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

         //Approach #1
         page = browser.newPage();*/

        //Approach#2
        /*
        context=browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/record")));
        page=context.newPage();*/

        //Approach #3
      /*  context=browser.newContext(new Browser.NewContextOptions().setViewportSize(1600,990));
        page=context.newPage();*/
       // page.navigate("https://opensource-demo.orangehrmlive.com/");

        //Approach #4

        browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                .setArgs(List.of("--start-maximized")));
        context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page= context.newPage();

       /* page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                .setArgs(List.of("--start-maximized"))).newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();*/




    }

    @AfterTest
    public void tearDown(){
        page.close();
        browser.close();
      //  playwright.close();
    }
}
