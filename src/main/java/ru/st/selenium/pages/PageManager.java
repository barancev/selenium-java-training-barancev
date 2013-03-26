package ru.st.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {

  private WebDriver driver;

  public LoginPage loginPage;
  public InternalPage internalPage;
  public UserProfilePage userProfilePage;
  public UserManagementPage userManagementPage;

  public PageManager(WebDriver driver) {
    this.driver = driver;
    loginPage = initElements(new LoginPage(this));
    internalPage = initElements(new InternalPage(this));
    userProfilePage = initElements(new UserProfilePage(this));
    userManagementPage = initElements(new UserManagementPage(this));
  }
  
  private <T extends Page> T initElements(T page) {
    PageFactory.initElements(driver, page);
    return page;
  }
  
  public WebDriver getWebDriver() {
    return driver;
  }

}
