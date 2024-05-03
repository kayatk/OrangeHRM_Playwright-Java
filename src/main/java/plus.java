import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class plus extends TestBase {

    @Test
    public void launchBrowser(){
        //String actualTitle =page.title();
        //String expectedTitle ="OrangeHRM";
        // assertEquals(actualTitle,expectedTitle);
//        assertThat(page).hasTitle("OrangeHRM");
//        page.getByPlaceholder("Username").fill("Admin");
//        page.getByPlaceholder("Password").fill("admin123");
//        page.click("[type=\"submit\"]");
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/Dashboard.png")));
//        Locator dashboardTitle = page.locator("//h6[text()='Dashboard']");
//        dashboardTitle.isVisible();
//        assertThat(page.locator("//p[@class='oxd-userdropdown-name']")).hasText("Megha Phophalia sawalkar");
//        page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");
//        Locator chkbox =page.locator("//input[@id ='isAgeSelected']");
//        assertThat(chkbox).not().isChecked();
//        chkbox.check();
//        assertThat(chkbox).isChecked();

        //DROP DOWN

        page.navigate("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
        //Single option
        Locator drpdown = page.locator("#select-demo");
        Locator msg =page.locator("//p[contains(@class,'selected-value')]");
        drpdown.selectOption("Sunday");
        assertThat(msg).containsText("Sunday");
         drpdown.selectOption(new SelectOption().setValue("Tuesday"));
         assertThat(msg).containsText("Tuesday");
         drpdown.selectOption(new SelectOption().setIndex(3));
         assertThat(msg).containsText("Tuesday");
         //Multiple option
         Locator muldrpdown =page.locator("#multi-select");
         muldrpdown.selectOption(new String[] {"California","Florida","Ohio"});
         Locator op=muldrpdown.locator("option");
         System.out.println(op.count());
         List<String> ops =op.allInnerTexts();
        for(String i:ops){
            System.out.println(i);
        }

        //Jquery DROP DOWN
        page.navigate("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");
        Locator jdrpdwn =page.locator("//span[contains(@class,'select2-selection--single')]").first();
        jdrpdwn.click();
        Locator jopt=page.locator(".select2-results__option",new Page.LocatorOptions().setHasText("India"));
        jopt.click();
        assertThat(jdrpdwn).hasText("India");

        //Group DROP DOWN
        Locator grpDrpdwn =page.locator("#files");
        grpDrpdwn.selectOption("Ruby");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/Ruby.png")).setFullPage(true));

        //Screenshot
        //visible region
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/visibleRegion.png")));
        page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("screenshot/FullPage.png")));
        page.screenshot(new Page.ScreenshotOptions().setMask(Arrays.asList(grpDrpdwn)).setPath(Paths.get("screenshot/Masking.png")));
    }
}
