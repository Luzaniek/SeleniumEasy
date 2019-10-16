import assistant.Arithmetic;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InputFormDemo {


    WebDriver driver;
    String urlSDT = "https://www.seleniumeasy.com";
    String emptyString = "";
    String userMessage = "Ala ma kota";
    String inputFormText = "Input Form with Validations";
    String InputFormUrlShort = "input-form-demo.html";
    String firstName = "Ala";
    String lastName = "Kicia";
    String email = "ala@kicia.com";
    String phone = "123456789";
    String address = "Merlin Monroe";
    String city = "Alabama";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver.exe");


        driver = new FirefoxDriver();

    }

    @Test
    public void TestSimpleFormDemo() throws InterruptedException {
        driver.get(urlSDT);
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Demo Website!")).click();
        driver.findElement(By.id("home")).findElement(By.id("btn_basic_example")).click();
        WebElement proceedNext = driver.findElement(By.id("btn_inter_example"));
        assertTrue(proceedNext.isEnabled());
        proceedNext.click();
        WebElement inputForm = driver.findElement(By.linkText(inputFormText));
        assertTrue(inputForm.isEnabled());
        inputForm.click();
        Thread.sleep(1000);
        String InputFormUrl = driver.getCurrentUrl();
        System.out.println(InputFormUrl);
        assertTrue(InputFormUrl.contains(InputFormUrlShort));
        System.out.println("Assercja urlu przeszła");

        // Testowanie pola First Name
        System.out.println("Testowanie pola first Name");
        WebElement firstNameField = driver.findElement(By.cssSelector("input[name='first_name']"));
        assertTrue(firstNameField.isEnabled());
        System.out.println("firstName is enable");
        firstNameField.click();
        String firstNameStart = firstNameField.getText();
        assertEquals(emptyString, firstNameStart);
        firstNameField.sendKeys(firstName);


        // Testowanie pola LastName
        System.out.println("Testowanie pola first Name");
        WebElement lastNameField = driver.findElement(By.cssSelector("input[name='last_name']"));
        assertTrue(lastNameField.isEnabled());
        System.out.println("lastName is enable");
        firstNameField.click();
        String lastNameStart = lastNameField.getText();
        assertEquals(emptyString, lastNameStart);
        lastNameField.sendKeys(lastName);

// Testowanie pola email
        System.out.println("Testowanie pola first Name");
        WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
        assertTrue(emailField.isEnabled());
        System.out.println("email is enable");
        emailField.click();
        String emailStart = emailField.getText();
        assertEquals(emptyString, emailStart);
        emailField.sendKeys(email);

// Testowanie pola phone
        System.out.println("Testowanie pola first Phone");
        WebElement phoneField = driver.findElement(By.cssSelector("input[name='phone']"));
        assertTrue(phoneField.isEnabled());
        System.out.println("email is enable");
        emailField.click();
        String phoneStart = phoneField.getText();
        assertEquals(emptyString, phoneStart);
        phoneField.sendKeys(phone);


// Testowanie pola address
        System.out.println("Testowanie pola first Phone");
        WebElement addressField = driver.findElement(By.cssSelector("input[name='address']"));
        assertTrue(addressField.isEnabled());
        System.out.println("email is enable");
        addressField.click();
        String addressStart = addressField.getText();
        assertEquals(emptyString, addressStart);
        addressField.sendKeys(address);



        // Testowanie pola City
        System.out.println("Testowanie pola first Phone");
        WebElement cityField = driver.findElement(By.cssSelector("input[name='city']"));
        assertTrue(cityField.isEnabled());
        System.out.println("email is enable");
        cityField.click();
        String cityStart = cityField.getText();
        assertEquals(emptyString, cityStart);
        cityField.sendKeys(city);

        // Testowanie pola State
        System.out.println("Testowanie pola first Phone");
        Select stateField = new Select(driver.findElement(By.cssSelector("select[name='state']")) );

        

        Thread.sleep(5000);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //   driver.quit();

    }

}
