package driver;

import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

//import static driver.BrowserType.CHROME;

public class BrowserFactory {

    public static WebDriver getBrowser(BrowserType browserType) {

        ClassLoader classLoader = BrowserFactory.class.getClassLoader();
        String file;
        File fileWithDriver;

        switch (browserType) {
            /*case CHROME:
                file = classLoader.getResource("chromedriver.exe").getFile();
                fileWithDriver = new File(file);
                System.setProperty("webdriver.chrome.driver", fileWithDriver.getAbsolutePath());
                ChromeOptions options = new ChromeOptions();
                ChromeOptions useAutomationExtension = options.setExperimentalOption("useAutomationExtension", false);
                return new ChromeDriver(useAutomationExtension);
                */

            case CHROME:
                System.setProperty("webdriver.chrome.driver", LocalWebDriverProperties.getChromeDriverLocation());
                ChromeOptions options = new ChromeOptions();
                ChromeOptions useAutomationExtension = options.setExperimentalOption("useAutomationExtension", false);
                return new ChromeDriver(useAutomationExtension);

            case FIREFOX:
                file = classLoader.getResource("geckodriver.exe").getFile();
                fileWithDriver = new File(file);
                System.setProperty("webdriver.gecko.driver", LocalWebDriverProperties.getFirefoxDriverLocation());
                return new FirefoxDriver();

            case IE:
                file = classLoader.getResource("geckodriver.exe").getFile();
                fileWithDriver = new File(file);
                System.setProperty("webdriver.ie.driver",  LocalWebDriverProperties.getIEDriverLocation());;
                return new InternetExplorerDriver();

            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }
}
