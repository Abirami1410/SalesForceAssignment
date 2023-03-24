package org.salesforce1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateTask extends SalesProjectSpecificMethod {
	@BeforeTest           
	public void setup() {
		excelFile="CreateTaskExcel";//Excel file name
	}

	@Test(dataProvider="fetchData")
	public void runCreateTask(String sub) throws InterruptedException {
		WebElement newtaskicon = driver.findElement(By.xpath("//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']"));
        driver.executeScript("arguments[0].click();",newtaskicon);
        WebElement newtaskbutton = driver.findElement(By.xpath("//a[@title='New Task']"));
        driver.executeScript("arguments[0].click();",newtaskbutton);
        //select status button as waiting on someone else
        WebElement status = driver.findElement(By.xpath("(//a[@class='select'])[1]"));
        driver.executeScript("arguments[0].click();", status);
        WebElement status1 = driver.findElement(By.xpath("//a[@title='Waiting on someone else']"));
	    driver.executeScript("arguments[0].click();",status1);
	    driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys(sub);
	    driver.findElement(By.xpath("(//span[@class=' label bBody'])[3]")).click();
	    String text = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
	    System.out.println(text);
	    
	}

}
