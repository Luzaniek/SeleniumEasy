import assistant.Arithmetic;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class CheckBoxDemoTest {


    WebDriver driver;

    String urlSeleniumEasy = "https://www.seleniumeasy.com/";
    String CheckAllText = "Check All";
    String UncheckAllText = "Uncheck All";


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver.exe");

        driver = new FirefoxDriver();
    }

    @Test
    public void TestCheckBoxDemo() throws InterruptedException {


        driver.get(urlSeleniumEasy);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Demo Website!")).click();
        driver.findElement(By.id("home")).findElement(By.id("btn_basic_example")).click();
        driver.findElement(By.linkText("Check Box Demo")).click();

        String urlCheckBoxDemo = driver.getCurrentUrl();
        assertTrue(urlCheckBoxDemo.contains("checkbox"));

        WebElement singleCheckBox = driver.findElement(By.cssSelector("input[id='isAgeSelected']"));
        assertTrue(singleCheckBox.isEnabled());
        assertFalse(singleCheckBox.isSelected());

        singleCheckBox.click();
        System.out.println("Checkbox kliknięty");
        Thread.sleep(1000);
        WebElement singleCheckBoxSuccess = driver.findElement(By.id("txtAge"));

        assertTrue(singleCheckBoxSuccess.isEnabled());
        System.out.println("reakcja na zaznaczenie checkboxa");
        String txtSuccess = singleCheckBoxSuccess.getText();
        System.out.println(txtSuccess);
        assertTrue(txtSuccess.contains("Success"));
        System.out.println("Assercja przeszła");
        Thread.sleep(2000);
        singleCheckBox.click();
        System.out.println("CheckBox odhaczony");
        assertFalse(singleCheckBox.isSelected());
        System.out.println("ChceckBox został odhaczony");

        // Drugie pole checkboxów

        // Zliczenie elementów
        int kBox = driver.findElements(By.cssSelector("input[class='cb1-element']")).size();
        System.out.println("ilość elementów " + kBox);


        List<WebElement> checkBoxElements = driver.findElements(By.cssSelector("input[class='cb1-element']"));

        for (int i = 0; i < kBox; i++) {

            WebElement checkBoxElement = checkBoxElements.get(i);
            assertTrue(checkBoxElement.isEnabled());
            System.out.println("CheckBoxElement " + (i + 1) + " jest dostępny ");
            if (!checkBoxElement.isSelected()) {
                System.out.println("CheckBox nr " + (i + 1) + " nie jest zaznaczony");
            } else {
                System.out.println("CheckBox nr " + (i + 1) + " jest zaznaczony");
                checkBoxElement.click();
            }

            assertFalse(checkBoxElement.isSelected());
            System.out.println("Sprawdzone");
        }
        WebElement ButtonCheckAll = driver.findElement(By.cssSelector("input[id='check1']"));
        assertTrue(ButtonCheckAll.isEnabled());
        System.out.println("Button Check All' jest dostępny");
        String ButtonCheckBoxValue = ButtonCheckAll.getAttribute("value");
        System.out.println("Value buttona to: " + ButtonCheckBoxValue);
        assertEquals(ButtonCheckBoxValue, CheckAllText);

        Thread.sleep(2000);
        ButtonCheckAll.click();
        String ButtonUncheckBoxValue = ButtonCheckAll.getAttribute("value");
        assertEquals(ButtonUncheckBoxValue, UncheckAllText);
        System.out.println("Przycisk posiada właściwy tekst to: " + UncheckAllText);

        ButtonCheckAll.click();
        System.out.println("Kliknięty 'uncheckall");

        //sprawdzenie, czy zostały odhaczone wszystkie checkboxy

        for (int j = 0; j < kBox; j++) {


            WebElement checkBoxElement = checkBoxElements.get(j);
            assertTrue(checkBoxElement.isEnabled());
            System.out.println("Kliknięcie checkBoxa " + (j + 1));
            WebElement checkBoxElement2 = checkBoxElements.get(j);

            assertFalse(checkBoxElement2.isSelected());
            System.out.println("Checkbox numer " + (j + 1) + " nie jest zaznaczony");

        }

// Zaznaczanie losowe
        System.out.println("LOSOWANIE");
        int iloczyn = 1;
        for (int j = 0; j < kBox; j++) {

            System.out.println("Dla " + (j + 1));
            WebElement checkBoxElement = checkBoxElements.get(j);
            assertTrue(checkBoxElement.isEnabled());
            assertTrue(!checkBoxElement.isSelected());
            // losowanie odpowiedniej wartości
            Arithmetic randomValue = new Arithmetic();
            int valueResultForTheCheckBox = randomValue.randomValueCheckBox();
            System.out.println(valueResultForTheCheckBox);
            iloczyn = iloczyn * valueResultForTheCheckBox;
            System.out.println("iloczyn to " + iloczyn);
            System.out.println("Wylosowana wartość = " + valueResultForTheCheckBox);
            if (valueResultForTheCheckBox == 0) {
                checkBoxElement.click();
                System.out.println("Kliknięcie checkBoxa " + (j + 1));
                System.out.println("ChceckBox " + (j + 1) + " kliknięty");

            } else {
                System.out.println("Nie klikamy");
            }
        }

        if (iloczyn == 0) {

            WebElement ButtonCheckAll2 = driver.findElement(By.cssSelector("input[id='check1']"));
            assertTrue(ButtonCheckAll2.isEnabled());
            System.out.println("Button Check All' jest dostępny");
            String ButtonCheckBoxValue2 = ButtonCheckAll.getAttribute("value");
            System.out.println("Value buttona to: " + ButtonCheckBoxValue2);
            assertEquals(ButtonCheckBoxValue, CheckAllText);
            System.out.println("OK");


        } else {
            WebElement ButtonCheckAll2 = driver.findElement(By.cssSelector("input[id='check1']"));
            assertTrue(ButtonCheckAll2.isEnabled());
            System.out.println("Button Check All' jest dostępny");
            String ButtonCheckBoxValue2 = ButtonCheckAll.getAttribute("value");
            System.out.println("Value buttona to: " + ButtonCheckBoxValue2);
            assertEquals(ButtonCheckBoxValue2, UncheckAllText);
            Thread.sleep(5000);
            System.out.println("OK");
        }

//            assertTrue(checkBoxElement.isEnabled());
//            System.out.println("CheckBoxElement " + (i + 1) + " jest dostępny ");


    }


    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
//driver.quit();
    }

}

