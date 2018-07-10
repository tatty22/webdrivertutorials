import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.yandex.YandexMainPage;
import pages.yandex.YandexMarketPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class YandexMarketTest {

    public WebDriver driver;

    @Before
    public void loadPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        driver.get("http://www.yandex.ru");
    }


    @Test
    public void checkPrices() throws InterruptedException {
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        yandexMainPage.clickMarketLink();

        YandexMarketPage yandexMarketPage = new YandexMarketPage(driver);
        yandexMarketPage.searchFor("Печь СВЧ");

        List<WebElement> searchResults = yandexMarketPage.searchByPrice("2850","2900");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        for (WebElement price : searchResults) {
            int value = Integer.parseInt(price.getText().replaceAll("\\s.$","").replaceAll("\\s",""));
            Assert.assertTrue((value >= 2850 ) && (value <= 2900));
        }
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

}
