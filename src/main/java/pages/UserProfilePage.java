package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage {
    WebDriver driver;

    private By displayName = By.xpath(".//input[@data-a-target='tw-input']");
    private By securityTab = By.xpath(".//a[@data-a-target='tw-tab-link']");
    private By email = By.xpath(".//p[@data-a-target='security-email-text']");
    // private By userProfileButton = By.xpath(".//button[@data-test-selector='user-menu__toggle']");
    // private By overlay = By.xpath(
    //         ".//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__backdrop js-modal-backdrop']");

    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getEmail() {
      WebDriverWait wait = new WebDriverWait(this.driver, 2);
      driver.findElement(securityTab).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(email));
      return driver.findElement(email).getText();
    }

    public String getDisplayName() {
      WebDriverWait wait = new WebDriverWait(this.driver, 2);
      wait.until(ExpectedConditions.visibilityOfElementLocated(displayName));
        return driver.findElement(displayName).getAttribute("value");
    }
}
