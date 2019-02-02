package tests;

import configuration.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pages.LogInPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase {

    @TmsLink("BOS-1857")
    @Test
    @Description("The goal of this test is to log in using proper username and password" +
               "and check if Dog Banner is displayed after")
    public void asUserLoginUsingValidLoginAndPassword() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LogInPage logInPage = new LogInPage();
        boolean isBannerAfterLoginDisplayed = logInPage
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .isBannerAfterLoginDisplayed();

        assertTrue(isBannerAfterLoginDisplayed);
    }

}