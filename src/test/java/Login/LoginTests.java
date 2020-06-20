package Login;

import Base.Basetests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;

public class LoginTests extends Basetests {
    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuth();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage SAP = loginPage.clickLoginButton();
        assertTrue(SAP.getAlertText().contains("You logged into a secure area!"),"Alert text is incorrect");
    }
}
