import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import startPages.StartPages;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class SelectDropdownDemo {


    WebDriver driver;


    String selectDropdownList = "Select Dropdown List";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver.exe");


        driver = new FirefoxDriver();

    }

    @Test
    public void testSelectDropdownDemo() throws InterruptedException {

        StartPages sp = new StartPages(driver);
        sp.startSeleniumEasyPages();


        driver.findElement(By.linkText("Select Dropdown List")).click();

        WebElement selectDay = driver.findElement(By.id("select-demo"));

        assertTrue(selectDay.isEnabled());
        int k = driver.findElement(By.id("select-demo")).findElements(By.cssSelector("option")).size();
        System.out.println("k = " + k);

        List<WebElement> ListOfOption = driver.findElement(By.id("select-demo")).findElements(By.cssSelector("option"));
        int m = ListOfOption.size();
        System.out.println("m = " + m);
        assertEquals(k, m);

        WebElement firstOption = driver.findElement(By.id("select-demo")).findElement(By.cssSelector("option"));
        String valueFirstOption = firstOption.getText();
        System.out.println("Value of first Option :" + valueFirstOption);

        Select selectDays = new Select(selectDay);
        WebElement selectedDay = driver.findElement(By.className("selected-value"));

        for (int i = 0; i < m; i++) {
            WebElement iElement = ListOfOption.get(i);
            String elementName = iElement.getText();
            System.out.println("pobrany tekst to: " + elementName);
            System.out.println("For i = " + i + " : " + elementName);
            System.out.println(elementName);
            selectDays.selectByIndex(i);
            String selectedDayName = selectedDay.getText();
            System.out.println(selectedDayName);
            assertTrue(selectedDayName.contains(elementName));
            Thread.sleep(2000);
        }


    }


    @After
    public void tearDown() {
    }


}
