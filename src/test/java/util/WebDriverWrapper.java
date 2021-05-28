package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverWrapper {
    private static Logger log = LogManager.getRootLogger();
    private static WebDriverWrapper instance;

    private WebDriver driver;
    private WebDriverWait wait;

    private WebDriverWrapper() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        System.setProperty("webdriver.chrome.driver", "bin\\chromedriver.exe");
        this.driver = new ChromeDriver(options);
        Logger log = LogManager.getRootLogger();
        driver.manage().window().maximize();

        this.wait = new WebDriverWait(driver, 5, 200);
    }

    public static WebDriverWrapper getInstance() {
        if (instance == null) {
            instance = new WebDriverWrapper();
            log.debug("Создал экземпляр обертки драйвера.");
        }
        return instance;
    }

    public void get(String url) {
        log.info(String.format("Перехожу на страницу '%s'", url));
        driver.get(url);
        log.info(String.format("Произведен переход на страницу '%s'", url));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    public void navigate() {
        driver.navigate().back();
    }

    public WebElement findElement(By locator) {
        log.debug(String.format("Ищу элемент по локатору '%s'", locator));

        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0]['style']['backgroundColor']='darksalmon';", result);

        log.debug(String.format("Найден элемент по локатору '%s'", locator));
        return result;
    }


    public void quit() {
        log.info("Закрываю браузер и все вкладки.");
        driver.quit();
        log.info("Браузер закрыт, вебдрайвер остановлен.");
    }
}
