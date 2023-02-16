package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.util.List;


public class WebPageObject {
    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchField;

    @FindBy(xpath = "//*[@id='rso']/*")
    private List<WebElement> searchResList;

    @FindBy(xpath = "//button[@id='KByQx']")
    public WebElement downPopUpBtn;
    @FindBy(xpath = "//button[@id='L2AGLb']")
    public WebElement cookiesBtn;

    @iOSXCUITFindBy(iOSClassChain  = "//XCUIElementTypeButton[@label='go']")
    public WebElement goBtn;

    public WebElement getSearchField() {
        return searchField;
    }


    public void setSearchField(WebElement searchField) {
        this.searchField = searchField;
    }

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);

    }

    public boolean isResultsContainsText(String search) {
        boolean resultContains = false;
        for (WebElement result : searchResList) {
            String text = result.getText();
            if (text.contains(search)) {
                resultContains = true;
            } else {
                return false;
            }
        }
        return resultContains;
    }

}
