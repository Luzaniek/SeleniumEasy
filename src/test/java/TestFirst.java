import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class TestFirst {

    WebDriver driver;

    String urlToGet = "https://www.google.com";
    String urlMouse = "http://przyklady.javastart.pl/test/hover_mouse.html";
    String urlHover = "http://theinternet.przyklady.javastart.pl/hovers";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver.exe");


        driver = new FirefoxDriver();
    }


    @Test
    public void testFirst() throws InterruptedException {
        driver.get(urlHover);

        Actions actionMouse = new Actions(driver);

        List<WebElement> obraz = driver.findElements(By.className("figure"));
        List<WebElement> tekst = driver.findElements(By.className("figcaption"));
        int k = obraz.size();
        System.out.println("The number of elements: " + k);
        int m = tekst.size();
        System.out.println("The number of figcaption elements " + m);

        Thread.sleep(3000);
        Actions actionUserOne = new Actions(driver);

        int mm;

        for (int i = 0; i < k; i++) {
            System.out.println("Now: " + i);
            actionUserOne.moveToElement(obraz.get(i)).perform();
            Thread.sleep(1000);
            // assertTrue(ficap.isDisplayed());
            //System.out.println("ficap is displayed");


            String ficapText = tekst.get(i).getText();

            WebElement nnn = obraz.get(i).findElement(By.className("figcaption"));
            String nnntekst = nnn.getText();
            System.out.println("Mamy " + nnntekst);




            System.out.println("Text: " + ficapText);
            mm = i + 1;
            System.out.println("mm " + mm);
            String mmm = Integer.toString(mm);
            System.out.println("mmm " + mmm);
            assertTrue(ficapText.contains(mmm));
            System.out.println("The assertion has passed successfully");
            Thread.sleep(1000);
        }


        actionUserOne.moveToElement(obraz.get(1)).perform();
        WebElement eee = obraz.get(1).findElement(By.className("figcaption")).findElement(By.linkText("View profile"));
                eee.click();



//        WebElement smileyIcon = driver.findElement(By.id("smiley"));
//        assertTrue(smileyIcon.isDisplayed());
//        WebElement smileyIcon2 = driver.findElement(By.id("smiley2"));
//        actionMouse.moveToElement(smileyIcon).moveToElement(smileyIcon2).build().perform();


        Thread.sleep(5000);
    }


    @After
    public void tearDown() {

        //driver.quit();
    }
}
