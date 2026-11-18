package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest  extends TestBase{
	LoginPage loginPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	HomePage homePage;
	DealsPage dealsPage;
	
	String sheetName = "Contact";
	

	public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();// object
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
	    contactsPage=homePage.clickOnContactsLink();
	    
	    
	}
	@Test(priority =1)
	public void verifyingContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyingContactsLabel(),"contacts label is missing on the contacts page");
	}
	
	@Test(priority =2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("Prabhjot Matharu");
	}
	
	@Test(priority =3)
	public void selectMutipleContactsTest() {
		contactsPage.selectContactsByName("Prabhjot Matharu");
		contactsPage.selectContactsByName("Prabhjot Singh");
	}
	// to enter the different set of datas, we need data-driven aprroach(dataproviders)

	@DataProvider 
	public Object[][] getCRMTestData() throws Exception, InvalidFormatException, IOException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		// 2-d array
	}
	
	@Test(priority =4, dataProvider = "getCRMTestData")
    public void validateCreateNewContactTest(String Title, String First_Name,String Last_Name,String Company) throws InterruptedException {
		// arguments should be same as the excel file
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(Title,First_Name, Last_Name,Company);
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}


}
