package com.instagram.pageObject;

import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.instagram.ReUseAble.PageObject.ReUseAbleElement;
import com.instagram.pageObject.pageLocators.PL_HomePage;
import com.instagram.pageObject.pageLocators.PL_LoginPage;

public class PO_LoginPage extends ReUseAbleElement {

	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();

	public PO_LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action = new Actions(driver);
	}

	// to find page elements
	@FindBy(xpath = PL_LoginPage.address_textemail)
	@CacheLookup
	WebElement textemail;

	@FindBy(xpath = PL_LoginPage.address_textpassword)
	@CacheLookup
	WebElement textpassword;

	@FindBy(xpath = PL_LoginPage.address_btnSignIn)
	@CacheLookup
	WebElement btnSignIn;

	@FindBy(xpath = PL_LoginPage.address_btnInstagramLogo)
	@CacheLookup
	WebElement btnInstagramLogo;

	// TO SET THE USERNAME/EMAIL AND WAIT TILL IS IS NOT APPERS MAX WAIT TIME(30
	// SECONDS)
	public void setUserName(String email) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(textemail));
		textemail.sendKeys(Keys.CONTROL, "a");
		textemail.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textemail.sendKeys(email);
		logger.info("Enteterd email");
		Thread.sleep(200);
	}

	// TO SET THE PASSWORD
	public void setPassword(String password) throws InterruptedException {
		textpassword.sendKeys(Keys.CONTROL, "a");
		textpassword.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		textpassword.sendKeys(password);
		logger.info("Entered password");
		Thread.sleep(200);
	}

	// TO CLICK ON THE SUBMIT BUTTON
	public void clickBtnsubmit() throws InterruptedException {
		btnSignIn.click();
		logger.info("clicke on login submit button");
		Thread.sleep(200);
	}

	public boolean isLoginSuccessful() {
		boolean isLoginDone = false;
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PL_HomePage.addressTabHome)));
			logger.info("1");
			isLoginDone = driver.findElement(By.xpath(PL_HomePage.addressTabHome)).isDisplayed();
			logger.info("isLoginDone: "+isLoginDone);
			
		} catch (Exception e) {logger.info("Exception>>isLoginSuccessful: "+e.getMessage());}
		return isLoginDone;
	}

	// FOR USER LOGIN
	public PO_HomePage Login(String userEmail, String userPassword) throws InterruptedException {
		try {
			logger.info("Method called Login: Login");

			setUserName(userEmail);
			setPassword(userPassword);
			clickBtnsubmit();

			if (isLoginSuccessful()) {
				softAssert.assertTrue(true);
				logger.info("✅✅✅ Login DONE ...");
			} else {
				softAssert.assertTrue(false);
				logger.info("❎❎❎ Login FAILEED !!!");
			}

		} catch (Exception e) {
		}
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}

}
