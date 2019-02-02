package tests;

import configuration.ConfigurationProperties;
import configuration.DriverUtils;
import configuration.PropertiesLoader;
import driver.BrowserType;
import driver.manager.DriverManager;
import org.testng.annotations.*;

import java.util.Properties;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {


    @BeforeClass
    public void beforeClass(){
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }
    @Parameters ("browser")
    @BeforeMethod
    public void Open(@Optional BrowserType browserType){
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterMethod
    public void close(){
        DriverManager.disposeDriver();
    }
}
