package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergerContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']")).click();
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows =  new ArrayList<String>(windowHandles);
		String child = windows.get(1);
		driver.switchTo().window(child);
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		String par = windows.get(0);
		driver.switchTo().window(par);
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windows1 =  new ArrayList<String>(windowHandles1);
		String child1 = windows1.get(1);
		driver.switchTo().window(child1);
		driver.findElement(By.xpath("((//tbody)[4]/tr/td/div/a)[1]")).click();
		String par1 = windows1.get(0);
		driver.switchTo().window(par1);
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		System.out.println("Title of page: " + title);
	}
	

}
