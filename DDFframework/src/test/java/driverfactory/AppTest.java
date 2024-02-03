package driverfactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import commonfunction.Functionlibrary;
import config.Apputil;
import utilities.Excelfileutil;

public class AppTest extends Apputil {
	String inputpath ="./FileInput/DDF.xlsx";
	String outputpath ="./FileOutput/DataDrivenResults.xlsx";
	@Test
	public void startTest() throws Throwable
	{
	//create object for excelfile util class
		Excelfileutil xl = new Excelfileutil(inputpath);
		//count no of rows in login sheet
		int rc =xl.rowcount("Emp");
		Reporter.log("No of rows are::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			String user = xl.getcelldata("Emp", i, 0);
			String pass = xl.getcelldata("Emp", i, 1);
			//call adminloginmethod from functionlibaray class
			boolean res =Functionlibrary.adminLogin(user, pass);
			if(res)
			{
				//write as login success into results cell
				xl.setcelldata("Emp", i, 2, "Login Success", outputpath);
				//write as pass into status cell
				xl.setcelldata("Emp", i, 3, "Pass", outputpath);
			}
			else
			{
				//write as login Fail into results cell
				xl.setcelldata("Emp", i, 2, "Login Fail", outputpath);
				//write as Fail into status cell
				xl.setcelldata("Emp", i, 3, "Fail", outputpath);
			}
		}
	}
}
