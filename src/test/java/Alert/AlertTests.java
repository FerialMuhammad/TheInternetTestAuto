package Alert;

import Base.Basetests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends Basetests {

    @Test
    public void testAcceptAlert(){
        var alertPage = homePage.clickAlertsPage();
        alertPage.triggerAlert();
          alertPage.alert_clickToAccept();
        assertEquals(alertPage.getResult(), "You successfuly clicked an alert", "Results text incorrect");
    }
    @Test
    public void testGetTextFromAlert(){
        var alertPage = homePage.clickAlertsPage();
        alertPage.triggerConfirm();
        String text = alertPage.alert_getText();
        alertPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
        assertEquals(alertPage.getResult(), "You clicked: Cancel", "Alert result incorrect");
    }
    @Test
    public void testSetInputInAlert(){
        var alertPage = homePage.clickAlertsPage();
        alertPage.triggerPrompt();
        String text = "Squad Gouda";
        alertPage.setInput(text);
        alertPage.alert_clickToAccept();
        assertEquals(alertPage.getResult(), "You entered: " + text, "Text incorrect");
    }
}
