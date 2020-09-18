package maven.MavenProject;

import org.testng.annotations.Test;

import excelFile.Xls_Reader;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DataDrivenLogIn {
	WebDriver driver;
	
	
  @Test
  public void logIn() {
	  Xls_Reader reader = new Xls_Reader("D:/Practice_Manali/SwagLabsLogInData.xlsx");
	  int rowCount = reader.getRowCount("LogInData");
	  for(int rowNum=2; rowNum<=rowCount; rowNum++){
		  System.out.println(rowNum);
		 String userName=  reader.getCellData("LogInData", "UserName", rowNum);  
		 System.out.println(userName);
		 String password=  reader.getCellData("LogInData", "password", rowNum);
		 System.out.println(password);
		 
		 driver.findElement(By.id("user-name")).clear();
		 driver.findElement(By.id("user-name")).sendKeys(userName);
		 driver.findElement(By.id("password")).clear();
		 driver.findElement(By.id("password")).sendKeys(password);
		 
	  }
  }
  @BeforeMethod
  public void setUpBrowser() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Practice_Manali\\MavenProject\\src\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/index.html");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  }

  //@AfterMethod
  public void closeBrowser() {
	  driver.quit();
  }

}
