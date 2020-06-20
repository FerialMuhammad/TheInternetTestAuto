package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private String linkXpath_Format = ".//a[contains(text(), '%s')]";
    private By link_example = By.xpath(String.format(linkXpath_Format, "Example 1"));

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }
    public DynamicLoadingExamplePage clickExample1(){
        driver.findElement(link_example).click();
        return new DynamicLoadingExamplePage(driver);
    }
}
