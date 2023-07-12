package ALL_Question;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q_5 {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.linkText("हिन्दी")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("email")).sendKeys("sahildhorajiya1@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("pass")).sendKeys("**********");
		Thread.sleep(1000);
		driver.findElement(By.linkText("English (UK)")).click();
		Thread.sleep(1000);
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
