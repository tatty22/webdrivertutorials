package html_elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Блок для компонента поиска yandex
*/

@Block(@FindBy(xpath = "//form"))
public class SearchArrow extends HtmlElement {
    @FindBy(name = "text")
    private TextInput requestInput;

    @FindBy(className = "search2__button")
    private Button searchButton;

    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }
}
