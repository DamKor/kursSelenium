package pages;

import configuration.WaitForElement;
import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    private Logger logger = LogManager.getRootLogger();

    public WelcomePage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @FindBy(css = "p:nth-child(2)>a")
    WebElement btnEnterTheStore;


    public HomePage clickOnBtnEnterTheStore(){
        logger.info("Trying to click Enter Store link");
        WaitForElement.waitUntilElementIsClicable(btnEnterTheStore);
        btnEnterTheStore.click();
        logger.info("Clicked on Enter Store link");
        return new HomePage();
    }
}
