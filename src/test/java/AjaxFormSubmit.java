import assistant.Arithmetic;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AjaxFormSubmit {



    WebDriver driver;
    String urlSDT = "https://www.seleniumeasy.com";
    String emptyString = "";
    String userMessage = "Ala ma kota";
    String ajaxFormSubmit = "Ajax Form Submit";
     String inputFormText = "Input Form with Validations";
    String AjaxFormSubmitUrlShort = "ajax-form-submit-demo.html";
    String firstName = "Ala";
    String lastName = "Kicia";
    String email = "ala@kicia.com";
    String phone = "123456789";
    String address = "Merlin Monroe";
    String city = "Roswell";
    String zip = "223-332";
    String website = "www.aabb.ab";
    String commentTextToInsert = "God save our gracious Queen,\n";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver.exe");


        driver = new FirefoxDriver();

    }

    @Test
    public void TestAjaxFormSubmitDemo() throws InterruptedException {
        driver.get(urlSDT);
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Demo Website!")).click();
        driver.findElement(By.id("home")).findElement(By.id("btn_basic_example")).click();
        WebElement proceedNext = driver.findElement(By.id("btn_inter_example"));
        assertTrue(proceedNext.isEnabled());
        proceedNext.click();
        WebElement inputForm = driver.findElement(By.linkText(ajaxFormSubmit));
        assertTrue(inputForm.isEnabled());
        inputForm.click();
        Thread.sleep(1000);
        String InputFormUrl = driver.getCurrentUrl();
        System.out.println(InputFormUrl);
        assertTrue(InputFormUrl.contains(AjaxFormSubmitUrlShort));
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
        String firstNameChecking = firstNameField.getAttribute("value");
        System.out.println("FN = " + firstNameChecking);
        assertEquals(firstNameChecking, firstName);
        System.out.println("The First Name was written in correctly");


        // Testowanie pola LastName
        System.out.println("Testing the field: first Name");
        WebElement lastNameField = driver.findElement(By.cssSelector("input[name='last_name']"));
        assertTrue(lastNameField.isEnabled());
        System.out.println("lastName is enable");
        firstNameField.click();
        String lastNameStart = lastNameField.getText();
        assertEquals(emptyString, lastNameStart);
        lastNameField.sendKeys(lastName);

// Testowanie pola email
        System.out.println("Testowanie pola email");
        WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
        assertTrue(emailField.isEnabled());
        System.out.println("email is enable");
        emailField.click();
        String emailStart = emailField.getText();
        assertEquals(emptyString, emailStart);
        emailField.sendKeys(email);

// Testowanie pola phone
        System.out.println("Testowanie pola  Phone");
        WebElement phoneField = driver.findElement(By.cssSelector("input[name='phone']"));
        assertTrue(phoneField.isEnabled());
        System.out.println("email is enable");
        emailField.click();
        String phoneStart = phoneField.getText();
        assertEquals(emptyString, phoneStart);
        phoneField.sendKeys(phone);


// Testowanie pola address
        System.out.println("Testowanie pola Address");
        WebElement addressField = driver.findElement(By.cssSelector("input[name='address']"));
        assertTrue(addressField.isEnabled());
        System.out.println("Address is enable");
        addressField.click();
        String addressStart = addressField.getText();
        assertEquals(emptyString, addressStart);
        addressField.sendKeys(address);


        // Testowanie pola City
        System.out.println("Testowanie pola City");
        WebElement cityField = driver.findElement(By.cssSelector("input[name='city']"));
        assertTrue(cityField.isEnabled());
        System.out.println("City Field is enable");
        cityField.click();
        String cityStart = cityField.getText();
        assertEquals(emptyString, cityStart);
        cityField.sendKeys(city);

        // Testowanie pola State
        System.out.println("Testowanie pola State");
        Select stateField = new Select(driver.findElement(By.cssSelector("select[name='state']")));

        Arithmetic stateNumber = new Arithmetic();
        int kState = stateNumber.randomStategenerator(52);

        System.out.println("State: " + kState);
        stateField.selectByIndex(kState);


//        List<WebElement> kkk =  stateField.getOptions();
//        int hhh = kkk.size();
//        System.out.println("Number is" + hhh);


        // Testowanie pola Zip
        System.out.println("Testowanie pola Zip");
        WebElement zipField = driver.findElement(By.cssSelector("input[name='zip']"));
        assertTrue(zipField.isEnabled());
        System.out.println("zip is enable");
        zipField.click();
        String zipStart = zipField.getText();
        assertEquals(emptyString, zipStart);
        zipField.sendKeys(zip);

        // Testowanie pola WebSide
        System.out.println("Testowanie pola Zip");
        WebElement websiteField = driver.findElement(By.cssSelector("input[name='website']"));
        assertTrue(websiteField.isEnabled());
        System.out.println("Website Filed is enable");
        websiteField.click();
        String websiteStart = websiteField.getText();
        assertEquals(emptyString, websiteStart);
        websiteField.sendKeys(website);

        //Testowanie checkboxów

        WebElement checkHostingYes = driver.findElement(By.cssSelector("input[value='yes'"));
        assertTrue(checkHostingYes.isEnabled());
        checkHostingYes.click();
        WebElement checkHostingNo = driver.findElement(By.cssSelector("input[value='no'"));
        assertTrue(checkHostingNo.isEnabled());
        assertFalse(checkHostingNo.isSelected());

        // Testing the Field: Comment
        WebElement commentField = driver.findElement(By.name("comment"));
        assertTrue(commentField.isEnabled());
        commentField.click();
        String commentText = commentField.getText();
        assertEquals(commentText, emptyString);
        commentField.sendKeys(commentTextToInsert);

        //Sending
        WebElement buttonSend = driver.findElement(By.cssSelector("button[type='submit'"));
        buttonSend.click();
        Thread.sleep(1000);





        Thread.sleep(5000);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //   driver.quit();

    }

}
