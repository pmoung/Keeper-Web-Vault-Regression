package regression;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWebVault {
	
WebDriver driver;
	
	@Before
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://keepersecurity.com/vault/#");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
    public void tearDown() {
        driver.quit();
        System.out.println("Closed all the browsers");
    }
	
	@Test
	public void searchBottle(){
		driver.findElement(By.xpath("//*[@id=\"login-email-input\"]")).sendKeys("undercovermysticspy@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"keeperlogin\"]/div[1]/div[4]/form/div[2]/input")).sendKeys("!flapatk1");
		driver.findElement(By.xpath("//*[@id=\"keeperlogin\"]/div[1]/div[4]/form/div[4]/button")).click();
	}
	
	public static void main(String[] args) {
		TestWebVault myObj = new TestWebVault();
		myObj.invokeBrowser();
		myObj.searchBottle();
	}
}
