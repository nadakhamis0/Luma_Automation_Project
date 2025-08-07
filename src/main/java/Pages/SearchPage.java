package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private final By searchBox = By.id("search");
    private final By searchButton = By.xpath("//button[@title='Search']");
    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage enterInSearchBox(String searchText) {
        Utility.sendData(driver, searchBox, searchText);
        return this;
    }

    public SearchPage clickOnSearchButton() {
        Utility.clickingOnElement(driver, searchButton);
        return this;
    }

    public boolean assertSearchTc(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }
}
