package pages;

import org.openqa.selenium.Keys;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowsePage {
  private WebDriver driver;

  // private
  // Puzzle

  private By searchField = By.xpath(".//input[@data-a-target='tw-input'][@placeholder='Search Tags']");
  // private By dropdown =
  // By.xpath(".//div[@data-test-selector='tag-search-search-content']//");
  private By puzzleCategory = By.xpath(".//p[text()='Puzzle']");
  private By searchAppliedPuzzle = By.xpath(".//button[@data-a-target='form-tag-Puzzle']");
  private By allGames = By.xpath(".//div[@class='tw-flex-wrap tw-tower tw-tower--180 tw-tower--gutter-xs']");
  private By card = By.xpath(".//div[@data-target='directory-page__card-container']");
  private By puzzleCategoryCard = By.xpath(".//button[@data-a-target='Puzzle']");
  public BrowsePage(WebDriver driver) {
    this.driver = driver;
  }

  public void findPuzzleCategory() {
    WebDriverWait wait1 = new WebDriverWait(this.driver, 2);
    wait1.until(ExpectedConditions.visibilityOfElementLocated(searchField));
    driver.findElement(searchField).click();
    driver.findElement(searchField).sendKeys("Puzzle");
    driver.findElement(searchField).sendKeys(Keys.RETURN);
    WebDriverWait wait2 = new WebDriverWait(this.driver, 10);
    wait2.until(ExpectedConditions.visibilityOfElementLocated(puzzleCategory));
    driver.findElement(puzzleCategory).click();

    WebDriverWait wait3 = new WebDriverWait(this.driver, 10);
    wait3.until(ExpectedConditions.visibilityOfElementLocated(searchAppliedPuzzle));
    List<WebElement> cards = driver.findElements(card);
    for (WebElement e : cards) {
      System.out.println(e);
      // Throws an exception, if the button Puzzle is not found 
      e.findElement(puzzleCategoryCard);
    }
  }
}
