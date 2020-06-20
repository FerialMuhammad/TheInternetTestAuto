package Alert;

import Base.Basetests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends Basetests {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\Thinkpad-Lenovo\\IdeaProjects\\testAUto1\\resources\\chromedriver.exe");
        assertEquals(uploadPage.getUploaded(),"chromedriver.exe", "Wrong file name");
    }
}
