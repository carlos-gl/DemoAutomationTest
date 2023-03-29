package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Commands;

public class DatePickerPage extends Commands {

  private WebDriver driver;

  public DatePickerPage(WebDriver driver){
    this.driver = driver;
  }

  public static final By linkWidgets = By.xpath("//a[@data-toggle='dropdown'][text()='Widgets']");
  public static final By linkDataPicker = By.xpath("//a[text()=' Datepicker ']");
  public static final By dismissButton = By.xpath("//div[@id='dismiss-button']/div/span");
  public static final By dismissButton2 = By.xpath("//div[@id='dismiss-button']/div");
  public static final By inputDate = By.cssSelector("[id='datepicker1']");
  public static final By spanMonth = By.cssSelector("[class='ui-datepicker-month']");
  public static final By spanYear = By.cssSelector("[class='ui-datepicker-year']");
  public static final By nextButton = By.cssSelector("[class='ui-icon ui-icon-circle-triangle-w']");
  public static final By day = By.xpath("//a[text()='5']");
  public static final By inputDate2 = By.cssSelector("[id='datepicker2']");
  public void FillDatePicker(){
    click(driver, linkWidgets, 10);
    click(driver, linkDataPicker, 10);
    WebElement frame = driver.findElement(By.cssSelector("[id='aswift_2']"));
    driver.switchTo().frame(frame);

    Boolean isPresent = driver.findElements(By.cssSelector("[aria-label='Close ad']")).size() > 0;
    if (isPresent){
      closeAd2(driver, dismissButton2, 30);
    }
    else {
      closeAd(driver, dismissButton, 30,"[id='ad_iframe']");
    }
    FillDate(driver, inputDate, 30, spanMonth, spanYear, nextButton);
    click(driver, day, 10);
    FillData(driver, inputDate2, "03/05/1999", 10);
  }

}
