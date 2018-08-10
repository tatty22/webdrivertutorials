import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.yandex.YandexMainPage;
import pages.yandex.YandexMarketPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YandexMarketTest {

    public WebDriver driver;

    @Before
    public void loadPage() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://192.168.56.2:4444/wd/hub"),capabilities);
        driver.get("http://www.yandex.ru");
        
    }


    @Test
    public void checkPrices() throws InterruptedException {
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        yandexMainPage.clickMarketLink();

        YandexMarketPage yandexMarketPage = new YandexMarketPage(driver);
        yandexMarketPage.searchFor("Печь СВЧ");

        List<WebElement> searchResults = yandexMarketPage.searchByPrice("2850","2900");
        for (WebElement price : searchResults) {
            int value = Integer.parseInt(price.getText().replaceAll("[^0-9]",""));
            Assert.assertTrue("Цена " + value + " не попадает в корректный интервал",((value >= 2850 ) && (value <= 2900)));
        }
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

}
