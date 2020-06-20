package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysyPage {
    private WebDriver driver;

    private By textArea = By.id("tinymce");
    private By increaseIndent = By.cssSelector("#mceu_12 button");


    public WysyPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMain();
    }
    public void setTextArea(String text){
        clearTextArea();
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMain();
    }
    public void clickIncreaseIndent(){
        driver.findElement(increaseIndent).click();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMain();
        return text;
    }

    private void switchToEditArea(){
        driver.switchTo().frame("mce_0_ifr");
    }
    private void switchToMain(){
        driver.switchTo().parentFrame();
    }
}
