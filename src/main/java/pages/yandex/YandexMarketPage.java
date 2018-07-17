package pages.yandex;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YandexMarketPage extends AbstractYandexPage {

    private WebDriver driver;
    @FindBy(name = "Цена от")
    private TextInput priceFrom;
    @FindBy(name = "Цена до")
    private TextInput priceTo;

    public YandexMarketPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public List<WebElement> searchByPrice(String valueFrom, String valueTo) throws InterruptedException {

        final Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withMessage("Список не найден").withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);

        priceFrom.sendKeys(valueFrom);
        priceTo.sendKeys(valueTo);
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(""))));

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@data-id, 'model')]//a//*[@class='price']"));

        return searchResults;
    }


}
