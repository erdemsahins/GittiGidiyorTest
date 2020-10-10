import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void startTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        this.driver.get("https://www.gittigidiyor.com/");
        Thread.sleep(2000);

    }


    @After
    public void endTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickByText(String text){
        driver.findElement(By.xpath("//*[text()='"+text+"']")).click();
    }

    public void clickByLintext(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public void sendById(String id, String value){
        driver.findElement(By.id(id)).sendKeys(value);
    }

    public void sendByXpath(String xpath, String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public void clickById(String id){
        driver.findElement(By.id(id)).click();
    }

    public void clickByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }
    public boolean findElementByXpath(String xpath){
        return driver.findElement(By.xpath(xpath)) != null;
    }
    public boolean findElementById(String id){
        return driver.findElement(By.id(id)) != null;
    }

    public void callHomePage() {
        if(driver.getCurrentUrl().equals("https://www.gittigidiyor.com/")){
            return;
        }
        else {
            driver.get("https://www.gittigidiyor.com/");
        }
    }
    public void clickByClassName(String className) {
        driver.findElement(By.className(className));
    }
    public void HoldByText(String text) {
        Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(driver.findElement(By.xpath("//*[text()='"+text+"']"))).build().perform();
    }
    public void sendByName(String name, String value){
        driver.findElement(By.name(name)).sendKeys(value);
    }
    public void randomSelect(String xpath){
        List<WebElement> pageResult = driver.findElements(By.xpath(xpath));
        Random random = new Random();
        pageResult.get(random.nextInt(pageResult.size())).click();
    }

}
