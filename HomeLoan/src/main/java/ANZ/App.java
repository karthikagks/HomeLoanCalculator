package ANZ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
	private static WebDriver driver = null;
    public static void main( String[] args ) throws InterruptedException
    {
    	WebDriverManager.firefoxdriver().setup();
    	
    	driver = new FirefoxDriver();
    	
    	//Mazimize current window
    	driver.manage().window().maximize();
    	
    	// Navigate to a website
    	driver.get("https://www.browserstack.com/");
    	
    	//Delay execution for 5 seconds to view the maximize operation
    	Thread.sleep(5000);

    	//Close the browser
    	driver.quit();
    }
}
