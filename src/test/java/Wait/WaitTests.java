package Wait;

import Base.Basetests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends Basetests {
    @Test
    public void testWaitUntilHidden(){
        var dynamic = homePage.clickDynamicLoading().clickExample1();
        dynamic.clickStart();
        String foundText = dynamic.getLoadedText();
        assertEquals(foundText, "Hello World!", "Text not Found");
    }
}
