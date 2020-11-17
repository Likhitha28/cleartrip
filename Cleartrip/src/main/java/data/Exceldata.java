package data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Exceldata {

	WebDriver driver;
	public Exceldata(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public static  String getCellValue(String sheetname,int rowNum,int cellNum) throws IOException
	{

		FileInputStream excelfile= new FileInputStream("C:\\Users\\845050\\eclipse-maven\\Cleartrip\\src\\main\\java\\data\\Exceldata.java");
			@SuppressWarnings("resource")
			XSSFWorkbook workbook= new XSSFWorkbook(excelfile);
			XSSFSheet sheet=workbook.getSheet(sheetname);
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell= row.getCell(cellNum);
		    return cell.getStringCellValue();
	}


}
