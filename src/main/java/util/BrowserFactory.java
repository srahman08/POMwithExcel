package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	static String browser;
	static String url;
	
	public static void readConfig() {
		
		Properties prop = new Properties();
		//FileReader InputStream BuffeReader Scanner 
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");

			System.out.println("User Browser: " + browser);
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}
	
	public static WebDriver init() {
	
		readConfig();
		
		if (browser.equalsIgnoreCase( "chrome")){
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
				
		}else if(browser.equalsIgnoreCase("Firefox")){
				System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
				driver = new FirefoxDriver();
		}		
			else if(browser.equalsIgnoreCase("Edge")){
				System.setProperty("webdriver.edge.driver", "driver\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
		
		
		
	}
	
	
	
	

}
