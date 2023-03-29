package runner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.SliderPage;
import utils.FactoryDriver;

public class Slider {

  private WebDriver driver;
  FactoryDriver factoryDriver;
  SliderPage sliderPage;

  @Before
  public void setup() {
    factoryDriver = new FactoryDriver();
    driver = factoryDriver.browser("chrome");
    sliderPage = new SliderPage(driver);
  }

  @Test
  public void Slider() {
    driver.get("https://demo.automationtesting.in/Register.html");
    sliderPage.moveSlider();
  }

  @After
  public void TierDown() {
    driver.quit();
  }
}
