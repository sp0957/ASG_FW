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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Q_1 {
	@Test
public String[][] readexcel() throws InvalidFormatException, IOException {
	String [][]data=null;
	
	String filepath="D:\\sahil learn\\Automation testing\\Sahilselenium\\ASG_POI.xlsx";
	 File file=new File(filepath);
	
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		Sheet sheet=workbook.getSheet("Sheet3");
	    int r_num=sheet.getPhysicalNumberOfRows();
	    System.out.println("Total NUmber of Row is.. "+r_num);
	    data=new String[r_num][];
	    for (int i = 0; i < data.length; i++) {
	    	Row row=sheet.getRow(i);
	    	int c_num=row.getPhysicalNumberOfCells();
		    System.out.println("Total NUmber of cell is.. "+c_num);

	    	data[i]=new String[c_num];
	    	for (int j = 0; j < data[i].length; j++) {
	    		 //to select a particular col
     		   Cell cell=row.getCell(j);     		   
     		   //to set cell type to string        		   
     		   cell.setCellType(CellType.STRING);
   	           //TO GET DATA FROM A PARTICULAR CELL
     		   data[i][j]=cell.getStringCellValue();
	    		
			}
			
		}
		
	
	return data;
	
	}
	
	WebDriver driver=null;
	@Test 
        public void Test() throws InvalidFormatException, IOException, InterruptedException {
//		System.setProperty("webdriver.chrome.driver",
//				"D:\\sahil learn\\Automation testing\\Sahilselenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		
		String[][] data=readexcel();
		for (int i = 0; i < data.length; i++) {
			
			
			driver=new ChromeDriver();
			driver.get("https://demo.guru99.com/test/newtours/register.php");
			Thread.sleep(2000);
			
			// Contact Information
			driver.findElement(By.name("firstName")).sendKeys(data[i+1][0]);
			driver.findElement(By.name("lastName")).sendKeys(data[i+1][1]);
         	driver.findElement(By.name("phone")).sendKeys(data[i+1][2]);
         	driver.findElement(By.name("userName")).sendKeys(data[i+1][3]);
         	Thread.sleep(2000);
         	
         	
         	//Mailing Information
         	driver.findElement(By.name("address1")).sendKeys(data[i+1][4]);
         	driver.findElement(By.name("city")).sendKeys(data[i+1][5]);
         	driver.findElement(By.name("state")).sendKeys(data[i+1][6]);
         	driver.findElement(By.name("postalCode")).sendKeys(data[i+1][7]);
         	Thread.sleep(2000);
         	
         	//select city
         	WebElement con=driver.findElement(By.xpath("//select[@name='country']"));
			Select select=new Select(con);
			select.selectByVisibleText(data[i+1][8]);
			
			System.out.println(data[i+1][8]);
			Thread.sleep(1000);
			
			
			//User Information
			driver.findElement(By.name("email")).sendKeys(data[i+1][9]);
			driver.findElement(By.name("password")).sendKeys(data[i+1][10]);
			driver.findElement(By.name("confirmPassword")).sendKeys(data[i+1][11]);
			Thread.sleep(1000);
			
			driver.findElement(By.name("submit")).click();
			Thread.sleep(3000);
		
			
		}
		
	}
}
   
