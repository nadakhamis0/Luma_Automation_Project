package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
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
public class MyAccountTest {
    private final String FIRST_NAME = DataUtils.getJsonData("EditInfo", "firstname");
    private final String LAST_NAME = DataUtils.getJsonData("EditInfo", "lastname");
    private final String CURRENT_PASSWORD = DataUtils.getJsonData("EditInfo", "current_password");
    private final String NEW_PASSWORD = DataUtils.getJsonData("EditInfo", "new_password");
    private final String CONFIRM_PASSWORD = DataUtils.getJsonData("EditInfo", "confirm_new_password");
    private final String EMAIL = DataUtils.getJsonData("EditInfo", "email");
    private final String PASSWORD = DataUtils.getJsonData("EditInfo", "password");

    /*private final String FIRST_NAME = new Faker().name().firstName();
    private final String LAST_NAME = new Faker().name().lastName();
    private final String NEW_EMAIL = new Faker().internet().emailAddress();
    private final String CURRENT_PASSWORD = new Faker().internet().password(16, 20);
    private final String NEW_PASSWORD = new Faker().internet().password(16, 20);
    private final String CONFIRM_PASSWORD = new Faker().internet().password(16, 20);*/


    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        LogsUtils.info("Chrome driver is opened");
        getDriver().get(getPropertyValue("environment", "LOGIN_URL"));
        LogsUtils.info("Navigated to Login Page");
        new LoginPage(getDriver())
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .clickOnLoginButton();
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void editAccountInfoTest() throws IOException {
        new MyAccountPage(getDriver())
                .clickOnEditLink()
                .enterFirstName(FIRST_NAME)
                .enterLastName(LAST_NAME)
                .clickOnChangeEmailCheckbox()
                .clickOnChangePasswordCheckbox()
                .enterCurrentPassword(CURRENT_PASSWORD)
                .enterNewPassword(NEW_PASSWORD)
                .enterConfirmPassword(CONFIRM_PASSWORD)
                .clickOnSaveButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(new MyAccountPage(getDriver()).assertMyAccountPageTc(getPropertyValue("environment", "LOGIN_URL")));
    }

    @AfterMethod
    public void quit() {
        quitDriver();
        LogsUtils.info("Driver is closed");

    }
}
