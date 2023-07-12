package ALL_Question;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q_6 {
	
	
	WebDriver driver = null;

	@Before
	public void berforsetup() throws InterruptedException {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.get("https://careercenter.tops-int.com/");
		Thread.sleep(2000);
	}

	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.name("user_name")).sendKeys("9081812583");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("9081812583");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(5000);
	}

	@After
	public void aftersetup() {
		System.out.println("bye bye...");
		driver.close();
	}

}
