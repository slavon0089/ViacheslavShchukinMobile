package scenarios;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;

public class LoginAndRegNativeMobileTests extends BaseTest {
    public static String userName = RandomStringUtils.random(10,true,false) +"@gmail.com";;
    public static String password = RandomStringUtils.random(8,true,true);;
    @Test(groups = {"Registration"}, description = "The  log in test")

    public void registrationNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("registerNewAccountBtn").click();
        getPo().getWelement("emailRegField").sendKeys(userName);
        getPo().getWelement("userRegField").sendKeys(userName);
        getPo().getWelement("passwordRegField").sendKeys(password);
        getPo().getWelement("confirmPasswordRegField").sendKeys(password);
        getPo().getWelement("confirmRegBtn").click();
        Assert.assertTrue(getPo().getWelement("signInBtn").isDisplayed());
        getPo().getWelement("emailField").sendKeys(userName);
        getPo().getWelement("passwordField").sendKeys(userName);
        getPo().getWelement("signInBtn").click();
        Assert.assertTrue(getPo().getWelement("budgetActivityList").isDisplayed());

    }
}