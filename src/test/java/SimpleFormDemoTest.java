import assistant.Arithmetic;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import startPages.StartPages;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleFormDemoTest {


    WebDriver driver;

    String emptyString = "";
    String userMessage = "Ala ma kota";

    int numb1 = 171;
    int numb2 = 18;
    String number1 = new Integer(numb1).toString();
    String number2 = new Integer(numb2).toString();

    Arithmetic addn1n2 = new Arithmetic();
    int suma = addn1n2.dodawanie(numb1, numb2);
    String suman1n2 = new Integer(suma).toString();

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver.exe");

        driver = new FirefoxDriver();
    }

    @Test
    public void TestSimpleFormDemo() throws InterruptedException {

        StartPages sp = new StartPages(driver);
        sp.startSeleniumEasyPages();

        WebElement simpleFormDemoButton = driver.findElement(By.linkText("Simple Form Demo"));
        simpleFormDemoButton.click();

        System.out.println("Udane wejście na stronę 'Simple Form Demo'");

        WebElement userMessageInput = driver.findElement(By.cssSelector("input[id='user-message']"));
        assertTrue(userMessageInput.isEnabled());
        System.out.println("Input jest na stronie");

        Thread.sleep(2000);
        String textInInput = userMessageInput.getAttribute("value");
        System.out.println("teskt inputa to: " + textInInput);

        userMessageInput.click();
        userMessageInput.sendKeys(userMessage);
        System.out.println("Wpisano: " + userMessage);

        WebElement showMessageButton = driver.findElement(By.cssSelector("button[class='btn btn-default']"));
        //By.xpath("//span[@class='second']"

        assertTrue(showMessageButton.isEnabled());
        System.out.println("The button of sending message is enabled");

        showMessageButton.click();
        System.out.println("Button was clicked");

        WebElement displayMessage = driver.findElement(By.id("user-message"));
        assertTrue(displayMessage.isEnabled());


        WebElement displayUserMessage = driver.findElement(By.id("display"));
        assertTrue(displayUserMessage.isEnabled());

        String displayedMessage = displayUserMessage.getText();
        System.out.println("tekst to " + displayedMessage);
        assertEquals(userMessage, displayedMessage);
        System.out.println("Written user's text was displayd correctly");
        Thread.sleep(2000);

        // After refreshing the 'displayMessage' should be empty

        driver.navigate().refresh();
        System.out.println("Strona została odświeżona");

        WebElement userMessageInputAfterRefreshing = driver.findElement(By.cssSelector("input[id='user-message']"));
        userMessageInputAfterRefreshing.click();
        String inputText = userMessageInputAfterRefreshing.getText();
        assertEquals(inputText, emptyString);
        System.out.println("Input jest pusty");


        WebElement displayUserMessageAfterRefreshin = driver.findElement(By.id("display"));
        String displayedMessageAfterRefreshing = displayUserMessageAfterRefreshin.getText();
        System.out.println(" Massage po odświeżeniu" + displayedMessageAfterRefreshing);
        assertEquals(displayedMessageAfterRefreshing, emptyString);
        System.out.println("brak message'u");


        // Testowanie dwóch inputow
        WebElement inputNumber1 = driver.findElement(By.cssSelector("input[id='sum1']"));
        assertTrue(inputNumber1.isEnabled());
        System.out.println("The input for first number is avaialble");


        WebElement inputNumber2 = driver.findElement(By.cssSelector("input[id=sum2]"));
        assertTrue((inputNumber2.isEnabled()));
        System.out.println("The input for first number is avaialble");

        inputNumber1.click();
        String textinputnumber1 = inputNumber1.getText();
        assertEquals(textinputnumber1, emptyString);
        inputNumber1.sendKeys(number1);
        System.out.println("wpisano " + number1 + " do inputa pierwszego");
        inputNumber2.click();
        String textinputnumber2 = inputNumber2.getText();
        assertEquals(textinputnumber2, emptyString);
        inputNumber2.sendKeys(number2);
        System.out.println("Wpisano " + number2 + " do inputa drugiego");

        WebElement buttonTotalGet = driver.findElement(By.cssSelector("form[id='gettotal']")).findElement(By.cssSelector("button[class='btn btn-default']"));
        //WebElement but = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/form/button"));
        assertTrue(buttonTotalGet.isEnabled());
        System.out.println("Button 'Total Get' has been found");

        buttonTotalGet.click();
        WebElement sum = driver.findElement(By.id("displayvalue"));

        assertTrue(sum.isEnabled());
        String sumdisplayed = sum.getText();
        System.out.println("The sum displayed to " + sumdisplayed);
        assertEquals(sumdisplayed, suman1n2);


    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

}
