package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject  {
    public WebElement getSearchField() {
        return searchField;
    }

    public void setSearchField(WebElement searchField) {
        this.searchField = searchField;
    }

    public WebElement getSearchRes() {
        return searchRes;
    }

    public void setSearchRes(WebElement searchRes) {
        this.searchRes = searchRes;
    }

    @AndroidFindBy(xpath = "//input[@name='q']")
    //@iOSFindBy(xpath = "//input[@class='gLFyf']")
    public WebElement searchField;
    @FindBy(xpath = "//button[@id='L2AGLb']")
    public WebElement cookiesBtn;

    @FindBy(xpath = "//button[@id='KByQx']")
    public WebElement downBtn;
    @FindBy(xpath = "//*[contains(text(),\"EPAM\")]")
    public WebElement searchRes;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);

    }


}
