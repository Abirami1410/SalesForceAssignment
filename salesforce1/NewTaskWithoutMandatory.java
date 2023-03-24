package org.salesforce1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NewTaskWithoutMandatory extends SalesProjectSpecificMethod {
    @Test
	public void runNewTaskWithoutMandatory() {
		WebElement newtaskicon = driver.findElement(By.xpath("//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']"));
        driver.executeScript("arguments[0].click();",newtaskicon);
        WebElement newtaskbutton = driver.findElement(By.xpath("//a[@title='New Task']"));
        driver.executeScript("arguments[0].click();",newtaskbutton);
        driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys("SALES FORCE Automation Using Selenium");
        driver.findElement(By.xpath("//button[@title='Save']")).click();
        String text = driver.findElement(By.xpath("//span[text()='Review the errors on this page.']")).getText();
        System.out.println(text);
        String error = driver.findElement(By.xpath("//li[text()='These required fields must be completed: Subject']")).getText();
        System.out.println(error);
	}

}
