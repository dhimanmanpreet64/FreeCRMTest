package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement comp;
	
	@FindBy(xpath = "//input[@type = 'submit' and @value ='Save']")
	WebElement saveBtn;
	
	
	////a[text()='Prabhjot Matharu']// parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']
    // we are not defining this xpath in FindBy because in future if we want to select the other values we are not able to do that
	// initializing the page objects
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	// action - feature
	public boolean verifyingContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']// parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']\r\n"
				+ "")).click();;
	}
	
	public void createNewContact(String prefix, String ft_name, String lt_name, String com_name) {
		Select select = new Select(title);// drop down concept to select the value from the drop down, select is the in-built class
	    select.selectByVisibleText(prefix);
	    
	    firstName.sendKeys(ft_name);
	    lastName.sendKeys(lt_name);
	    comp.sendKeys(com_name);
	    
	    saveBtn.click();
	    
	}


}
