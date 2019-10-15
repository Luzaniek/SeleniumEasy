import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RadioButtonsDemo {


    WebDriver driver;
    String urlSeleniumEasy = "https://www.seleniumeasy.com";
    String emptyString = "";
    String radioButtonNotChecked = "Radio button is Not checked";
    String maleChecked = "Radio button 'Male' is checked";
    String femaleChecked = "Radio button 'Female' is checked";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver.exe");

        driver = new FirefoxDriver();
    }


    @Test
    public void radioButtonsDemoTest() throws InterruptedException {
        driver.get(urlSeleniumEasy);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Demo Website!")).click();
        driver.findElement(By.id("home")).findElement(By.id("btn_basic_example")).click();
        driver.findElement(By.linkText("Radio Buttons Demo")).click();

        WebElement buttonCheck = driver.findElement(By.id("buttoncheck"));
        assertTrue(buttonCheck.isEnabled());
        System.out.println("Button 'Get checked Value' is available");

        WebElement checkBoxMale = driver.findElement(By.cssSelector("input[value='Male']"));
        assertTrue(checkBoxMale.isEnabled());
        System.out.println("Check Box Male is available");
        assertFalse(checkBoxMale.isSelected());
        System.out.println("Check Box Male is not selected");

        WebElement checkBoxFemale = driver.findElement(By.cssSelector("input[value='Female']"));
        assertTrue(checkBoxFemale.isEnabled());
        System.out.println("Check Box Female is available");
        assertFalse(checkBoxMale.isSelected());
        System.out.println("Check Box Female is not selected");


        WebElement checkText = driver.findElement(By.className("radiobutton"));
        assertTrue(checkText.isEnabled());

        // Before clicking button
        String checkText1 = checkText.getText();
        assertEquals(checkText1, emptyString);
        System.out.println("There is no text in the field");
        Thread.sleep(2000);


        //Clicking button
        buttonCheck.click();
        String checkText2 = checkText.getText();

        System.out.println(checkText2);
        assertEquals(checkText2, radioButtonNotChecked);


        // Checking the Male button
        assertTrue(checkBoxMale.isEnabled());
        checkBoxMale.click();
        assertTrue(checkBoxMale.isSelected());
        System.out.println("Male checkbox is checked");
        assertTrue(checkBoxFemale.isEnabled());
        assertFalse(checkBoxFemale.isSelected());
        System.out.println("Checkbox Female is not checked");

        buttonCheck.click();

        // Before clicking button
        String checkText3 = checkText.getText();
        assertEquals(checkText3, maleChecked);
        System.out.println(checkText3);
        Thread.sleep(2000);

        // Checking the FEMALE button
        assertTrue(checkBoxFemale.isEnabled());
        checkBoxFemale.click();
        assertTrue(checkBoxFemale.isSelected());
        System.out.println("FeMale checkbox is checked");
        assertTrue(checkBoxMale.isEnabled());
        assertFalse(checkBoxMale.isSelected());
        System.out.println("Checkbox Female is not checked");

        buttonCheck.click();

        // Before clicking button
        String checkText4 = checkText.getText();
        assertEquals(checkText4, femaleChecked);
        System.out.println(checkText4);
        Thread.sleep(2000);

// Second field oof CheckBoxes
        // Group Radio Buttons Demo

        WebElement secondMaleCheckBox = driver.findElement(By.xpath("(//input[@value='Male'])[2]"));
        assertTrue(secondMaleCheckBox.isEnabled());
        assertFalse(secondMaleCheckBox.isSelected());

        WebElement secondFemaleCheckBox = driver.findElement(By.xpath("(//input[@value='Female'])[2]"));

        assertTrue(secondFemaleCheckBox.isEnabled());
        assertFalse(secondFemaleCheckBox.isSelected());
        // secondFemaleCheckBox.click();


//secondMaleCheckBox.click();
//secondFemaleCheckBox.click();

        WebElement rangeAgeTo5 = driver.findElement(By.cssSelector("input[value='0 - 5']"));
        assertTrue(rangeAgeTo5.isEnabled());
        assertFalse(rangeAgeTo5.isSelected());

        WebElement rangeAgeTo15 = driver.findElement(By.cssSelector("input[value='5 - 15']"));
        assertTrue(rangeAgeTo15.isEnabled());
        assertFalse(rangeAgeTo15.isSelected());


        WebElement rangeAgeTo50 = driver.findElement(By.cssSelector("input[value='15 - 50']"));
        assertTrue(rangeAgeTo50.isEnabled());
        assertFalse(rangeAgeTo50.isSelected());

        WebElement buttonGetValues = driver.findElement(By.cssSelector("button[onclick='getValues();']"));
        assertTrue(buttonGetValues.isEnabled());


        WebElement grb = driver.findElement(By.className("groupradiobutton"));
        assertTrue(grb.isEnabled());
        buttonGetValues.click();
        System.out.println("pole ");
        String grbText = grb.getText();
        System.out.println(grbText);

        // Checking Female and 15-50 Age


        assertTrue(secondFemaleCheckBox.isEnabled());
        System.out.println("CheckBox Female is enabled");
        assertFalse(secondFemaleCheckBox.isSelected());
        System.out.println("CheckBox Female is not selected");
        secondFemaleCheckBox.click();
        assertTrue(secondFemaleCheckBox.isSelected());
        System.out.println("CheckBox Female is selected");

        assertTrue(rangeAgeTo50.isEnabled());
        System.out.println("CheckBox range of Age 15-50 is enabled");
        rangeAgeTo50.click();
        if (rangeAgeTo50.isSelected()) {
            System.out.println("CheckBox range of Age 15-50 is selected");
            rangeAgeTo5.click();

        }

        assertFalse(rangeAgeTo50.isSelected());
        if (!rangeAgeTo50.isSelected()) {
            System.out.println("CheckBox range of Age 15-50 is not selected");
            rangeAgeTo50.click();
        }
        assertTrue(rangeAgeTo50.isSelected());
        System.out.println("CheckBox range of Age 15-50 is Selected");


        WebElement buttonGetValues2 = driver.findElement(By.cssSelector("button[onclick='getValues();']"));
        assertTrue(buttonGetValues2.isEnabled());
        buttonGetValues2.click();
        assertTrue(grb.isEnabled());
        String grbText2 = grb.getText();
        System.out.println(grbText2);

        assertTrue(grbText2.contains("Female"));
        assertTrue(grbText2.contains(("15 - 50")));

        // "input[value='Male']"))

        // Dont forgive abut is dispalyefd


    }
    //By.xpath("(//input[@name='Button'])[2]")


    @After
    public void tearDown() {
    }

}
