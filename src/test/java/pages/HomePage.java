package pages;

import configuration.WaitForElement;
import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private Logger logger = LogManager.getRootLogger();

    public HomePage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @FindBy(css = "#MainImageContent > map > area:nth-child(2)")
    private WebElement btnFish;

    public FishPage clickOnBtnFish(){
        WaitForElement.waitUntilElementIsClicable(btnFish);
        this.btnFish.click();
        logger.info("clicked on Fish button");
        return new FishPage();
    }


    public LogInPage clickOnSignInLink(){

        return new LogInPage();
    }
}
