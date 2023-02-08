package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pageObjects.PageObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver; // singleton
    IPageObject po;

    @Override
    public AppiumDriver getDriver() { return appiumDriver; }

    public IPageObject getPo() {
        return po;
    }

    @Parameters({"platformName", "appType", "deviceName", "udid", "browserName","app","appPackage","appActivity","bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName,
                      String appType,
                      @Optional("") String deviceName,
                      @Optional("") String udid,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId
    ) throws Exception {
        System.out.println("Before: app type - "+appType);
        setAppiumDriver(platformName, deviceName, udid, browserName, app, appPackage, appActivity, bundleId);
        setPageObject(appType, appiumDriver);

    }



    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String deviceName, String udid, String browserName,
                                 String app, String appPackage, String appActivity, String bundleId) throws UnsupportedEncodingException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // mandatory Android capabilities
        capabilities.setCapability("platformName",platformName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);

        if(app.endsWith(".apk")) capabilities.setCapability("app", (new File(app)).getAbsolutePath());

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck","true");

        // Capabilities for test of Android native app on EPAM Mobile Cloud
        capabilities.setCapability("appPackage",appPackage);
        capabilities.setCapability("appActivity",appActivity);

        // Capabilities for test of iOS native app on EPAM Mobile Cloud
        capabilities.setCapability("bundleId",bundleId);
        //if(platformName.equals("iOS")) capabilities.setCapability("automationName","XCUITest");

                String API_KEY = "MW4ivmOdZ/gE8aIK7XtMv9TxRtFDT2d6kpkmgFBTFz30vNAU72hqoQZPzbIgtzlLVGkvlvWkMlEQt0dqsYSuAcm8ybHVTHh1YAy3TSJ1RzbOMtJr5MwlCQcUywxkvD6iQ+iGlMMnpbULZQgbEVbLuGfnxj3zjI+Hht3qI+W+gEyo+NOOCKGBuC6UicjLj9/it1nDdJJPrS/rHSA99mcCqGKKm8ucmd8UPhafnM+eXPAQcgltiBz7YroER3WiByDHWqZIPeNZP+xJXdhghAXiERgQvbwDWx2kgUmmEUmYxMN2zOjXiADhNDJ4Fs8+rhaHEei4plCn0KCl5UJFRGCAv6qYmZl4lNtPzFD8wXSduj/XxEgRMCmsmjeqc9xLrIZk4jmsD7J1Cjb7bMB43iizj2uou+7QSUl4tHSH2GUNBhuFc9JCF/5pvcRRu+TcXYTi3KHUrJcQ7741WhQyS3QQgTOCx/NpFPlNAN5AOWP7dMolSLWq2tR12UteQz7a3Ds4B2ttcEzXSspzHoObO6CF12NprS+5QCgBk6VCYSD7P8MTBb0kkVxXaF9Z77QwdGn60dECbBrUEGuzAIc8no+AL2PQ0AXkGZSyHHgc8W4u45Ijmn9C3E20kuJN68djAczJwWg3iH2CGveAyQkxYIEReHfqoY7w17TvqSSwl2LC8/jYC+5kyt7wsycXtTTuKl9eDEfNQkLujzzWb2/rh50HW06+Ttw5Newu2r7sth7ZQLr6+ZnOBOXdgrwL5P7Jf9rC0raQrqrhlJGqEzegaB8J0JjvGmRX1YweBGME8QObiAclCWebgghmwvn9IFHm3PpmdlEsSmcSeb7VB+D9fLzGrxRV6QFEZtzIyrpDLdtY0Ohf6BZC3MLuVMhHmMjpUa7BFhykbk7qUiAMq3Gx0j0lzsnHoZHboBrodSnzFxyqDg";
                String APPIUM_HUB = "app.mobitru.com";
                String PROJECT_NAME = "viacheslav_shchukin";
        String token = URLEncoder.encode(API_KEY, StandardCharsets.UTF_8.name());
        try {
           appiumDriver = new AppiumDriver(new URL(format("https://%s:%s@%s/wd/hub", PROJECT_NAME, token, APPIUM_HUB)), capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }



    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        po = new PageObject(appType, appiumDriver);
    }


}
