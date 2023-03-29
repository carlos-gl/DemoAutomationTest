package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Commands;

public class FramePage extends Commands {

  private WebDriver driver;
  Faker data = new Faker();

  public FramePage(WebDriver driver){
    this.driver = driver;
  }

  public static final By linkSwitchTo = By.xpath("//a[@data-toggle='dropdown'][text()='SwitchTo']");
  public static final By linkFrame = By.xpath("//a[text()='Frames']");
  public static final By dismissButton = By.xpath("//div[@id='dismiss-button']/div/span");
  public static final By dismissButton2 = By.xpath("//div[@id='dismiss-button']/div");
  public static final By iFrame = By.cssSelector("[id='singleframe']");
  public static final By inputText = By.xpath("//input[@type='text']");


  public void FillFrame(){
    click(driver, linkSwitchTo, 10);
    click(driver, linkFrame, 10);

    WebElement frame = driver.findElement(By.cssSelector("[id='aswift_2']"));
    driver.switchTo().frame(frame);

    Boolean isPresent = driver.findElements(By.cssSelector("[aria-label='Close ad']")).size() > 0;
    if (isPresent){
      closeAd2(driver, dismissButton2, 30);
    }
    else {
      closeAd(driver, dismissButton, 30,"[id='ad_iframe']");
    }
    FillDataFrame(driver, inputText, iFrame, data.name().name(), 10);
  }
}
