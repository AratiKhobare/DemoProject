package testBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;
	public Logger logger; //for logging
	public ResourceBundle rb;// for reading congif.properties file
	
	@Parameters({"browser"})
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	public void setup(String br)
	{
		//load config.properties file
		rb=ResourceBundle.getBundle("config");
		
		//Logging
		logger=LogManager.getLogger(this.getClass());
		
		//Driver
		if(br.equals("chrome"))
		{
		    WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}	
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomestring() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	public int randomeNumber() 
	{
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return (Integer.parseInt(generatedString2));
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		SimpleDateFormat sd=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String timestamp=sd.format(dt);
		String screenshot=tname+timestamp+".png";
		TakesScreenshot  ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"\\screenshots\\"+screenshot);
		FileUtils.copyFile(source, target);
		
	}

}
