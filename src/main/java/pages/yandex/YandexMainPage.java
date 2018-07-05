package pages.yandex;

import html_elements.SearchArrow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public class YandexMainPage {

    @FindBy(xpath = "//a[text()[contains(.,'Видео')]]")
    private Link videoLink;
    @FindBy(xpath = "//a[text()[contains(.,'Новости')]]")
    private Link newsLink;
    @FindBy(xpath = "//a[text()[contains(.,'Маркет')]]")
    private Link marketLink;

    public YandexMainPage(WebDriver driver) {
        super();
    }

    public void clickMarketLink() {
        marketLink.click();
    }

}
