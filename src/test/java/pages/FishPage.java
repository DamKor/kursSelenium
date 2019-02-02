package pages;

import configuration.WaitForElement;
import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishPage {

    private Logger logger = LogManager.getRootLogger();

    public FishPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @FindBy(css = "tr:nth-child(2)>td:nth-child(1)")
    WebElement btnAngelFishID;

    public AngelFishPage clickOnBtnAngelFishID(){
        WaitForElement.waitUntilElementIsClicable(btnAngelFishID);
        this.btnAngelFishID.click();
        logger.info("clicked on FISH ID");
        return new AngelFishPage();
    }
}
