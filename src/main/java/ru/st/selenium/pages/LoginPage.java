package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class LoginPage extends AnyPage {

	public LoginPage(PageManager pages) {
		super(pages);
	}

	@FindBy(name = "username")
	private WebElement usernameField;

  @FindBy(name = "password")
  private WebElement passwordField;

  @FindBy(name = "submit")
  private WebElement submitButton;
  
  public LoginPage setUsernameField(String text) {
    usernameField.sendKeys(text);
    return this;
  }

  public LoginPage setPasswordField(String text) {
    passwordField.sendKeys(text);
    return this;
  }

  public void clickSubmitButton() {
    submitButton.click();
  }

  public LoginPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.id("loginform")));
    return this;
  }
}
