package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public DriverFactory() {
    }

    public static synchronized WebDriver createInstance() {
        return initWebDriver();
    }

    private static WebDriver initWebDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.56.2:4444/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("http://www.yandex.ru");
        return driver;
    }
}

