package Frames;

import Base.Basetests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends Basetests {
    @Test
    public void testWysy(){
        var wysyPage = homePage.clickWysy();
        wysyPage.setTextArea("Hello Maxab");
        wysyPage.clickIncreaseIndent();
        assertEquals(wysyPage.getTextFromEditor(), "Hello Maxab","Text Incorrect");

    }
}
