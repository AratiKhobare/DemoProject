package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass
{
	@Test(groups= {"Master","Sanity"})
	public void test_Login() throws IOException
	{
		try
		{
			logger.info("Starting test_Login");
			
			driver.get(rb.getString("appURL"));
			logger.info("Homepage Displayed");
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account");
			
			hp.clickLogin();
			logger.info("Clicked on Login link");
			
			LoginPage lp=new LoginPage(driver);
			logger.info("Login page Displayed");
			
			lp.setEmail(rb.getString("email"));
			logger.info("Provided email");
			
			lp.setPassword(rb.getString("password"));
			//lp.setPassword("1234");
			logger.info("Provided password");
			
			lp.clickLogin();
			logger.info("Clicked on Login button ");
			
			Boolean targetpage=lp.isAccountExist();
			if(targetpage==true)
			{
				logger.info("Login successfull");
				Assert.assertTrue(true);				
			}
			else
			{
				logger.info("Login failed");
				captureScreen(driver, "test_Login");
				Assert.assertTrue(false);				
			}
			
		}
		catch(Exception e)
		{
			logger.info("Login failed"+e.getMessage());
			captureScreen(driver, "test_Login");
			Assert.assertTrue(false);				
		}
		
		logger.info(" Finished TC_002_Login");
	}
}
