package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By triggerAlertBtn = By.xpath(".//button[text()='Click for JS Alert']");
    private By triggerConfirmBtn = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptBtn = By.xpath(".//button[text()='Click for JS Prompt']");
    private By alertResult = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void triggerAlert(){
        driver.findElement(triggerAlertBtn).click();
    }
    public void triggerConfirm(){
        driver.findElement(triggerConfirmBtn).click();
    }
    public void triggerPrompt(){
        driver.findElement(triggerPromptBtn).click();
    }
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }
    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }
    public void setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public String getResult(){
        return driver.findElement(alertResult).getText();
    }
}
