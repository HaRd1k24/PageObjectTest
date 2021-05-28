package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import util.WebDriverWrapper;

public abstract class AbstractPageObject {

    public String baseUrl;
    public String url;

    WebDriverWrapper driver = WebDriverWrapper.getInstance();

    Logger log = LogManager.getRootLogger();

    public AbstractPageObject(String baseUrl) {
        this.baseUrl = baseUrl;
        log.trace(String.format("Создал страничный объект для url = '%s'", baseUrl));
    }


    public abstract void open();


    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
