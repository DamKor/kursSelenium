package tests;

import configuration.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pages.LogInPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertEquals;

//import static assertEquals;

public class FailedLoginTests extends TestBase {

        @Issue("BOS-18663")
        @TmsLink("BOS-18579")
        @Test
        @Description ("The goal of this test is to log in using not proper username and password" +
                " and check if warning message Invalid username or password is displayed")
        public void asUserTryToLogInWithIncorrectLoginAndPassword() {

            DriverUtils.navigateToPage(LOGIN_URL);

            LogInPage logInPage = new LogInPage()
                    .typeIntoUserNameField("NotExistingLogin")
                    .typeIntoPasswordField("NotProperPassword")
                    .clickOnLoginButton();
            LogInPage loginPage = new LogInPage();
            String warningMessage = loginPage.getHelpMessage();

            assertEquals(warningMessage, "Invalid username or password. Signon failed.");
        }

    }

