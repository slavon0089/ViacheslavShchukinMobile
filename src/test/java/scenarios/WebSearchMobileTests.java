package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;

import java.util.Objects;

import static data.InputData.baseURL;
import static data.InputData.googleSearchText;
import static org.testng.Assert.assertTrue;

public class WebSearchMobileTests extends BaseTest {
    @Parameters("platformName")
    @Test(groups = {"cloud"}, description = "Search EPAM in google")
    public void searchWebTest(String platformName) throws InterruptedException {

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        getDriver().get(baseURL); // open google homepage
        WebPageObject wpo = new WebPageObject(getDriver());

        //need confirm cookies in cloud
        wpo.downBtn.click();
        wpo.downBtn.click();
        wpo.downBtn.click();
        wpo.cookiesBtn.click();
        wpo.getSearchField().sendKeys(googleSearchText + Keys.ENTER);
        assertTrue(wpo.getSearchRes().isEnabled());

    }


}
