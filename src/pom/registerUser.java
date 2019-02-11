package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class registerUser {
	WebDriver driver;
	By userType = By.xpath("/html/body/div/form/div[2]/div/button");
	By name = By.id("fname");
	By email = By.id("email");
	By password = By.name("password");
	By mobile = By.name("number");
	By exp = By.name("expYear");	
	
	public registerUser(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickUsertype()
	{
		driver.findElement(userType).click();
	}
	
	public void setUsername(String stname)
	{
		driver.findElement(name).sendKeys(stname);
	}
	
	public void setEmail(String mail)
	{
		driver.findElement(email).sendKeys(mail);
	}

	public void setPassword(String passwd)
	{
		driver.findElement(password).sendKeys(passwd);
	}
	
	public void setMobile(String mob)
	{
		driver.findElement(mobile).sendKeys(mob);
	}
	
	public void selectExp(String i)
	{
		driver.findElement(exp).click();
		Select sel = new Select (driver.findElement(exp));
		//sel.selectByVisibleText(i);
		//sel.selectByIndex(3);
		sel.selectByVisibleText("2");
		//sel.selectByValue("4");
		
	}
}
