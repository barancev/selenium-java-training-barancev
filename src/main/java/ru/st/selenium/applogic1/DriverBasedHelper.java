package ru.st.selenium.applogic1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverBasedHelper {

  protected WebDriver driver;
  protected WebDriverWait wait;

  public DriverBasedHelper(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
  }
  
}
