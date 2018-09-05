package pages.yandex;

import html_elements.SearchArrow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.AbstractPage;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public abstract class AbstractYandexPage extends AbstractPage {
    private SearchArrow searchArrow;

    public void searchFor(String request) {
        searchArrow.search(request);
    }

}
