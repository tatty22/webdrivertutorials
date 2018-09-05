package pages;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.sql.DriverManager;

public abstract class AbstractPage{

    public AbstractPage() {
        PageFactory.initElements(new HtmlElementDecorator(driver.DriverManager.getDriver()),this);
    }
}
