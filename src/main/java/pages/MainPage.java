package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;

    private By nicknameText = By.xpath(".//h6[@data-test-selector='user-menu-dropdown__display-name']");
    private By userProfileButton = By.xpath(".//button[@data-test-selector='user-menu__toggle']");
    private By overlay = By.xpath(
            ".//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open modal__backdrop js-modal-backdrop']");
    private By profilePageButton = By.xpath(".//figure[@data-a-target='dropdown-avatar']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public UserProfilePage goToUserProfilePage() {
        driver.findElement(profilePageButton).click();
        return new UserProfilePage(driver);
    }

    public String getUsername() {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
        driver.findElement(userProfileButton).click();
        return driver.findElement(nicknameText).getText();
    }
}
