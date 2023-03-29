package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Commands;

public class RegisterPage extends Commands {

  private WebDriver driver;
  Faker data = new Faker();

  public RegisterPage(WebDriver driver){
    this.driver = driver;
  }

  public static final By inputFirstName = By.cssSelector("[ng-model='FirstName']");
  public static final By inputLastName = By.cssSelector("[ng-model='LastName']");
  public static final By inputAdress = By.cssSelector("[ng-model='Adress']");
  public static final By inputEmail = By.cssSelector("[ng-model='EmailAdress']");
  public static final By inputPhone = By.cssSelector("[ng-model='Phone']");
  public static final By clickGender = By.cssSelector("[ng-model='radiovalue'][value='Male']");
  public static final By clickHobbie = By.cssSelector("[id='checkbox3']");
  public static final By selectSkill = By.cssSelector("[id='Skills']");
  public static final By clickSelectCountry = By.cssSelector("[class='select2-selection select2-selection--single']");
  public static final By clickCountry = By.xpath("//span/ul/li[text()='Japan']");
  public static final By selectYear = By.cssSelector("[id='yearbox']");
  public static final By selectMonth = By.cssSelector("[ng-model='monthbox']");
  public static final By selectDay = By.cssSelector("[id='daybox']");
  public static final By inputPassword = By.cssSelector("[ng-model='Password']");
  public static final By inputSecondPassword = By.cssSelector("[id='secondpassword']");
  public static final By clickSubmit = By.cssSelector("[name='signup']");



  public void CreateRegister(){
    FillData(driver, inputFirstName, data.name().firstName(), 10);
    FillData(driver, inputLastName, data.name().lastName(), 10);
    FillData(driver, inputAdress, data.address().fullAddress(), 10);
    FillData(driver, inputEmail, data.internet().emailAddress(), 10);
    FillData(driver, inputPhone, data.phoneNumber().subscriberNumber(10), 10);
    click(driver, clickGender, 10);
    click(driver, clickHobbie, 10);
    select(driver, selectSkill, "C", 10);
    click(driver, clickSelectCountry, 10);
    click(driver, clickCountry, 10);
    select(driver, selectYear, "1999", 10);
    select(driver, selectMonth, "March", 10);
    select(driver, selectDay, "5", 10);
    String pass;
    FillData(driver, inputPassword, (pass = data.internet().password()), 10);
    FillData(driver, inputSecondPassword, pass, 10);
    moveClick(driver, clickSubmit, 10);

  }
}
