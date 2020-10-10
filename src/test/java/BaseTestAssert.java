import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseTestAssert extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void checkTitle(String title){
        Assert.assertEquals(title,getTitle());
        logger.info("Title kontrolu gerceklesti.");
    }
    public void checkXpath(String key) {
        Assert.assertTrue("Element sayfada bulunamadı !", findElementByXpath(key));
    }
    public void checkId(String key){
        Assert.assertTrue("Element sayfada bulunamadı !", findElementById(key));
    }
    public void checkLogin (){
        Assert.assertTrue("Login islemi gerceklesmedi !", findElementByXpath("//*[text()='Hesabım']"));
    }
    public void checkText(String value){
        Assert.assertTrue("Element sayfada bulunamadı !", findElementByXpath("//*[text()='"+value+"']"));
    }

}
