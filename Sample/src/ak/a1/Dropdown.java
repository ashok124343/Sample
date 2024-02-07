package ak.a1;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dropdown {

	public boolean loginBasedOnSystemTime(String name) throws Throwable
	{
		LocalDate currentDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		LocalTime targetTime = LocalTime.of(9, 0);
		WebDriver driver = new  ChromeDriver();
		DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();


		if ((isWeekday(currentDate) && currentTime.isAfter(targetTime)) || currentTime.equals(targetTime)) 
		{


			driver.manage().window().maximize();
			System.setProperty("webdriver.chrome.driver", "D:\\Ashok_Selenium\\Sample\\chromedriver1.exe");
			driver.get("https://marolixhr.com/");
			driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kalluruashok.marolix@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("7993771243");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='login_button']")).click();
			WebElement button = driver.findElement(By.id("clock_in"));

			WebDriverWait wait = new WebDriverWait(driver, 5);                  


			try 
			{
				wait.until(ExpectedConditions.elementToBeClickable(button));

				button.click();
				System.out.println("Your Login Time Is 9.00:"+targetTime);
				System.out.println("Your Successfully  Clocked_In.");
			}
			
			catch (org.openqa.selenium.TimeoutException e) 
			{
				System.out.println("Current Time:"+currentTime);
				System.out.println("Your Login Time Is 9.00 :"+targetTime);
				System.err.println("Your Already Clocked_In.");
			}

		}

		else if (isWeekend(currentDate)) 
		{
			System.err.println("Login not allowed WeekEnds ...");
		}
		else
		{

			System.err.println("Today Is : " +currentDayOfWeek+" And Time Is: "+currentTime);
			System.out.println("Current time is earlier than the 9.00AM.");
		}

		driver.quit();
		return false;
	}
	private boolean isWeekend(LocalDate currentDate) 
	{
		DayOfWeek dayOfWeekk = currentDate.getDayOfWeek();
		return dayOfWeekk == DayOfWeek.SATURDAY || dayOfWeekk == DayOfWeek.SUNDAY;
	}

	private static boolean isWeekday(LocalDate date) 
	{
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
	}



}
