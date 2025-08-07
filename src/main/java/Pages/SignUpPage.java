package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private final WebDriver driver;
    private final By FirstName = By.id("firstname");
    private final By LastName = By.id("lastname");
    private final By Email = By.id("email_address");
    private final By Password = By.id("password");
    private final By ConfirmPassword = By.id("password-confirmation");
    private final By CreateAccountButton = By.xpath("//button[@title='Create an Account']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage enterFirstName(String firstnameText) {
        Utility.sendData(driver, FirstName, firstnameText);
        return this;
    }

    public SignUpPage enterLastName(String lastnameText) {
        Utility.sendData(driver, LastName, lastnameText);
        return this;
    }

    public SignUpPage enterEmail(String emailText) {
        Utility.sendData(driver, Email, emailText);
        return this;
    }

    public SignUpPage enterPassword(String passwordText) {
        Utility.sendData(driver, Password, passwordText);
        return this;
    }

    public SignUpPage enterConfirmPassword(String confirmpasswordText) {
        Utility.sendData(driver, ConfirmPassword, confirmpasswordText);
        return this;
    }

    public MyAccountPage clickOnCreateAccountButton() {
        Utility.clickingOnElement(driver, CreateAccountButton);
        return new MyAccountPage(driver);
    }

    public boolean assertSignUpTc(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }
}

