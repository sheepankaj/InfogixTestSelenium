/**
 * @author mackbookpankaj
 *
 */
package testGithubUsingSeleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestGitHub {

	public static WebDriver d;
	
	//To setup chrome driver path and launch & open the github website in the chrome browser 
	public static void chrome() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/mackbookpankaj/eclipse-workspace/ChromeWebDriver/chromedriver");
		d=new ChromeDriver();
		
		d.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		d.get("https://github.com/");
		d.manage().window().maximize();
		
		WebElement element = d.findElement(By.xpath("/html/body/div[4]/main/div[1]/div/div/div[1]/h1"));
		String text = element.getText();
		if(text.contains("Built for developers")) {
			System.out.println("Url entered and website displayed");
		}else {
			System.out.println("Entered a wrong Url");
		}
	}
	
	//To click Sign in button
	public static void SignIn() {
		
		boolean str = d.findElement(By.xpath("//a[contains(text(),'Sign in')]")).isDisplayed();
		if(str==true) {
			d.findElement(By.linkText("Sign in")).click();
			System.out.println("The wegpage is redirect to login page");
		}else {
			System.out.println("The wegpage is not redirect to login page");
		}
	}
	
	//Enter username, password and click sign in button
	public static void LoginPage() {
		d.findElement(By.xpath("//input[@id='login_field']")).sendKeys("testinggithub");
		d.findElement(By.xpath("//input[@id='password']")).sendKeys("test1234");
		d.findElement(By.xpath("//input[@name='commit']")).click();
		
		WebElement element = d.findElement(By.xpath("//div[@id='js-flash-container']/div/div"));
		String text=element.getText();
		
		if(text.contains("Incorrect username or password.")) {
			System.out.println("Displaying message when entered username & password is wrong: "+text);
		}else {
			System.out.println("Nothing found ");
		}
	}
	
	//To click forgot link and inserting email id as m.ie 
	public static void ForgetPassword() {
		d.findElement(By.xpath("//a[contains(text(),'Forgot password?')]")).click();
		d.findElement(By.id("email_field")).sendKeys("m.ie");
		WebDriverWait wait = new WebDriverWait(d, 50);
		d.findElement(By.xpath("//input[@name='commit']")).click();
		
		WebElement element = d.findElement(By.xpath("//div[@id='js-flash-container']/div/div"));
		String text=element.getText();
		if(text.contains("Can't find that email, sorry.")) {
			System.out.println("Displaying message when entered email id is wrong: "+text);
		}else {
			System.out.println("Nothing found ");
		}
	}
	
	//To click send password reset email without input
	public static void ResetPasswordWithEmptyEmail() {
		
		d.findElement(By.id("email_field")).sendKeys(" ");
		d.findElement(By.xpath("//input[@name='commit']")).click();
		
		WebElement element = d.findElement(By.xpath("//div[@id='js-flash-container']/div/div"));
		String text=element.getText();
		if(text.contains("Can't find that email, sorry.")) {
			System.out.println("Message displayed in the webpage when the value entered in the mandatory email field is empty: "+text);
		}else {
			System.out.println("Nothing found ");
		}
		
	}
	
	//To search the First word of the message- Can't
	public static void TextFinding() {
		WebElement element = d.findElement(By.xpath("//div[@id='js-flash-container']/div/div"));
		String text=element.getText();
		String[] parts = text.split(" ");
		
		
		if(parts[0].equals("Can't")) {
			System.out.println("Found the first word of the message is: Can't");
		}else {
			System.out.println("Nothing Found");
		}
	}
	
	//To click Sign Up button and redirect to join github page
	public static void JoinGitHubPage() {
		d.navigate().back();
		d.navigate().back();
		d.navigate().back();
		d.navigate().back();
		d.navigate().back();
		
		boolean str = d.findElement(By.linkText("Sign up")).isDisplayed();
		if(str==true) {
			d.findElement(By.linkText("Sign up")).click();
			System.out.println("Join GitHUb page will display");
		}else {
			System.out.println("Join GitHUb page will not display");
		}
		
	}
	
	//To search the text "Create your personal account" in join github page
	public static void CreateGitHubText() {
		WebElement element = d.findElement(By.xpath("//form[@id='signup-form']/h2"));
		String text=element.getText();
		
		if(text.contains("Create your personal account")) {
			System.out.println("Joint github page contains the text is: "+text);
		}else {
			System.out.println("Joint github page does not contain the text is: "+text);
		}
	}
	
	//To check the entered email id is existing
	public static void ExitingEmailId() {
		d.findElement(By.id("user_email")).sendKeys("sheepankaj@gmail.com");
		WebElement element = d.findElement(By.xpath("//p[contains(.,'Email is invalid or already taken')]"));
		String text=element.getText();
		
		if(text.contains("Email is invalid or already taken")) {
			System.out.println("Create an account button is grayed when an existing email address is inserted in join github page");
		}else {
			System.out.println("The inserted email id is not existing earlier");
		}
	}
	
	//Close the browser
		public static void BroserClose() {
			d.close();
	}
	
	//Main method
	public static void main(String[] args) {
		
		TestGitHub.chrome();
		TestGitHub.SignIn();
		TestGitHub.LoginPage();
		TestGitHub.ForgetPassword();
		TestGitHub.ResetPasswordWithEmptyEmail();
		TestGitHub.TextFinding();
		TestGitHub.JoinGitHubPage();
		TestGitHub.CreateGitHubText();
		TestGitHub.ExitingEmailId();
		TestGitHub.BroserClose();
	
		
	}

}
