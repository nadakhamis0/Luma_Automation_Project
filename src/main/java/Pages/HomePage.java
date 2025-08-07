package Pages;

import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private static List<WebElement> allMenuSections;
    private final WebDriver driver;
    private final By Logo = By.xpath("//a[@aria-label='store logo']//img");
    private final By menuSection = By.id("ui-id-");
    private final By allProductsOnPage = By.xpath("//*[@class='product-item-info']");
    /*private final By whatsNewCategory = By.id("ui-id-3");
    private final By womenCategory = By.id("ui-id-4");
    private final By womenTopsCategory = By.id("ui-id-9");
    private final By womenTopsJacketsCategory = By.id("ui-id-11");
    private final By radiantTee = By.xpath("//div[@class='product-item-info'][1]");
    private final By breatheEasyTank = By.xpath("//div[@class='product-item-info'][2]");
    private final By argusAllWeatherTank = By.xpath("//div[@class='product-item-info'][3]");
    private final By heroHoodie = By.xpath("//div[@class='product-item-info'][4]");
    private final By fusionBackpack = By.xpath("//div[@class='product-item-info'][5]");
    private final By pushItMessengerBag = By.xpath("//div[@class='product-item-info'][6]");*/


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage clickOnLogo() {
        Utility.clickingOnElement(driver, Logo);
        return this;
    }

    public HomePage HoverOverAllPage() {
        allMenuSections = driver.findElements(menuSection);
        LogsUtils.info("Menu Section: " + allMenuSections.size());
        for (int i = 1; i <= allMenuSections.size(); i++) {
            By menuSection = By.id("ui-id-" + i + "");
            Utility.hoverOverElement(driver, menuSection);
        }
        return this;
    }

    public HomePage scrollToAllProjects() {
        Utility.scrolling(driver, allProductsOnPage);
        return this;
    }

    public boolean assertHomePageTc(String expectedValue) {
        return driver.getCurrentUrl().equals(expectedValue);
    }
}

