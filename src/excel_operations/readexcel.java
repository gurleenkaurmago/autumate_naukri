package excel_operations;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class readexcel {
	
	
	try
	{
		FileInputStream file = new FileInputStream("C:\\Users\\welcome\\Desktop\\selenium_practice1.xls");
		HSSFWorkbook work = new HSSFWorkbook(file);
		HSSFSheet sheet = work.getSheet("Sheet1");
		 int rc,cc;
		 rc = sheet.getPhysicalNumberOfRows();
		 cc = sheet.getRow(1).getPhysicalNumberOfCells();
		 
		 for(int i = 0;i<rc;i++)
		 {
			 HSSFRow row= sheet.getRow(i);
			 String Username = row.getCell(1,org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getStringCellValue();
			 String password = row.getCell(2,org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getStringCellValue();
			 
			 
			 
		 }
		 
		
	}
	catch(Exception e) {
		
	}
	

}

