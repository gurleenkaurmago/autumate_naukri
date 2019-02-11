package testweboperations;

import org.testng.annotations.Test;

import pom.homepage;
import pom.registerUser;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class automate_naukri {
	
	static WebDriver driver = null;
	homepage objectlogin;
	registerUser objectReg;
	

	
  @Test(priority=0)
  public void closewindow() throws InterruptedException {
	  
	  objectlogin = new homepage(driver);

	/*  Set<String> windows =  driver.getWindowHandles();
	  System.out.println("window handlers are " + windows);*/
	  String currentwindow = driver.getWindowHandle();
	  
	  for(String handle: driver.getWindowHandles() )
		{
		  driver.switchTo().window(handle);
		  if(!handle.equals(currentwindow))
			  driver.close();
		  
		}
	  driver.switchTo().window(currentwindow);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  objectlogin.closealert();
	  driver.manage().window().maximize();
  }
  
  @Test(priority =1)
  public void login()
  {
	  String currentwindow = driver.getWindowHandle();
	  objectlogin.clicklogin();
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
	   for(String handles:driver.getWindowHandles())
	   {
		   driver.switchTo().window(handles);
		   if(!driver.getCurrentUrl().contains("login"))
			   driver.switchTo().window(currentwindow);
			   
	   }

	  objectlogin.setUsername("jhgjhg");
	  objectlogin.setpasswd("pass");
	  objectlogin.clicknext();
	  
	  try
	  {
		  String errorMsg= driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/span")).getText();
	//	  int err=0;
		//  Scanner in = new Scanner(System.in);
		  if(errorMsg.contains("Invalid details"))
			  {
			  Assert.fail();
			  	System.out.println("Username/Passwd did not match. registering user");
			  		objectlogin.clickRegister();
			  		register();
			  	
			  }  
		  
	  }
	  catch(Exception e) {		  
	  }
	  
  }

  @Test (dependsOnMethods = {"login"})
  void register()
  {
	  System.out.println("register user function called ");
	  objectReg = new registerUser(driver);
	  objectReg.clickUsertype();
	  objectReg.setUsername("gurleen kaur mago");
	  objectReg.setPassword("abcd123");
	  objectReg.setEmail("sundeepmago@gmail.com");
	  objectReg.setMobile("9811887167");
	  objectReg.selectExp("4");
	  
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.get("https://www.naukri.com/");
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
