package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    public DriverManager() {
    }

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal();

    public static WebDriver getDriver() {
        return (WebDriver)webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}
