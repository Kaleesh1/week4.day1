package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGrndWinHan {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows =  new ArrayList<String>(windowHandles);
		String child = windows.get(1);
		driver.switchTo().window(child);
		String inChild = driver.getTitle();
		System.out.println("In 2nd Windown " + inChild);
		driver.close();
		String par = windows.get(0);
		driver.switchTo().window(par);

		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		int size = windowHandles1.size();
		System.out.println("Total windows opened is " + size);

		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windows2 =  new ArrayList<String>(windowHandles2);
		String string = windows2.get(1);
		driver.switchTo().window(string);
		driver.close();
		String par2 = windows2.get(0);
		driver.switchTo().window(par2);

		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(5000);

	}

}
