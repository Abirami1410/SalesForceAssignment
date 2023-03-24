package org.salesforce1;

import java.io.IOException;
import java.time.Duration;

import org.excel.ReadExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class SalesProjectSpecificMethod {
	public ChromeDriver driver;
	public ChromeOptions ch;
	public String excelFile;

	@Parameters({ "url", "username", "password" })

	@BeforeMethod
	public void Launchbrowser1(String url, String uname, String pwd) throws InterruptedException {
		ch = new ChromeOptions();
		ch.addArguments("--disable-notifications", "--remote-allow-origins=*");
		driver = new ChromeDriver(ch);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		// Click on Global Actions SVG icon
		// Click on toggle menu button
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		// Click view All
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales", Keys.ENTER);
		// Click Sales from App Launcher
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		WebElement task = driver.findElement(By.xpath("//span[text()='Tasks']"));
		driver.executeScript("arguments[0].click();", task);
	}

	@AfterMethod
	public void teardown() {
		driver.close();

	}

	@DataProvider(name = "fetchData")
	public String[][] getData() throws IOException {
		String[][] rdata = ReadExcel.readData(excelFile);
		{
			return rdata;

		}

	}

}
