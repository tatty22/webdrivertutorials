package pages.yandex;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YandexMarketPage extends AbstractYandexPage {

    //private WebDriver driver;
    @FindBy(name = "Цена от")
    private TextInput priceFrom;
    @FindBy(name = "Цена до")
    private TextInput priceTo;

    /*
    public YandexMarketPage() {
        super();
        this.driver = driver;
    }
    */


    public List<WebElement> searchByPrice(String valueFrom, String valueTo) throws InterruptedException {

        final Wait<WebDriver> wait = new FluentWait<WebDriver>(driver.DriverManager.getDriver()).withMessage("Список не найден").withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);

        priceFrom.sendKeys(valueFrom);
        priceTo.sendKeys(valueTo);

        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[contains(@class,'spin2_progress_yes')]"))));   // не работает:(
        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[contains(@class,'preloadable__preloader_visibility_visible')]"))));  // не работает:(
        wait.until(ExpectedConditions.invisibilityOf(driver.DriverManager.getDriver().findElement(By.xpath("//div[contains(@class,'spin2_js_inited')]"))));   // иногда работает


        List<WebElement> searchResults = driver.DriverManager.getDriver().findElements(By.xpath("//div[contains(@data-id, 'model')]//a//*[@class='price']"));

        return searchResults;
    }


}
