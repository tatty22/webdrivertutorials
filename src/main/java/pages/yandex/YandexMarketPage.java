package pages.yandex;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
        priceFrom.sendKeys(valueFrom);
        priceTo.sendKeys(valueTo);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        List<WebElement> searchResults = driver.findElements(By.className("price"));

        return searchResults;
    }


}
