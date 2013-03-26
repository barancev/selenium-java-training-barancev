package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends AnyPage {

	public InternalPage(PageManager pages) {
		super(pages);
	}
	
  public InternalPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.cssSelector("nav")));
    return this;
  }
  
  @FindBy(css = "nav a[href $= '?go=profile']")
  private WebElement userProfileLink;

  @FindBy(css = "nav a[href $= '?go=users']")
  private WebElement userManagementLink;

  @FindBy(css = "nav a[onclick $= '?logout']")
  private WebElement logoutLink;
  
  public UserProfilePage clickUserProfilePage() {
    userProfileLink.click();
    return pages.userProfilePage;
  }

  public UserManagementPage clickUserManagementLink() {
    userManagementLink.click();
    return pages.userManagementPage;
  }
  
  public LoginPage clickLogoutLink() {
    logoutLink.click();
    wait.until(alertIsPresent()).accept();
    return pages.loginPage;
  }
}
