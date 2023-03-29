package runner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.FramePage;
import utils.FactoryDriver;

public class Frame {

  private WebDriver driver;
  FactoryDriver factoryDriver;
  FramePage framePage;

  @Before
  public void setup() {
    factoryDriver = new FactoryDriver();
    driver = factoryDriver.browser("chrome");
    framePage = new FramePage(driver);
  }

  @Test
  public void Frame() {
    driver.get("https://demo.automationtesting.in/Register.html");
    framePage.FillFrame();
  }

  @After
  public void TierDown() {
    driver.quit();
  }
}
