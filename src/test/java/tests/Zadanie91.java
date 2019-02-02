package tests;

import org.testng.annotations.Test;
import pages.WelcomePage;

import static org.testng.AssertJUnit.assertEquals;

public class Zadanie91 extends TestBase {

   @Test
   public void zadanie(){
       WelcomePage welcomePage = new WelcomePage();
       String helpMessage = welcomePage.clickOnBtnEnterTheStore()
               .clickOnBtnFish()
               .clickOnBtnAngelFishID()
               .clickOnBtnAddToCart()
               .clickOnbtnProceedToCheckout()
               .getHelpMessage();

       assertEquals("You must sign on before attempting to check out.  Please sign on and try checking out again.",helpMessage);

   }


}
