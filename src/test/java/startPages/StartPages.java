package startPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPages {

    WebDriver driver;


    public StartPages(WebDriver driver) {
        this.driver = driver;
    }

    String urlSDT = "https://www.seleniumeasy.com";

    By linkWebsite = By.linkText("Demo Website!");
    By startPractisingButton = By.id("btn_basic_example");


    public void startSeleniumEasyPages() {
        driver.get(urlSDT);
        driver.manage().window().maximize();

        driver.findElement(linkWebsite).click();
        driver.findElement(startPractisingButton).click();
    }


}

