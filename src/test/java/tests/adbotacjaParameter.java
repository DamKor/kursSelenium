package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class adbotacjaParameter {

    protected WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","C:/selenium-dev/projects/kursSelenium/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://google.pl");
    }
    @Parameters ({"queryToSearch","expectedTitle"})
    @Test
    public void parametersExampleTest(@Optional("JavaStart") String queryToSearch,
                                      @Optional("JavaStart - Szukaj w Google")String expectedTitle){


        WebElement searchField = driver.findElement(By.name("q"));

        //String queryToSearch = "JavaStart";
        //String expectedTitle = "JavaStart - Szukaj w Google";

        searchField.sendKeys(queryToSearch);
        searchField.submit();

        assertTrue(driver.getTitle().equals(expectedTitle));
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }



}
