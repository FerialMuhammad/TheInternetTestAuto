package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    By jScroll = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollToParagraph(int index){
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var executer = (JavascriptExecutor) driver;
        while (getNumberOfParagraphsPresent() < index){
            executer.executeScript(script);

        }
    }
    private int getNumberOfParagraphsPresent(){
        return driver.findElements(jScroll).size();
    }
}
