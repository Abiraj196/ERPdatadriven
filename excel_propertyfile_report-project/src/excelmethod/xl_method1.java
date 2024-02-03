package excelmethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xl_method1 {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi=new FileInputStream("D:\\\\data\\\\Book.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("Emp");
		XSSFRow row=ws.getRow(5);
		int rc=ws.getLastRowNum();
		System.out.println("no of rows there"+rc);
        XSSFCell c1=row.getCell(0);
        XSSFCell c2=row.getCell(1);
        XSSFCell c3=row.getCell(2);
        XSSFCell c4=row.getCell(3);
//read cell data
        String fname=c1.getStringCellValue();
        String mname=c2.getStringCellValue();
        String lname=c3.getStringCellValue();
//convert double to int
        int eid=(int) c4.getNumericCellValue();
        System.out.println(fname+" "+mname+" "+lname+" "+eid);
        fi.close();
        wb.close();
        

	}

}
