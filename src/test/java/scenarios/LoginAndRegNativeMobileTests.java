package scenarios;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.util.Objects;

public class LoginAndRegNativeMobileTests extends BaseTest {
    public static String userName = RandomStringUtils.random(10,true,false) +"@gmail.com";;
    public static String password = RandomStringUtils.random(8,true,true);
    @Parameters("platformName")
    @Test(groups = {"Registration"}, description = "The  log in test")

    public void registrationNativeTest(String platformName) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("registerNewAccountBtn").click();
        getPo().getWelement("emailRegField").sendKeys(userName);
        getPo().getWelement("userRegField").sendKeys(userName);
        getPo().getWelement("passwordRegField").sendKeys(password);
        getPo().getWelement("confirmPasswordRegField").sendKeys(password);
        //for iOS need confirm agreement and one more click to hide keyboard
        if (Objects.equals(platformName, "iOS")) {
            getPo().getWelement("agreamentsBtn").click();
            getPo().getWelement("confirmRegBtn").click();
        }
        getPo().getWelement("confirmRegBtn").click();
        Assert.assertTrue(getPo().getWelement("signInBtn").isDisplayed());
        getPo().getWelement("emailField").sendKeys(userName);
        getPo().getWelement("passwordField").sendKeys(password);
        getPo().getWelement("signInBtn").click();
        Assert.assertTrue(getPo().getWelement("budgetActivityList").isDisplayed());

    }
}