import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestFirst {

    WebDriver driver;

    String urlSeleniumEasy = "https://www.seleniumeasy.com";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver.exe");


        driver = new FirefoxDriver();
    }


    @Test
    public void testFirst() throws InterruptedException {
        driver.get(urlSeleniumEasy);

        Thread.sleep(5000);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
