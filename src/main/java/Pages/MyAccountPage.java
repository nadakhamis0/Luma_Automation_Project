package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private final WebDriver driver;
    private final By editLink = By.cssSelector(".box-actions .edit");
    private final By changePasswordLink = By.linkText("Change Password");
    private final By editBillingAddressLink = By.linkText("Edit Address");
    private final By firstNameField = By.id("firstname");
    private final By lastNameField = By.id("lastname");
    private final By changeEmailCheckbox = By.xpath("//*[text()=\"Change Email\"]");
    private final By newEmailField = By.id("email");
    private final By changePasswordCheckbox = By.xpath("//*[text()=\"Change Password\"]");
    private final By currentPasswordField = By.id("current-password");
    private final By newPasswordField = By.id("password");
    private final By confirmPasswordField = By.id("password-confirmation");
    private final By saveButton = By.cssSelector("button[title='Save']");
    //private final By successMessage = By.cssSelector(".message-success.success.message");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage clickOnEditLink() {
        Utility.clickingOnElement(driver, editLink);
        return this;
    }

    public MyAccountPage clickOnChangePasswordLink() {
        Utility.clickingOnElement(driver, changePasswordCheckbox);
        return this;
    }

    public MyAccountPage clickOnEditBillingAddressLink() {
        Utility.clickingOnElement(driver, editBillingAddressLink);
        return this;
    }

    public MyAccountPage enterFirstName(String firstNameText) {
        Utility.sendData(driver, firstNameField, firstNameText);
        return this;
    }

    public MyAccountPage enterLastName(String lastNameText) {
        Utility.sendData(driver, lastNameField, lastNameText);
        return this;
    }

    public MyAccountPage clickOnChangeEmailCheckbox() {
        Utility.clickingOnElement(driver, changeEmailCheckbox);
        return this;
    }

    public MyAccountPage enterNewEmail(String newEmailText) {
        Utility.sendData(driver, newEmailField, newEmailText);
        return this;
    }

    public MyAccountPage clickOnChangePasswordCheckbox() {
        Utility.clickingOnElement(driver, changePasswordCheckbox);
        return this;
    }


    public MyAccountPage enterCurrentPassword(String currentPasswordText) {
        Utility.sendData(driver, currentPasswordField, currentPasswordText);
        return this;
    }

    public MyAccountPage enterNewPassword(String newPasswordText) {
        Utility.sendData(driver, newPasswordField, newPasswordText);
        return this;
    }

    public MyAccountPage enterConfirmPassword(String confirmPasswordText) {
        Utility.sendData(driver, confirmPasswordField, confirmPasswordText);
        return this;
    }

    public LoginPage clickOnSaveButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Utility.clickingOnElement(driver, saveButton);
        return new LoginPage(driver);
    }

    /*public String getSuccessMessage() {
        Utility.waitForElementTOBeVisible(driver, successMessage);
        return Utility.getText(driver, successMessage);
     */

    public boolean assertMyAccountPageTc(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }
}
