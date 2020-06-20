package Base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Basetests {
    private EventFiringWebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
       System.setProperty("webdriver.chrome.driver" , "resources/chromedriver.exe");
       driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
       driver.register(new EventReporter());
       //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
       goHome();

       /*System.out.println(driver.getTitle());

       driver.manage().window().maximize();

        WebElement input = driver.findElement(By.linkText("Inputs"));
        input.click();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        WebElement input = driver.findElement(By.linkText("Inputs"));
        input.click();*/

       ///driver.quit();
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        //System.out.println("Screenshot saved to: " + screenshot.getAbsolutePath());
        try {
        Files.move(screenshot,new File("resources/testScreen.png"));}
        catch (IOException e){
            e.printStackTrace();
        }}
    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
    public ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }
    /*public static void main(String[] args) {
        Basetests test = new Basetests();
        test.setUp();
    }*/
}
