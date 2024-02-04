package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Service {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Random random = new Random();


    public Service(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public final String getDriver() {
        return "C:/driver/chromedriver.exe";
    }

    public final String getURL() {
        return "https://pl.wikipedia.org/";
    }

    public final String chromeDriverURL() {
        return "webdriver.chrome.driver";
    }

}
