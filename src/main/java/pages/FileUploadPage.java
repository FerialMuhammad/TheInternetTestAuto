package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By uploadBtn = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void uploadFile(String absolutePath){
        driver.findElement(inputField).sendKeys(absolutePath);
        clickSubmitBtn();
    }
    public void clickSubmitBtn(){
        driver.findElement(uploadBtn).click();
    }
    public String getUploaded(){
        return driver.findElement(uploadedFiles).getText();
    }
}
