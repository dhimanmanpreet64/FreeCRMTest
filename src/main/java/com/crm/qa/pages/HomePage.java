package com.crm.qa.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
    // page library of homepage- webElement and actions
	// page factory
	@FindBy(xpath="//td[contains(text(),'User: Manpreet Kaur')]")
	@CacheLookup // it is used to improve the scprit, fasten-up the application
	//it helps us to store this particular webelement in the cache memory(CM),
	// so everytime when we use this element , it called from the Cache memory instead of search that element on the browser
	// but if the page is refreshed, it deletes some of the elements from the CM,so it gives an error
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	  // initializing the page objects
		public HomePage() throws IOException {
		     PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyCorrertUserName() {
			return userNameLabel.isDisplayed();
			
		}
		public ContactsPage clickOnContactsLink() throws IOException {
			contactsLink.click();
			return new ContactsPage();
			
		}
		
		public DealsPage clickOnDealsLink() {
			dealsLink.click();
			return new DealsPage();
		}
		
		public TasksPage clickOnTasksLink() {
			tasksLink.click();
			return new TasksPage();
		}
		
		
		
		  public void clickOnNewContactLink() throws InterruptedException { 
			  Actions action = new Actions(driver);// hover concept using the action in-built class of selenium action.moveToElement(contactsLink).build().perform();
		  Thread.sleep(2000); 
		  newContactsLink.click(); 
		  }
		 
		 		
		/*
		 * public void clickOnNewContactLink() {
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * 
		 * wait.until(ExpectedConditions.visibilityOf(contactsLink));
		 * 
		 * Actions action = new Actions(driver);
		 * action.moveToElement(contactsLink).perform();
		 * 
		 * wait.until(ExpectedConditions.visibilityOf(newContactsLink));
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(newContactsLink));
		 * 
		 * newContactsLink.click(); }
		 */

}
