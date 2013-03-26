package ru.st.selenium.applogic1;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import ru.st.selenium.applogic.UserHelper;
import ru.st.selenium.model.User;

public class UserHelper1 extends DriverBasedHelper implements UserHelper {

  private ApplicationManager1 manager;

  public UserHelper1(ApplicationManager1 manager) {
    super(manager.getWebDriver());
    this.manager = manager;
  }

  @Override
  public void loginAs(User user) {
    driver.findElement(By.name("username"))
      .sendKeys(user.getLogin());
    driver.findElement(By.name("password"))
      .sendKeys(user.getPassword());
    driver.findElement(By.name("submit"))
      .click();
  }

  @Override
  public void logout() {
    driver.findElement(By.cssSelector("nav a[onclick $= '?logout']"))
      .click();
    wait.until(alertIsPresent()).accept();
  }

  @Override
  public boolean isLoggedIn() {
    return driver.findElements(By.cssSelector("nav")).size() > 0;
  }

  @Override
  public boolean isLoggedInAs(User user) {
    return isLoggedIn()
        && getLoggedUser().getLogin().equals(user.getLogin());
  }

  @Override
  public boolean isNotLoggedIn() {
    return driver.findElements(By.id("loginform")).size() > 0;
  }
  
  private User getLoggedUser() {
    manager.getNavigationHelper().gotoUserProfilePage();
    return new User()
      .setLogin(driver.findElement(By.name("username")).getAttribute("value"))
      .setEmail(driver.findElement(By.name("email")).getAttribute("value"))
      .setRole(new Select(driver.findElement(By.name("permission")))
        .getFirstSelectedOption().getText());
  }

}
