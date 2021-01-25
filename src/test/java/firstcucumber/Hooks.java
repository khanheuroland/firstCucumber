package firstcucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void initTest()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/macpro2019/Downloads/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/khanhtran/Downloads/geckodriver");
        String browserName = System.getProperty("browser", "chrome");
        if(browserName.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else
            driver = new FirefoxDriver();
    }

    @After
    public void AfterTest(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            final byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed (screenshot, "image/png");
        }
        this.driver.quit();
    }
}
