package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.driversFactory;
import com.qa.utils.configReader;

import io.cucumber.java.*;

public class ApplicationHooks {
	
	private driversFactory driverFactory;
	private WebDriver driver;
	private configReader cfgReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		cfgReader = new configReader();
		prop = cfgReader.init_prop();
	}
	
	@Before(order=1)
	public void launchbrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new driversFactory();
		driver = driverFactory.init_browser(browserName);
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
			//take screenshot
			String screenshotname = scenario.getName().replaceAll(" ", "_");
			byte [] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotname);
		}
	}

}
