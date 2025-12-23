package Projects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handles {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		//driver.findElement(By.linkText("Multiple Windows")).click();
	    driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
	    driver.findElement(By.cssSelector("a[href*='windows']")).click();
	    Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		//System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
		//System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
		
	}

}
