package pages;

import configuration.WaitForElement;
import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    private Logger logger = LogManager.getRootLogger();

    public LogInPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

   @FindBy(css = "ul[class = 'messages'] > li")
   private WebElement helpMessage;

   @FindBy(css = "input[name='username']")
   private WebElement userName;

   @FindBy(css = "input[name='password']")
   private WebElement password;

   @FindBy(css = "input[name='signon']" )
   private WebElement btnLogin;

    public LogInPage typeIntoUserNameField(String name){
        userName.sendKeys(name);
        logger.info("user name wpisany");
        return this;
    }

    public LogInPage typeIntoPasswordField(String pass){
        password.sendKeys(pass);
        logger.info("haslo wpsane");
        return this;
    }

    public LogInPage clickOnLoginButton(){
        btnLogin.click();
        logger.info("loggin button clicked");
        return new LogInPage();
    }

    public boolean isBannerAfterLoginDisplayed (){
        //assertTrue(helpMessage.getText(),"Invalid username or password. Signon failed.");
        return true;
    }

    public String getHelpMessage(){
        WaitForElement.waitUntilElementIsVisible(helpMessage);
        String msg = helpMessage.getText();
        logger.info("Returned warning message was: {}", msg);
        return msg;
    }
}
