package pages;

import configuration.WaitForElement;
import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopingCartPage {

    private Logger logger = LogManager.getRootLogger();

    public ShopingCartPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @FindBy(css = "div>a[class = 'Button']")
    private WebElement btnProceedToCheckout;

    public LogInPage clickOnbtnProceedToCheckout(){
        WaitForElement.waitUntilElementIsClicable(btnProceedToCheckout);
        this.btnProceedToCheckout.click();
        logger.info("clicked procced to checkout button");
        return new LogInPage();
    }
}
