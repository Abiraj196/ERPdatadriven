package excelmethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xl_method {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi=new FileInputStream("D:\\data\\Book.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("Emp");
		XSSFRow row=ws.getRow(0);
		int rc=ws.getLastRowNum();
		int cc=row.getLastCellNum();
		System.out.println("no of rows in sheet"+rc+"no of columns in firstrow  "+cc);
      fi.close();
      wb.close();
	}

}
