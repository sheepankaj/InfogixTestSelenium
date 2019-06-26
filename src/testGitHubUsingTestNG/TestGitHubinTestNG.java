/**
 * @author mackbookpankaj
 *
 */
package testGitHubUsingTestNG;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class TestGitHubinTestNG {
	public WebDriver d;
	public Properties p;
	
	@BeforeTest 
	//Browser launch
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/mackbookpankaj/eclipse-workspace/ChromeWebDriver/chromedriver");
		d=new ChromeDriver();
		d.manage().window().maximize();
		System.out.println("Chrome browser launch");
		
	}
	
	@Test
	
	public void Github() throws InterruptedException {
		//Open github website
		d.get("https://github.com/");
		
		WebElement element = d.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/div[1]/h1"));
		String text = element.getText();
		if(text.contains("Built for developers")) {
			System.out.println("Url entered and website displayed");
		}else {
			System.out.println("Entered a wrong Url");
		}
		
		//Click Sign In button 
		boolean str = d.findElement(By.xpath("//a[contains(text(),'Sign in')]")).isDisplayed();
		if(str==true) {
			d.findElement(By.linkText("Sign in")).click();
			System.out.println("The wegpage is redirect to login page");
		}else {
			System.out.println("The wegpage is not redirect to login page");
		}
		
		//Enter username, password and click sign in button
		d.findElement(By.xpath("//input[@id='login_field']")).sendKeys("testingtg");
		d.findElement(By.xpath("//input[@id='password']")).sendKeys("test12345");
		d.findElement(By.xpath("//input[@name='commit']")).click();
		
		WebElement invalidUP = d.findElement(By.xpath("//div[@id='js-flash-container']/div/div"));
		String message=invalidUP.getText();
		
		if(message.contains("Incorrect username or password.")) {
			System.out.println("Displaying message when entered username & password is wrong: "+message);
		}else {
			System.out.println("Nothing found ");
		}
		
		
		//To click forgot link and inserting email id as m.ie 
		d.findElement(By.xpath("//a[contains(text(),'Forgot password?')]")).click();
		d.findElement(By.id("email_field")).sendKeys("m.ie");
		//Wait for 1 second
		Thread.sleep(1000);
		//Click on send password reset email button with above input
		d.findElement(By.xpath("//input[@name='commit']")).click();
		
		WebElement mailInvalid = d.findElement(By.xpath("//div[@id='js-flash-container']/div/div"));
		String message1=mailInvalid.getText();
		if(message1.contains("Can't find that email, sorry.")) {
			System.out.println("Displaying message when entered email id is wrong: "+message1);
		}else {
			System.out.println("Nothing found ");
		}
		
		
		//Click on send password reset email button without input
		d.findElement(By.id("email_field")).sendKeys(" ");
		d.findElement(By.xpath("//input[@name='commit']")).click();
		
		WebElement blankValue = d.findElement(By.xpath("//div[@id='js-flash-container']/div/div"));
		String textMessage=blankValue.getText();
		if(textMessage.contains("Can't find that email, sorry.")) {
			System.out.println("Message displayed in the webpage when the value entered in the mandatory email field is empty: "+textMessage);
		}else {
			System.out.println("Nothing found ");
		}
		
		
		
		//To search the First word of the message- Can't
		WebElement element1 = d.findElement(By.xpath("//div[@id='js-flash-container']/div/div"));
		String text1=element1.getText();
		String[] parts = text1.split(" ");
		
		if(parts[0].equals("Can't")) {
			System.out.println("Found the first word of the message is: Can't");
		}else {
			System.out.println("Nothing Found");
		}
		d.navigate().back();
		d.navigate().back();
		d.navigate().back();
		d.navigate().back();
		d.navigate().back();
		
		//To click Sign Up button and redirect to join github page
		boolean str1 = d.findElement(By.xpath("(//a[contains(@href, '/join?source=header-home')])[2]")).isDisplayed();
		if(str1==true) {
			d.findElement(By.xpath("(//a[contains(@href, '/join?source=header-home')])[2]")).click();
			System.out.println("Join GitHUb page will display");
		}else {
			System.out.println("Join GitHUb page will display");
		}
		
		//To search the text "Create your personal account" in join github page
		WebElement element2 = d.findElement(By.xpath("//form[@id='signup-form']/h2"));
		String text2=element2.getText();
		
		if(text2.contains("Create your personal account")) {
			System.out.println("Joint github page contains the text is: "+text2);
		}else {
			System.out.println("Joint github page does not contain the text is: "+text2);
		}
	
		
		//To check the entered email id is existing
		d.findElement(By.id("user_email")).sendKeys("sheepankaj@gmail.com");
		Thread.sleep(500);
		WebElement element3 = d.findElement(By.xpath("//p[contains(.,'Email is invalid or already taken')]"));
		String text3=element3.getText();
		
		if(text3.contains("Email is invalid or already taken")) {
			System.out.println("Create an account button is grayed when an existing email address is inserted in join github page");
		}else {
			System.out.println("The given email id does not existed.");
		}
		
	}
	@AfterTest
	//Close the browser
	public void BroserClose() {
		d.close();
	}
	
}
