package Dropdown;

import Base.Basetests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends Basetests {

    @Test
    public void TestSelectOption(){
        var dropDownPage = homePage.clickDropdown();
        dropDownPage.selectFromDropdown("Option 1");
        var selectedOptions = dropDownPage.getSelectedOption();
        assertEquals(selectedOptions.size(),1,"Incorrect number of selections");
        assertTrue(selectedOptions.contains("Option 1"), "Option not selected");
    }
}
