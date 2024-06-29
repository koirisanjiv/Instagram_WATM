package com.instagram.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.instagram.ReUseAble.PageObject.ReUseAbleElement;
import com.instagram.pageObject.PO_HomePage;
import com.instagram.pageObject.PO_CreatePage;
import com.instagram.pageObject.PO_LoginPage;
import com.instagram.utilities.FindFileAndRename;

public class TC_CreatePost extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_CreatePost() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_LoginPage lp; // lp = LOGIN PAGE
	public PO_HomePage hp; // hp = HOME PAGE
	public Faker faker = new Faker();
	public PO_CreatePage po_cp; // MAIN USER LABLES PAGE

	// VARIABLES
	String writeYourDescriptionAndTags = "Create a cute baby";
	String aspectRatio = "4_5"; 	//["original", "1_1", "4_5", "16_9"]
	String filePath = "LeonardoAI\\1234.jpg";
	public FindFileAndRename findFileandRename = new FindFileAndRename();

	// TO GENERATE NEW POST
	@Test(priority = 1)
	public void test_GenerateImage() throws Throwable {
		po_cp = callMeBeforePerformAnyAction();
		po_cp.createNewPost(aspectRatio, writeYourDescriptionAndTags, filePath);
	}

	

	// CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_CreatePage callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver);
		hp.clickOntabHome();
		Thread.sleep(2000);
		hp.clickOntabCreate();
		Thread.sleep(4000);
		return new PO_CreatePage(driver);
	}

}
