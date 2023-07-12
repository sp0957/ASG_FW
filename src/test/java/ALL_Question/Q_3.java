package ALL_Question;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STEighthPointMeasure;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Q_3 {
	
	@DataProvider(name = "sp")
	public Object[][] readExcel() throws InvalidFormatException, IOException {
		Object[][]data=null;
		String filepath="D:\\sahil learn\\Automation testing\\Sahilselenium\\ASG_POI.xlsx";
		File file=new File(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		Sheet sheet=workbook.getSheet("Sheet2");
		
		int r_num=sheet.getPhysicalNumberOfRows();
		System.out.println(r_num);
		data=new Object[r_num][];
	    for (int i = 0; i < data.length; i++) {
	    	Row row=sheet.getRow(i);
	    	int c_num=row.getPhysicalNumberOfCells();
	    	System.out.println(c_num);
	    	data[i]=new Object[c_num];
	    	
	    	for (int j = 0; j < data[i].length; j++) {
	    		Cell cell=row.getCell(j);
	    		cell.setCellType(CellType.STRING);
	    		data[i][j]=cell.getStringCellValue();
				
			}
	    			
			
		}
		
		
		return data;
	}
	WebDriver driver=null;
	@Test(dataProvider = "sp")
	public void test(String data, String keyword) throws InterruptedException {
		

    	if (keyword.equals("openbrowser")) {
    		driver=new 	ChromeDriver();	
    	}
    	else if (keyword.equals("enterurl")) {
    		driver.get(data);
    		driver.manage().window().maximize();
    		Thread.sleep(2000);
    		
    	}else if (keyword.equals("firstName")) {
    		driver.findElement(By.name("firstName")).sendKeys(data);
    		Thread.sleep(2000);
    		}
    	
    	
    	else if (keyword.equals("lastName")) {
    		driver.findElement(By.name("lastName")).sendKeys(data);
    		Thread.sleep(2000);
    	}
    	
    	
    		else if (keyword.equals("phone")) {
    			driver.findElement(By.name("phone")).sendKeys(data);
	    		Thread.sleep(2000);
    		 
    			    		}
    		else if (keyword.equals("userName")) {
    			driver.findElement(By.id("userName")).sendKeys(data);
	    		Thread.sleep(2000);
    		 
    			    		}
    		else if (keyword.equals("Email")) {
    			driver.findElement(By.id("userName")).sendKeys(data);
    			Thread.sleep(2000);
				
			}
    	
    		else if (keyword.equals("closebrowser")) {
    		driver.close();
    		
}  	
  		
} 


	}
	

