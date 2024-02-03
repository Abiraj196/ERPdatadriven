package extendreport;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extend_report {
WebDriver driver;
ExtentReports report;
ExtentTest logger;
@BeforeTest
public void setup()
{
	//generate path of html file
	report=new ExtentReports(".\\extentreport\\demo.html");
	driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://www.google.com/");
}
@Test
public void test()
{
	logger=report.startTest("my test case");
	logger.assignAuthor("abiraj");
	logger.assignCategory("functionak validation");
	String expected="google";
	String actual=driver.getTitle();
	if (actual.equalsIgnoreCase(expected)) {
		logger.log(LogStatus.PASS,"function are pass");
	}
	else
	{
		logger.log(LogStatus.FAIL,"function are fail");
	}
}
	@AfterTest
	public void teardown()
	{
		report.endTest(logger);
		report.flush();
		driver.quit();
		Reporter.log("success");
	}

}





