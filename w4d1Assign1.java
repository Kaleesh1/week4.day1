package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class w4d1Assign1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowChld=new ArrayList<String>(windowHandles);
		String winChld = windowChld.get(1);
		driver.switchTo().window(winChld);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		String parWin = windowChld.get(0);
		driver.switchTo().window(parWin);
		driver.quit();
	}

}
