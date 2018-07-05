import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import pages.yandex.YandexMainPage;



import java.util.concurrent.TimeUnit;

public class YandexMarketTest {

    private WebDriver driver;
    private YandexMainPage yandexMainPage = new YandexMainPage(driver);

    @Before
    public void loadPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.yandex.ru");
    }


    @Test
    public void checkPrices() throws InterruptedException {
        yandexMainPage.clickMarketLink();

        // следующие шаги
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

}
