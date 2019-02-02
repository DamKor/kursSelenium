package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class screenShot {

WebDriver driver;
@BeforeMethod
public void setup(){
    driver = new ChromeDriver();
    driver.navigate().to("https://google.com");
}

@AfterMethod
public void close(){
    driver.quit();
}

@Test
public void screenshot() throws IOException {
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrFile, new File("c:\\xxx\\test.jpg"));
}
}
