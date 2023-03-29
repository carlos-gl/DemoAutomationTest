package runner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.DatePickerPage;
import utils.FactoryDriver;

public class DatePicker {

  private WebDriver driver;
  FactoryDriver factoryDriver;
  DatePickerPage dataPickerPage;

  @Before
  public void setup() {
    factoryDriver = new FactoryDriver();
    driver = factoryDriver.browser("chrome");
    dataPickerPage = new DatePickerPage(driver);
  }

  @Test
  public void DatePicker() {
    driver.get("https://demo.automationtesting.in/Register.html");
    dataPickerPage.FillDatePicker();
  }

  @After
  public void TierDown() {
    driver.quit();
  }
}
