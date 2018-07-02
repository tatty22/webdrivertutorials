import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimpleTest {
    @Test

    public void navigateToRozetkaWebSiteAndSearchForIPhone() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");

        WebElement searchField = driver.findElement(By.cssSelector(".rz-header-search-input-text"));   //cssSelector(".header-search-input-text")
        searchField.clear();

        searchField.sendKeys("iPhone 6");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement searchButton = driver.findElement(By.cssSelector(".btn-link-i"));
        searchButton.click();
    }
}
