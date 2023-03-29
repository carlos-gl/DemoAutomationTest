package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Commands {

  public static void click(WebDriver driver, By by, int wait) {
    WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(wait)))
            .until(ExpectedConditions.elementToBeClickable(by));
    element.click();
  }

  public static void closeAd(WebDriver driver, By by, int wait, String selector1) {
    WebElement frame1 = driver.findElement(By.cssSelector(selector1));
    driver.switchTo().frame(frame1);

    WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(wait)))
            .until(ExpectedConditions.elementToBeClickable(by));

    element.click();
  }

  public static void closeAd2(WebDriver driver, By by, int wait) {

    WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(wait)))
            .until(ExpectedConditions.elementToBeClickable(by));

    element.click();
  }

  public static void moveClick(WebDriver driver, By by, int wait) {
    WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(wait)))
            .until(ExpectedConditions.elementToBeClickable(by));
    ((JavascriptExecutor) driver)
            .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    element.click();
  }

  public static void select(WebDriver driver, By by, String value, int wait) {
    WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(wait)))
            .until(ExpectedConditions.presenceOfElementLocated(by));
    Select select = new Select(element);
    select.selectByVisibleText(value);
  }

  public static void moveSlider(WebDriver driver, By by, int wait) {
    WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(wait)))
            .until(ExpectedConditions.elementToBeClickable(by));
    element.findElement(by);

    Actions action = new Actions(driver);
    action.moveToElement(element, 0, 0);
    action.clickAndHold();
    action.moveByOffset(10, 0);
    action.build().perform();
    action.click();
  }

  public WebElement FillData(WebDriver driver, By by, String value, int wait) {
    WebDriverWait _wait = new WebDriverWait(driver, Duration.ofSeconds(wait));
    _wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    WebElement element = driver.findElement(by);
    element.sendKeys(value);

    return element;
  }

  public WebElement FillDataFrame(WebDriver driver, By by, By frame, String value, int wait) {

    WebDriverWait waitFrame = new WebDriverWait(driver, Duration.ofSeconds(wait));
    waitFrame.until(ExpectedConditions.presenceOfAllElementsLocatedBy(frame));
    WebElement frame1 = driver.findElement(frame);
    driver.switchTo().frame(frame1);

    WebDriverWait _wait = new WebDriverWait(driver, Duration.ofSeconds(wait));
    _wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    WebElement element = driver.findElement(by);
    element.sendKeys(value);

    return element;
  }

  public static void FillDate(WebDriver driver, By by, int wait, By month, By year, By next) {
    WebDriverWait waitDatePicker = new WebDriverWait(driver, Duration.ofSeconds(wait));
    waitDatePicker.until(ExpectedConditions.elementToBeClickable(by));
    WebElement element = driver.findElement(by);
    element.click();

    String expectDate = "March-1999";
    String eMonth = expectDate.split("-")[0];
    String eYear = expectDate.split("-")[1];

    String monthElement = driver.findElement(month).getText().trim();
    String yearElement = driver.findElement(year).getText().trim();

    while ((!monthElement.equals(eMonth)) || (!yearElement.equals(eYear))) {
      WebElement nextElement = driver.findElement(next);
      nextElement.click();
      monthElement = driver.findElement(month).getText().trim();
      yearElement = driver.findElement(year).getText().trim();
    }
  }

}

