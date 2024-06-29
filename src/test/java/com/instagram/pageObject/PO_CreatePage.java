package com.instagram.pageObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.instagram.ReUseAble.PageObject.ReUseAbleElement;
import com.instagram.pageObject.pageLocators.PL_CreatePage;
import com.instagram.projectUtility.FindThreeDotAndClick;
import com.instagram.testCases.BaseClass;

public class PO_CreatePage extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();

	// CONSTRUCTOR CREATION
	public PO_CreatePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(150));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	// ELEMENT LOCATORES

	@FindBy(xpath = PL_CreatePage.addressBtnSelectFromComputer)
	@CacheLookup
	public WebElement btnSelectFromComputer;

	@FindBy(xpath = PL_CreatePage.addressBtnSelectCrop)
	@CacheLookup
	public WebElement btnBtnSelectCrop;

	@FindBy(xpath = PL_CreatePage.addressSelectOriginalImage)
	@CacheLookup
	public WebElement btnSelectOriginalImage;

	@FindBy(xpath = PL_CreatePage.addressSelect1_1Image)
	@CacheLookup
	public WebElement btnSelect1_1Image;

	@FindBy(xpath = PL_CreatePage.addressSelect4_5Image)
	@CacheLookup
	public WebElement btnSelect4_5Image;

	@FindBy(xpath = PL_CreatePage.addressSelect16_9Image)
	@CacheLookup
	public WebElement btnSelect16_9Image;

	@FindBy(xpath = PL_CreatePage.addressBtnShare)
	@CacheLookup
	public WebElement btnShare;

	@FindBy(xpath = PL_CreatePage.addressTextBoxWriteACaption)
	@CacheLookup
	public WebElement textBoxWriteACaption;

	@FindBy(xpath = PL_CreatePage.addressBtnCross)
	@CacheLookup
	public WebElement btnCross;

	@FindBy(xpath = PL_CreatePage.addressTextYourPostHaseBeenShared)
	@CacheLookup
	public WebElement textYourPostHaseBeenShared;

	public void clickOnBtnSelectFromComputer() throws InterruptedException {
		try {
			btnSelectFromComputer.click();
			logger.info("Click on btnSelectFromComputer");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void clickOnBtnSelectCrop() throws InterruptedException {
		try {
			btnBtnSelectCrop.click();
			logger.info("Click on btnBtnSelectCrop");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void clickOnBtnSelectOriginalImage() throws InterruptedException {
		try {
			btnSelectOriginalImage.click();
			logger.info("Click on btnSelectOriginalImage");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void clickOnBtnSelect1_1Image() throws InterruptedException {
		try {
			btnSelect1_1Image.click();
			logger.info("Click on btnSelect1_1Image");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void clickOnBtnSelect4_5Image() throws InterruptedException {
		try {
			btnSelect4_5Image.click();
			logger.info("Click on btnSelect4_5Image");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void clickOnBtnSelect16_9Image() throws InterruptedException {
		try {
			btnSelect16_9Image.click();
			logger.info("Click on btnSelect16_9Image");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public void selectPostAspectRatio(String aspectRatio) throws InterruptedException {
		switch (aspectRatio) {
		case "original": {
			clickOnBtnSelectOriginalImage();
			Thread.sleep(1000);
			break;
		}
		case "1_1": {
			clickOnBtnSelect1_1Image();
			Thread.sleep(1000);
			break;
		}
		case "4_5": {
			clickOnBtnSelect4_5Image();
			Thread.sleep(1000);
			break;
		}
		case "16_9": {
			clickOnBtnSelect16_9Image();
			Thread.sleep(1000);
			break;
		}
		}
	}

	public void clickOnBtnNext() throws InterruptedException {
		try {
			WebElement btnNext = driver.findElement(By.xpath(PL_CreatePage.addressBtnNext));
			btnNext.click();
			logger.info("Click on btnNext");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public boolean clickOnbtnShare() throws InterruptedException {
		boolean isClickOnShareBtn = false;
		try {
			WebElement btnShare = driver.findElement(By.xpath(PL_CreatePage.addressBtnShare));
			btnShare.click();
			logger.info("Click on btnShare");
			Thread.sleep(2000);
			isClickOnShareBtn = true;
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return isClickOnShareBtn;
	}

	public boolean checkIsYourPostHaseBeenShared() {
		boolean isYourPostHaseBeenShared = false;
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(textYourPostHaseBeenShared,
					"Your post has been shared."));
			if (textYourPostHaseBeenShared.isDisplayed()) {
				isYourPostHaseBeenShared = true;
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return isYourPostHaseBeenShared;
	}

	public void setWriteACatption(String yourPrompt) throws InterruptedException {
		try {
			textBoxWriteACaption.sendKeys(Keys.CONTROL, "a");
			textBoxWriteACaption.sendKeys(Keys.DELETE);
			textBoxWriteACaption.sendKeys(yourPrompt);
			Thread.sleep(2000);
			logger.info("Entered yourPrompt");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	public void clickOnBtnCross() throws InterruptedException {
		try {
			btnCross.click();
			logger.info("Click on Cross button");
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	// ======END======PAGE OBJECT FOR ADD USERS LEBELS ACTOIN METHODS==========//

	// TO GENERATE IMAGE
	public PO_CreatePage createNewPost(String aspectRatio, String writeDescriptionTags, String filePath) throws Throwable {

		StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTrace[2].getMethodName();
		logger.info("Method called createNewPost and  Caller methods name: " + callerMethodName);

		clickOnBtnSelectFromComputer();
		if(uploadFileFromSystem()){
			try {
				clickOnBtnSelectCrop();
				selectPostAspectRatio(aspectRatio);
				clickOnBtnNext();
				clickOnBtnNext();
				setWriteACatption(writeDescriptionTags);
				if(clickOnbtnShare()) {
					checkIsYourPostHaseBeenShared();
					clickOnBtnCross();
				}
			}catch(Exception e) {logger.warn("Exception from: createNewPost >> "+e.getMessage());}
		}else {
			clickOnBtnCross();
		}
		
		
		softAssert.assertAll();
		return new PO_CreatePage(driver);
	}

	// TO UPLOAD IMAGE
	public boolean uploadFileFromSystem() throws InterruptedException, IOException {
		StackTraceElement stackTrace[] = Thread.currentThread().getStackTrace();
		String callerMethodName = stackTrace[2].getMethodName();
		logger.info("Method called uploadFileFromSystem and Caller methods name: " + callerMethodName);
		boolean isfileUplaoded = false;
		try {
			// Use ProcessBuilder to execute the AutoIt executable
	        String autoItScriptPath = System.getProperty("user.dir") + "//AutoIT.exe";
	        ProcessBuilder processBuilder = new ProcessBuilder(autoItScriptPath);
	        processBuilder.directory(new File(System.getProperty("user.dir")));
	        Process process = processBuilder.start();
	        process.waitFor();
	        isfileUplaoded = true;
		}catch(Exception e) {logger.info("Exception from uploadFileFromSystem: "+e.getMessage());}
        
		softAssert.assertAll();
		return isfileUplaoded;

	}

}
