package configuration;

import driver.manager.DriverManager;

public class DriverUtils {

    public static void setInitialConfiguration(){
        //DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        DriverManager.getWebDriver().manage().window().maximize();
    }

    public static void navigateToPage(String url){
        DriverManager.getWebDriver().navigate().to(url);
    }
}
