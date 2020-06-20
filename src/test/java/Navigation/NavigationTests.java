package Navigation;

import Base.Basetests;
import org.testng.annotations.Test;

import java.net.URL;

public class NavigationTests extends Basetests {
    @Test
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }
    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().swithToTab("New Window");
    }
}
