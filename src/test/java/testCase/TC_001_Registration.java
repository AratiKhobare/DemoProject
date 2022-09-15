package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_Registration extends BaseClass
{	
@Test(groups= {"Master","Regression"})
public void test_Registration() throws IOException
{
	try
	{
		logger.info("Starting TC_001_Registration");
		
		driver.get(rb.getString("appURL"));  //driver.get("http://localhost/opencart/upload/");
		logger.info("Homepage Displayed");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		hp.clickRegister();
		logger.info("Clicked on Registration");
		
		RegistrationPage rp=new RegistrationPage(driver);
		rp.setFirstName("xyz");
		logger.info("Provided First Name ");
		
		rp.setLastName("abc");
		logger.info("Provided Last Name ");
		
		rp.setEmail(randomestring()+"@gmail.com");
		logger.info("Provided Email ");
		
		rp.setTelephone("56987456");
		logger.info("Provided Telephone ");
		
		rp.setPassword("abc123");
		logger.info("Provided Password ");
		
		rp.setConfirmPwd("abc123");
		logger.info("Provided Confrmed Password ");
		
		rp.setPrivacyPolicy();
		logger.info("Set Privacy Policy ");
		
		rp.clickContinue();
		logger.info("Clicked on Continue ");
		
		
		String confmsg=rp.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account Registration Success ");
			Assert.assertTrue(true);
		}
		
		else
		{
		    logger.error("Account Registration Failed");
		    captureScreen(driver, "test_Registration");
			Assert.assertTrue(false);
		}

	}
	catch(Exception e)
	{
		logger.fatal("Account Registration failed" +e.getMessage());
		captureScreen(driver, "test_Registration");
		Assert.fail();
	}
	}
}
