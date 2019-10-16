
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class WindowPopupModalDemo {


    WebDriver driver;

    String urlSeleniumEasy = "https://www.seleniumeasy.com";


    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testSelectDropdownDemo() throws InterruptedException {
        driver.get(urlSeleniumEasy);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Demo Website!")).click();
        driver.findElement(By.id("home")).findElement(By.id("btn_basic_example")).click();
        driver.findElement(By.linkText("Window Popup Modal")).click();

        // WebElement alertBox = driver.findElement(By.cssSelector("button[onclick='myAlertFunction()']"));

        WebElement followOnTwitter = driver.findElement(By.linkText("Follow On Twitter"));
        assertTrue(followOnTwitter.isEnabled());

        Thread.sleep(3000);
        String newTitle = driver.getTitle();
        System.out.println(newTitle);
        System.out.println("1");

        // Get the current window handle.
        String parentGUID = driver.getWindowHandle();
        System.out.println("");
        followOnTwitter.click();
        String secondGUID = driver.getWindowHandle();
        driver.switchTo().window(secondGUID);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        WebElement ccc = driver.findElement(By.id("remember"));
        ccc.click();


////        Set allGUID = driver.getWindowHandles();
////        for (Object guid : allGUID) {
////            // one enter into if block if the GUID is not equal to parent window's GUID
////            if (!guid.equals(parentGUID)) {
////                System.out.println("hallo");
////                driver.manage().window().maximize();
////            }
////            driver.switchTo().window(parentGUID);
//
//        }
    }

    @After
    public void tearDown() {
    }


}
