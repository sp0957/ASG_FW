package ALL_Question;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q_4 {
	
	public static void main(String[] args) throws InterruptedException {
	 
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://careercenter.tops-int.com/");
		
		
		driver.findElement(By.id("mobile")).sendKeys("9081812583");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("9081812583");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@id='profileDropdown']//img[@alt='User Profile Photo']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(1000);
		if (driver.getTitle().equals("TOPS Career Center - Welcome to TOPS Technologies")) {
			System.out.println("This Test Is Pass");
		} else {
			System.out.println("This Test Is Failed");
		}
		
	}

}
