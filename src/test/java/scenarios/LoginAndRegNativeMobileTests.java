package scenarios;

import data.InputData;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.BaseTest;

import static data.InputData.*;

public class LoginAndRegNativeMobileTests extends BaseTest {

    @Parameters("platformName")
    @Test(groups = {"Registration"}, description = "The  log in test",priority = 1)
    public void registrationNativeTest(String platformName) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        getPo().getWelement("registerNewAccountBtn").click();
        getPo().getWelement("emailRegField").sendKeys(userName);
        getPo().getWelement("userRegField").sendKeys(userName);
        getPo().getWelement("passwordRegField").sendKeys(password);
        getPo().getWelement("confirmPasswordRegField").sendKeys(password);
        if(platformName=="iOS"){
            getPo().getWelement("agreamentsBtn").click();
            getPo().getWelement("confirmRegBtn").click();
        }

        getPo().getWelement("confirmRegBtn").click();

        Assert.assertTrue(getPo().getWelement("signInBtn").isDisplayed());

    }
    @Test(groups = {"Registration"}, description = "The  log in test",priority = 2)
    public void loginNativeTest()throws IllegalAccessException, NoSuchFieldException, InstantiationException{
        getPo().getWelement("emailField").sendKeys(userName);
        getPo().getWelement("passwordField").sendKeys(password);
        getPo().getWelement("signInBtn").click();
        Assert.assertTrue(getPo().getWelement("budgetActivityList").isDisplayed());
    }


}