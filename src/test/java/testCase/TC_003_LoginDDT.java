package testCase;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDDT extends BaseClass
{
	
@Test(dataProvider="Logindata")
public void test_LoginDDT(String email,String password,String exp)
{
	try
	{
		logger.info("Starting test_LoginDDT");
		driver.get(rb.getString("appURL"));
		logger.info("HomePage Displayed");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		
		hp.clickLogin();
		logger.info("Clicked on Login link");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Login page Displayed");
		
		lp.setEmail(email);
		logger.info("Provided email");
		
		lp.setPassword(password);
		logger.info("Provided password");
		
		lp.clickLogin();
		logger.info("Clicked on Login button ");
		
		Boolean targetpage=lp.isAccountExist();
		MyAccountPage myaccpage=new MyAccountPage(driver);
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				logger.info("Login successfull");
				myaccpage.clickLogout();
				Assert.assertTrue(true);		
			}
			else
			{
				logger.error("Login failed");			
				Assert.assertTrue(false);				
			}				
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				logger.info("Login successfull");
				myaccpage.clickLogout();
				Assert.assertTrue(false);	
			}
			else
			{
				logger.error("Login failed");			
				Assert.assertTrue(true);	
			}
		}
		
	}
	catch(Exception e)
	{
		logger.fatal("Login Failed ");
		Assert.fail();
	}
	logger.info(" Finished TC_003_LoginDDT ");
}

@DataProvider(name="Logindata")
public String[][] getdata() throws IOException
{
	String path=".\\testData\\LoginData.xlsx";
	XLUtility xlutil=new XLUtility(path);
	int totalrows=xlutil.getRowCount("sheet1");
	int totalcols=xlutil.getCellCount("sheet1", 1);
	
	String logindata[][]=new String[totalrows][totalcols];
	for(int r=1;r<=totalrows;r++)
	{
		for(int c=0;c<totalcols;c++)
		{
			logindata[r-1][c]=xlutil.getCellData("sheet1", r, c);
		}
	}
	return logindata;	
}

}
