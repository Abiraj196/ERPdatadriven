package propertyfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class property {
WebDriver driver;
Properties conpro;
@BeforeTest
public void setup() throws Throwable
{
	 conpro=new Properties();
	conpro.load(new FileInputStream("login.properties"));
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	driver.get(conpro.getProperty("url"));
}
@Test
public void logintest()
{
	driver.findElement(By.xpath(conpro.getProperty("objuser"))).sendKeys(conpro.getProperty("enteruser"));
	driver.findElement(By.xpath(conpro.getProperty("objpass"))).sendKeys(conpro.getProperty("enterpass"));
	driver.findElement(By.xpath(conpro.getProperty("objlogin"))).click();
	String expected="dashboard";
	String actual=driver.getCurrentUrl();
	if (actual.contains(expected)) {
       Reporter.log("login success"+"  "+expected+"  "+actual,true);
	}
	else
	{
		//capture error msg
		String errormsg=driver.findElement(By.xpath(conpro.getProperty("objmsg"))).getText();
		Reporter.log("login fail"+"   "+expected+"  "+actual,true);
	}
}
	@AfterTest
	public void end()
	{
		driver.quit();

	}


}










