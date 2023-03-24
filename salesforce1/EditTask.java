package org.salesforce1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditTask extends SalesProjectSpecificMethod {
	@BeforeTest           
	public void setup() {
		excelFile="EditTaskExcel";//Excel file name
	}

    @Test(dataProvider="fetchData")
	public void runEditTask(String ddate) throws InterruptedException {
		//click Recently viewed drop down icon
        driver.findElement(By.xpath("//button[@title='Select a List View']")).click();
        //click recently viewed
        WebElement rv = driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]"));
        driver.executeScript("arguments[0].click();", rv);
        //click on drop down for bootcamp task and select edit
        driver.findElement(By.xpath("//li[@class='slds-button slds-button--icon-border-filled oneActionsDropDown']")).click();
        //click edit
        WebElement edit = driver.findElement(By.xpath("//div[@title='Edit']"));
	    driver.executeScript("arguments[0].click();", edit);
	    //click due date
	    WebElement duedate = driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));
	    driver.executeScript("arguments[0].click();", duedate );
	    duedate.sendKeys(ddate);
	    //click priority
	    WebElement priority = driver.findElement(By.xpath("(//a[@class='select'])[2]"));
	    driver.executeScript("arguments[0].click();", priority);
	    //click low priority
	    WebElement lp = driver.findElement(By.xpath("//a[@title='Low']"));
	    driver.executeScript("arguments[0].click();", lp);
	    WebElement save = driver.findElement(By.xpath("//button[@title='Save']"));
	    driver.executeScript("arguments[0].click();", save);
	    Thread.sleep(500);
	    String text = driver.findElement(By.xpath("//div[@role='alertdialog']")).getText();
	    System.out.println(text);
	    
	  	}

}
