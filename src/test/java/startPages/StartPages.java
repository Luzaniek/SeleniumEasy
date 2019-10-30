package startPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPages {

    WebDriver driver;


    public StartPages(WebDriver driver) {
        this.driver = driver;
    }


    By linkWebsite = By.linkText("Demo Website!");
    By startPractisingButton = By.id("btn_basic_example");


    public void startSeleniumEasyPages() {
        driver.findElement(linkWebsite).click();
        driver.findElement(startPractisingButton).click();
    }


}

