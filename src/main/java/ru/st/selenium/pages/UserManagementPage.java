package ru.st.selenium.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserManagementPage extends InternalPage {

	public UserManagementPage(PageManager pages) {
		super(pages);
	}
	
	@FindBy(name = "username")
	private WebElement usernameField;
	
  @FindBy(name = "email")
  private WebElement emailField;
  
  @FindBy(name = "password")
  private WebElement passwordField;
  
  @FindBy(name = "password2")
  private WebElement password2Field;
  
  private Select permissionDropdown() {
    return new Select(driver.findElement(By.name("permission")));
  }
  
  public String getUsername() {
    return usernameField.getAttribute("value");
  }

  public UserManagementPage setUsernameField(String text) {
    usernameField.sendKeys(text);
    return this;
  }

  public String getEmail() {
    return emailField.getAttribute("value");
  }

  public UserManagementPage setEmailField(String text) {
    emailField.sendKeys(text);
    return this;
  }

  public UserManagementPage setPassword(String text) {
    passwordField.sendKeys(text);
    return this;
  }

  public UserManagementPage setPassword2(String text) {
    password2Field.sendKeys(text);
    return this;
  }

  public String getRole() {
    return permissionDropdown().getFirstSelectedOption().getText();
  }

  public UserManagementPage setRole(String text) {
    permissionDropdown().selectByVisibleText(text);
    return this;
  }

  public UserManagementPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.cssSelector("input#username")));
    wait.until(presenceOfElementLocated(By.cssSelector("div.content h3")));
    return this;
  }
}
