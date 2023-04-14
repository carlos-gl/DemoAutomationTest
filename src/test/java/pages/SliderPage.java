package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Commands;

public class SliderPage extends Commands {

  private WebDriver driver;

  public SliderPage(WebDriver driver) {
    this.driver = driver;
  }

  public static final By linkSwitchTo = By.xpath("//a[@data-toggle='dropdown'][text()='Widgets']");
  public static final By linkFrame = By.xpath("//a[text()=' Slider ']");
  public static final By dismissButton = By.xpath("//div[@id='dismiss-button']/div/span");

  public static final By dismissButton2 = By.xpath("//div[@id='dismiss-button']/div");
  public static final By sliderBar = By.xpath("//div[@id='slider']");

  public void moveSlider() {
    click(driver, linkSwitchTo, 30);
    click(driver, linkFrame, 30);

    WebElement frame = driver.findElement(By.cssSelector("[id='aswift_2']"));
    driver.switchTo().frame(frame);

    Boolean isPresent = driver.findElements(By.cssSelector("[aria-label='Close ad']")).size() > 0;
    if (isPresent){
      closeAd2(driver, dismissButton2, 30);
    }
    else {
      closeAd(driver, dismissButton, 30,"[id='ad_iframe']");
    }

    moveSlider(driver, sliderBar, 30, 10, 0);
  }

}
