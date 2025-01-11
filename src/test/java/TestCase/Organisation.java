package TestCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Organisation {
	@Test
	public void createOrganization() {
		Random r=new Random();
		int value = r.nextInt(1000);
		System.out.println(value);
		String org_name="ManiAndCo"+value;
		String expected_loginUrl="http://localhost:8889/index.php";
		//precondition
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8889/index.php");
		String actual_loginUrl = driver.getCurrentUrl();
		assertTrue(actual_loginUrl.contains(expected_loginUrl),"iam not login page");
		System.out.println("iam in login page");
		//login
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		//home webElement
		WebElement home = driver.findElement(By.xpath("//td[@class='moduleName']"));
		assertTrue(home.isDisplayed(),"homepage is not displayed");
		System.out.println("homePage is dispalyed....");
		
		WebElement organization = driver.findElement(By.xpath("//a[text()='Organizations']"));
		assertTrue(organization.isEnabled(),"is not enabled");	
		System.out.println("is enabled");
		organization.click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(org_name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement header = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String text_header = header.getText();
		assertTrue(text_header.contains(org_name),"organisation is not created under your name");
		System.out.println("Ogranization is successfully created under your name");
		//logout
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(profile).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}
}
