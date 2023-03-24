package org.salesforce1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteTask extends SalesProjectSpecificMethod{

	@Test
	public void runDeleteTask() {
		//click Recently viewed drop down icon
        driver.findElement(By.xpath("//button[@title='Select a List View']")).click();
        //click recently viewed
        WebElement rv = driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]"));
        driver.executeScript("arguments[0].click();", rv);
        //click on drop down for bootcamp task and select delete
        driver.findElement(By.xpath("//li[@class='slds-button slds-button--icon-border-filled oneActionsDropDown']")).click();
        //click delete
        WebElement delete = driver.findElement(By.xpath("//div[@title='Delete']"));
	    driver.executeScript("arguments[0].click();", delete);
	    //click delete button in popup window
	    driver.findElement(By.xpath("//button[@title='Delete']")).click();
	    //verification
	    String text = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']")).getText();
	    System.out.println(text);
	    
	    	}

}
