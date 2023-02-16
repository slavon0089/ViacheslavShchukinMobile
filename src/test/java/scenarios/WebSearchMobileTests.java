package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;


import static org.testng.Assert.assertTrue;

public class WebSearchMobileTests extends BaseTest {
    public static String baseURL = "http://google.com";
    public static String googleSearchText = "EPAM";

    @Test(groups = {"cloud"}, description = "Search EPAM in google")
    public void searchWebTest() throws Exception {

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        getDriver().get(baseURL); // open google homepage
        WebPageObject wpo = new WebPageObject(getDriver());

        //accept GDPR
        wpo.downPopUpBtn.click();
        wpo.downPopUpBtn.click();
        wpo.downPopUpBtn.click();
        wpo.cookiesBtn.click();

        wpo.getSearchField().sendKeys(googleSearchText);
        wpo.getSearchField().sendKeys(Keys.ENTER);
//        wpo.getSearchField().sendKeys("13");
//        wpo.getSearchField().sendKeys("\n");
//        wpo.getSearchField().sendKeys(Keys.RETURN);
//        getDriver().getKeyboard().sendKeys(Keys.RETURN);
//        getDriver().getKeyboard().sendKeys(Keys.ENTER);
//        getDriver().getKeyboard().sendKeys("13");
//        wpo.goBtn.click();

        assertTrue(wpo.isResultsContainsText(googleSearchText), "Messages in result don't match search request");

    }
}
