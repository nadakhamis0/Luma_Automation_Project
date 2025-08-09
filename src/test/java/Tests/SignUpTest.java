package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages.SignUpPage;
import Utilities.DataUtils;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})
public class SignUpTest {
    private final String FIRST_NAME = DataUtils.getJsonData("SignUp", "FirstName");
    private final String LAST_NAME = DataUtils.getJsonData("SignUp", "LastName");
    private final String EMAIL = DataUtils.getJsonData("SignUp", "Email");
    private final String PASSWORD = DataUtils.getJsonData("SignUp", "Password");
    private final String CONFIRM_PASSWORD = DataUtils.getJsonData("SignUp", "ConfirmPassword");


    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        getDriver().get(getPropertyValue("environment", "CreateAccount_URL"));
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void validSignUpTest() throws IOException {
        new SignUpPage(getDriver())
                .enterFirstName(FIRST_NAME)
                .enterLastName(LAST_NAME)
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .enterConfirmPassword(CONFIRM_PASSWORD)
                .clickOnCreateAccountButton();
        Utility.generalWait(getDriver());
        Assert.assertTrue(new SignUpPage(getDriver()).assertSignUpTc(getPropertyValue("environment", "MyACCOUNT_URL")));
    }


    @AfterMethod
    public void quit() {
        quitDriver();

    }
}
