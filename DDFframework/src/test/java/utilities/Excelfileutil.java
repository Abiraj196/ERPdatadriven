package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelfileutil {
Workbook wb;                //classname and constructor name is equal
public  Excelfileutil(String Excelpath) throws Throwable
{
	FileInputStream fi=new FileInputStream(Excelpath);
	wb=WorkbookFactory.create(fi);
}
//method for no of rows count
public int rowcount(String sheetname)
{
	return wb.getSheet(sheetname).getLastRowNum();
	
}
//method for reading getcell data
public String getcelldata(String sheetname,int row,int coloumn)
{
	String data="";
	if (wb.getSheet(sheetname).getRow(row).getCell(coloumn).getCellType()==CellType.NUMERIC) {
		int celldata=(int) wb.getSheet(sheetname).getRow(row).getCell(coloumn).getNumericCellValue();
		data=String.valueOf(celldata);
		
	}
	else
	{
		data=wb.getSheet(sheetname).getRow(row).getCell(coloumn).getStringCellValue();
	}
	return data;
}
//method for writing result
public void setcelldata(String sheetname,int row,int coloumn,String status,String writeexcel) throws Throwable
{
	Sheet ws=wb.getSheet(sheetname);
	Row rownum=ws.getRow(row);
	Cell cell=rownum.createCell(coloumn);
	cell.setCellValue(status);
	if (status.equalsIgnoreCase("pass")) {
		
		CellStyle style=wb.createCellStyle();
		Font font=wb.createFont();
		font.setColor(IndexedColors.GREEN.getIndex());
		font.setBold(true);
		style.setFont(font);
		ws.getRow(row).getCell(coloumn).getCellStyle();
	}else if (status.equalsIgnoreCase("fail")) {
		CellStyle style=wb.createCellStyle();
		Font font=wb.createFont();
		font.setColor(IndexedColors.RED.getIndex());
		font.setBold(true);
		style.setFont(font);
		ws.getRow(row).getCell(coloumn).getCellStyle();
		
	}else if (status.equalsIgnoreCase("blocked")) {
		CellStyle style=wb.createCellStyle();
		Font font=wb.createFont();
		font.setColor(IndexedColors.BLUE.getIndex());
		font.setBold(true);
		style.setFont(font);
		ws.getRow(row).getCell(coloumn).getCellStyle();
		
	}
	
	FileOutputStream fo=new FileOutputStream(writeexcel);
wb.write(fo);
	
}
public static void main(String[] arg) throws Throwable {
	Excelfileutil xl=new Excelfileutil("D:\\Abiraj\\Live project\\DDFframework\\Fileinput\\DDF.xlsx");
	
	//count no of rows in a sheet
	int rc=xl.rowcount("Emp");
	System.out.println(rc);
	for(int i=1;i>=rc;i++)
	{
		String fname=xl.getcelldata("Emp", i, 0);
		String mname=xl.getcelldata("Emp", i, 1);
		String lname=xl.getcelldata("Emp", i, 2);
String eid=xl.getcelldata("Emp", i, 3);
System.out.println(fname+"  "+mname+"  "+lname+"  "+eid);
xl.setcelldata("Emp", i, 4, "pass", "D:\\Fileoutput\\result.xlsx");
	}
	
}
}















