import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import startPages.StartPages;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class AlertBoxDemo {


    WebDriver driver;

    String urlSeleniumEasy = "https://www.seleniumeasy.com";
    String selectDropdownList = "Select Dropdown List";
    String enterName = "Enter name";
    String emptyString = "";
    String myPromptText = "Ala ma kota";

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

        driver.findElement(By.linkText("Javascript Alerts")).click();

        WebElement alertBox = driver.findElement(By.cssSelector("button[onclick='myAlertFunction()']"));

        System.out.println("Przycisk wywołujący alert jest znaleziony");
        alertBox.click();
        System.out.println("The button has been clicked");
        Alert firstAlertWindow = driver.switchTo().alert();
        System.out.println("We have been switched on the Alert space");
        Thread.sleep(2000);
        String alertText1 = firstAlertWindow.getText();
        System.out.println(alertText1);

        firstAlertWindow.accept();
        System.out.println("Button 'OK' was clicked and The popup should be closed");
        Thread.sleep(1000);


        // The second Fields:
        WebElement alertConfirm = driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']"));
        System.out.println("Przycisk 2 wywołujący alert jest znaleziony");
        assertTrue(alertConfirm.isEnabled());
        System.out.println("przycisk 2 jest dostepny");
        alertConfirm.click();
        System.out.println("Przycisk 2 is clicked");

        Alert alertConfirmWindow = driver.switchTo().alert();
        alertConfirmWindow.accept();
        System.out.println("Kliknięte OK");

        WebElement confirmTextDemo = driver.findElement(By.id("confirm-demo"));
        assertTrue(confirmTextDemo.isEnabled());
        assertTrue(confirmTextDemo.isDisplayed());
        String confirmText = confirmTextDemo.getText();
        System.out.println(confirmText);
        assertTrue(confirmText.contains("OK"));
        System.out.println("The button 'OK' has been clicked");


        alertConfirm.click();
        Thread.sleep(2000);
        alertConfirmWindow.dismiss();
        System.out.println("Kliknięte Cancel");
        confirmText = confirmTextDemo.getText();
        Thread.sleep(2000);
        System.out.println(confirmText);

        assertTrue(confirmText.contains("Cancel"));
        System.out.println("The button 'Cancel' has been clicked");

// The third field

        WebElement alertPrompt = driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']"));
        assertTrue(alertPrompt.isEnabled());
        System.out.println("Button prompt is enable");

        WebElement promptTextDemo = driver.findElement(By.id("prompt-demo"));

        System.out.println("Button prompt is enable");
        alertPrompt.click();
        System.out.println("Button was clicked");
        Alert alertPromptWindow = driver.switchTo().alert();
        alertPromptWindow.sendKeys(myPromptText);
        alertPromptWindow.dismiss();

        assertTrue(promptTextDemo.isEnabled());
        String promptText = promptTextDemo.getText();
        System.out.println("prompt text :" + promptText);
        assertEquals(promptText, emptyString);

        Thread.sleep(2000);
        alertPrompt.click();
        System.out.println("Button was clicked");

        alertPromptWindow.accept();
        promptText = promptTextDemo.getText();
        System.out.println("prompt text 2 :" + promptText);
        assertTrue(promptText.contains(enterName));

        Thread.sleep(2000);

        alertPrompt.click();
        alertPromptWindow.sendKeys(myPromptText);
        alertPromptWindow.accept();
        promptText = promptTextDemo.getText();
        System.out.println("prompt text :" + promptText);
        assertTrue(promptText.contains(myPromptText));




    }


    @After
    public void tearDown() {
    }


}
