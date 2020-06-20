package JavaScript;

import Base.Basetests;
import org.testng.annotations.Test;

public class JavaScriptTests extends Basetests {

    @Test
    public void testScroll(){
        var largeAndDeep = homePage.clickLargeAndDeep();
        largeAndDeep.scrollToTable();

    }
    @Test
    public void testInfiniteScroll(){
        homePage.clickInfiniteScroll().scrollToParagraph(10);
    }
}
