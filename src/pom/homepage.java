package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homepage {
	
	WebDriver driver;
	By pop_alert = By.xpath("//*[@id=\"block\"]");
	By link = By.linkText("Login");
	By username = By.id("usernameField");
	By passwd = By.id("passwordField");
	By loginbutton = By.xpath("//*[@id=\"loginForm\"]/div[5]/div/button");
	By register = By.linkText("Register Now");
//	By login = By.linkText("Login");
	
	public homepage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setUsername(String stuser)
	{
		driver.findElement(username).sendKeys(stuser);
	}
	
	public void setpasswd(String password)
	{
		driver.findElement(passwd).sendKeys(password);
	}
	
	public void clicklogin()
	{
		driver.findElement(link).click();
	}
	public void closealert()
	{
		driver.findElement(pop_alert).click();
	}
	public void clicknext()
	{
		driver.findElement(loginbutton).click();
	}
	public void clickRegister()
	{
		driver.findElement(register).click();
	}
}
 