package excelmethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xl_method2 {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi=new FileInputStream("D:\\data\\Book.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("Emp");
		XSSFRow row=ws.getRow(1);
		int rc=ws.getLastRowNum();
		System.out.println("no of rows are"+"  "+rc);
		for(int i=1;i<=rc;i++) 
		{
			String fname=ws.getRow(i).getCell(0).getStringCellValue();
			String mname=ws.getRow(i).getCell(1).getStringCellValue();
			String lname=ws.getRow(i).getCell(2).getStringCellValue();
int eid=(int) ws.getRow(i).getCell(3).getNumericCellValue();
System.out.println(fname+" "+mname+"  "+lname+"  "+eid);
ws.getRow(i).createCell(4).setCellValue("pass");
		}	
	fi.close();
	FileOutputStream fo=new FileOutputStream("D:\\data\\result.xlsx");
	wb.write(fo);
	fo.close();
	wb.close();
	
	}

}
