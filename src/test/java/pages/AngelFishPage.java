package pages;

import configuration.WaitForElement;
import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelFishPage {

    private Logger logger = LogManager.getRootLogger();

    public AngelFishPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @FindBy(css = "tr:nth-child(3)>td:nth-child(5)")
    private WebElement btnAddToCart;

    public ShopingCartPage clickOnBtnAddToCart(){
        WaitForElement.waitUntilElementIsClicable(btnAddToCart);
        this.btnAddToCart.click();
        logger.info("clicked on add to cart button");
        return new ShopingCartPage();
    }
}
