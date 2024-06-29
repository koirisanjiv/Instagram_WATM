package com.instagram.pageObject;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.instagram.ReUseAble.PageObject.ReUseAbleElement;
import com.instagram.pageObject.pageLocators.PL_HomePage;

public class PO_HomePage extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();

	// HOMEPAGE CONSTRUCTOR CREATION
	public PO_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	// PAGE ELEMENT LOCATORS
	@FindBy(xpath = PL_HomePage.addressTabHome)
	@CacheLookup
	WebElement tabHome;

	@FindBy(xpath = PL_HomePage.addressTabSearch)
	@CacheLookup
	WebElement tabSearch;

	@FindBy(xpath = PL_HomePage.addressTabExplore)
	@CacheLookup
	WebElement tabExplore;

	@FindBy(xpath = PL_HomePage.addressTabMessages)
	@CacheLookup
	WebElement tabMessages;

	@FindBy(xpath = PL_HomePage.addressTabCreate)
	@CacheLookup
	WebElement tabCreate;

	@FindBy(xpath = PL_HomePage.addressTabNotifications)
	@CacheLookup
	WebElement tabNotifications;

	@FindBy(xpath = PL_HomePage.addressTabReels)
	@CacheLookup
	WebElement tabReels;

	@FindBy(xpath = PL_HomePage.addressTabProfile)
	@CacheLookup
	WebElement tabProfile;

	@FindBy(xpath = PL_HomePage.addressTabMore)
	@CacheLookup
	WebElement tabMore;

	@FindBy(xpath = PL_HomePage.addressTabBtnLlogout)
	@CacheLookup
	WebElement btnLogout;

	// =========END========HOME PAGE OBJECTS=============//

	// =========START========ACTION METHODS FOR HOME PAGE OBJECTS=============//

	public void clickOntabHome() throws InterruptedException {
		try {
			tabHome.click();
			Thread.sleep(2000);
			logger.info("Clicked on the tabHome");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

	}

	public void clickOntabSearch() throws InterruptedException {
		try {
			tabSearch.click();
			Thread.sleep(2000);
			logger.info("Clicked on the tabSearch");
		} catch (Exception e) {
			logger.info(e.getCause());
		}
	}

	public void clickOntabExplore() throws InterruptedException {
		try {
			tabExplore.click();
			Thread.sleep(2000);
			logger.info("Clicked on the tabExplore");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

	}

	public void clickOntabMessages() throws InterruptedException {
		try {
			tabMessages.click();
			Thread.sleep(2000);
			logger.info("Clicked on the tabMessages");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

	}

	public void clickOntabCreate() throws InterruptedException {
		try {
			tabCreate.click();
			Thread.sleep(2000);
			logger.info("Clicked on the tabCreate");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

	}

	public void clickOntabNotifications() throws InterruptedException {
		try {
			tabNotifications.click();
			Thread.sleep(2000);
			logger.info("Clicked on the tabNotifications");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

	}

	public void clickOntabReels() throws InterruptedException {
		try {
			tabReels.click();
			Thread.sleep(2000);
			logger.info("Clicked on the tabReels");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

	}

	public void clickOntabProfile() throws InterruptedException {
		try {
			tabProfile.click();
			Thread.sleep(2000);
			logger.info("Clicked on the tabProfile");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

	}

	public void clickOntabMore() throws InterruptedException {
		try {
			tabMore.click();
			Thread.sleep(2000);
			logger.info("Clicked on the tabMore");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

	}

	public void clickOnLogout() throws InterruptedException {
		try {
			btnLogout.click();
			Thread.sleep(2000);
			logger.info("Clicked on the logout");
		} catch (Exception e) {
			logger.info(e.getCause());
		}

	}

	// =========END========ACTION METHODS FOR HOME PAGE OBJECTS=============//

	// TO LOGOUT
	public PO_LoginPage UserLogout() throws InterruptedException {
		logger.info("Method called: Logout");
		try {
			Thread.sleep(2000);
			clickOntabHome();
			clickOntabMore();
			clickOnLogout();
			Thread.sleep(1000);
			if (driver.getTitle().equals("Instagram")) {
				softAssert.assertTrue(true);
				logger.info("✅✅✅ LOGOUT DONE ...");
			} else {
				softAssert.assertTrue(false);
				logger.info("❎❎❎ LOGOUT FAILEED !!!");
			}
		} catch (Exception e) {
			logger.info("Logout Exception: " + e.getMessage());
			softAssert.assertTrue(false, "After logout it lookin for [page title: Instagram] text");
		}
		softAssert.assertAll();
		return new PO_LoginPage(driver);
	}

	// TO CHECK AI TOOLS SUB MENUS
	public PO_HomePage checkClickActionOnHomePageTabs() throws InterruptedException {
		Thread.sleep(3000);

//		clickOntabSearch();
//		Thread.sleep(1000);
//		clickOntabHome();
//		Thread.sleep(1000);
//
//		clickOntabExplore();
//		Thread.sleep(1000);
//		clickOntabHome();
//		Thread.sleep(1000);

		clickOntabMessages();
		Thread.sleep(1000);
		clickOntabHome();
		Thread.sleep(1000);
		
		clickOntabCreate();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PL_HomePage.addressCloseBtn)).click();
		clickOntabHome();
		Thread.sleep(1000);

//		clickOntabNotifications();
//		Thread.sleep(1000);
//		clickOntabHome();
//		Thread.sleep(1000);
//
//		clickOntabReels();
//		Thread.sleep(1000);
//		clickOntabHome();
//		Thread.sleep(1000);
		
		clickOntabProfile();
		Thread.sleep(1000);
		clickOntabHome();
		Thread.sleep(1000);

		return new PO_HomePage(driver);
	}

}
