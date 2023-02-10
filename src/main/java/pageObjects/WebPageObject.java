package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        for (WebElement result : searchResList) {
            String text = result.getText();
            if (text.contains(search)) {
                System.out.println(text);
                return true;
            }
        }
        return false;
    }

}
