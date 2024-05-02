import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class plus {

    @Test
    public void launchBrowser(){
        Playwright playwright = Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        Page page =browser.newPage();
        page.navigate("https://www.plusport.com/");
        String actualTitle =page.title();
        String expectedTitle ="LMS Software, E-learning en veiligheidstrainingen van PlusPort";
        assertEquals(actualTitle,expectedTitle);

    }
}
