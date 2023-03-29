package runner;

import pages.RegisterPage;
import utils.FactoryDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Register {

  private WebDriver driver;
  FactoryDriver factoryDriver;
  RegisterPage registerPage;

  @Before
  public void setup() {
    factoryDriver = new FactoryDriver();
    driver = factoryDriver.browser("chrome");
    registerPage = new RegisterPage(driver);
  }

  @Test
  public void Register() {
    driver.get("https://demo.automationtesting.in/Register.html");
    registerPage.CreateRegister();
  }

  @After
  public void TierDown() {
    driver.quit();
  }
}
