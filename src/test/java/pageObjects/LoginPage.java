package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath="//input[@id='input-email']")
    WebElement txt_Email;
    
    @FindBy(xpath="//input[@id='input-password']")
    WebElement txt_Password;
    
    @FindBy(xpath="//input[@value='Login']")
    WebElement btn_Login;
    
    @FindBy(xpath="//h2[normalize-space()='My Account']")
    WebElement lbl_Myaccount;
    
    public void setEmail(String email)
    {
    	txt_Email.sendKeys(email);
    }
    
    public void setPassword(String pwd)
    {
    	txt_Password.sendKeys(pwd);
    }
    
    public void clickLogin()
    {
    	btn_Login.click();
    }
    
    public Boolean isAccountExist()
    {
    	if(lbl_Myaccount.isDisplayed())
    	{
    		return true;
    	}
		return false;   	
    }
}
