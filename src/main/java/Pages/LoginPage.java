package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By email = By.id("email");
    private final By password = By.id("pass");
    private final By loginButton = By.id("send2");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public LoginPage enterEmail(String emailText) {
        Utility.sendData(driver, email, emailText);
        return this;
    }

    public LoginPage enterPassword(String passwordText) {
        Utility.sendData(driver, password, passwordText);
        return this;
    }

    public MyAccountPage clickOnLoginButton() {
        Utility.clickingOnElement(driver, loginButton);
        return new MyAccountPage(driver);
    }

    public boolean assertLoginTc(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }
}
