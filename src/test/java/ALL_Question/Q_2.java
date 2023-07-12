package ALL_Question;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q_2 {
	@DataProvider(name = "sp")
	public Object[][] readExcel() throws InvalidFormatException, IOException {
		Object[][]data=null;
		String filepath="D:\\sahil learn\\Automation testing\\Sahilselenium\\ASG_POI.xlsx";
		File file=new File(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		Sheet sheet=workbook.getSheet("Sheet1");
		
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
	public void test(String  keyword) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		if (keyword.equals("openbrowser")) {
			
			driver=new ChromeDriver();
		}
		else if (keyword.equals("enterurl")) {
			driver.get("https://www.saucedemo.com/");
			Thread.sleep(3000);
		}
		else if (keyword.equals("entername")) {
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			Thread.sleep(2000);
		}
		else if (keyword.equals("enterpassword")) {
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			 Thread.sleep(2000);
		}
		else if (keyword.equals("clicklogin")) {
			driver.findElement(By.id("login-button")).click();
			 Thread.sleep(1000);	
			 
			 
			 driver.findElement(By.id("react-burger-menu-btn")).click();
			 Thread.sleep(1000);

			 driver.findElement(By.linkText("Logout")).click();
			 Thread.sleep(1000);
		
		}
		else if (keyword.equals("closebrowser")) {
			driver.close();
		}
		
	}
}
