package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="My Account")
	WebElement lnkMyaccount;
	
	@FindBy(linkText="Register")
	WebElement lnkRegister;
	
	@FindBy(linkText="Login")
	WebElement lnkLogin;
	
	public void clickMyAccount()
	{
		try 
		{
			lnkMyaccount.click();
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void clickRegister()
	{
		try 
		{
			lnkRegister.click();
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void clickLogin()
	{
		try 
		{
			lnkLogin.click();
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
}
