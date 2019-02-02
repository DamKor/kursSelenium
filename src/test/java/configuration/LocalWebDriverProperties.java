package configuration;

import driver.BrowserType;

public class LocalWebDriverProperties {

    // Metody zwracają właściwości dla poszczególnych kluczy, analogicznie jak w przypadku AppProperties
    public static BrowserType getLocalBrowser(){
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("local.browser"));
    }

    public static String getChromeDriverLocation(){
        return ConfigurationProperties.getProperties().getProperty("chrome.driver.location");
    }

    public static String getFirefoxDriverLocation(){
        return ConfigurationProperties.getProperties().getProperty("firefox.driver.location");
    }

    public static String getIEDriverLocation(){
        return ConfigurationProperties.getProperties().getProperty("ie.driver.location");
    }

}
