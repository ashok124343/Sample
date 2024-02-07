 package ak.a1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class First {

	public static void main(String[] args) throws Throwable {
		
System.setProperty("webdriver.chrome.driver", "D:\\Ashok_Selenium\\Sample\\chromedriver1.exe");

WebDriver driver = new ChromeDriver();
driver.get("https://marolixhr.com/");
driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kalluruashok.marolix@gmail.com");
driver.findElement(By.xpath("//input[@id='password']")).sendKeys("7993771243");
Thread.sleep(1000);
driver.findElement(By.xpath("//button[@id='login_button']")).click();
WebElement button = driver.findElement(By.id("clock_in"));

WebDriverWait wait = new WebDriverWait(driver, 5);
	try {
    wait.until(ExpectedConditions.elementToBeClickable(button));
    
    button.click();
    System.out.println("Your Successfully  Clocked_In.");
	}
	catch (org.openqa.selenium.TimeoutException e) 
	{
    
    System.out.println("Your Already Clocked_In.");
	}

driver.quit();
}
	}