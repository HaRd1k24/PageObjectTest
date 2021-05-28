package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class MainPage extends AbstractPageObject {
    private static final String url = "https://www.regard.ru/";
    private static final Logger log = LogManager.getRootLogger();

    public MainPage() {
        super(url);
        log.debug("Создал PageObject для главной страницы.");
    }

    @Override
    public void open() {
        driver.get(baseUrl);
    }

    public void searchM() {
        log.info("Кликаем на материнские платы");
        WebElement clickMP = driver.findElement(By.xpath("//a[text()='Материнские платы']"));
        clickMP.click();
        log.info("Открылось под меню материнских плат");
    }

    public void clickModelMp() {
        log.info("Кликаем на модель материнской платы");
        WebElement clickMPModel = driver.findElement(By.xpath("//li[@class='container    open']//a[text()='Intel Socket 1200']"));
        clickMPModel.click();
        log.info("Открылись модели матернской платы");
    }

    public void addContainerFiveMp() {
        log.info("Добавляем 5 материнскую плату");
        WebElement clickAddBasket = driver.findElement(By.xpath("//div[@class='block']//a[@onclick='add_in_basket(355861)']"));
        clickAddBasket.click();
        log.info("Кладем в корзину 5 материнскую плату");
    }

    public void clickCorpusModel() {
        log.info("Кликаем на Корпуса");
        WebElement clickCorpus = driver.findElement(By.xpath("//a[text()='Корпуса']"));
        clickCorpus.click();
        log.info("Открывается под меню корпусов");
    }

    public void clickCorpusInModel() {

        log.info("Выбираем корпус AEROCOOL");
        WebElement modelAerocool = driver.findElement(By.xpath("//li[@class='container    open']//a[text()='AEROCOOL']"));
        modelAerocool.click();
        log.info("Кликаем по нему");
    }

    public void backStepMainPage() {
        log.info("Возращаемся обратно к материнским платам");
        driver.navigate();
        log.info("Вернули к материнским платам");
    }

    public void addContainerFourMp() {
        log.info("Добавили 4 материнскую плату в корзину");
        WebElement clickModelMP4 = driver.findElement(By.xpath("//a[@onclick='add_in_basket(357116)']"));
        clickModelMP4.click();
        log.info("Добавили 4 материнскую плату в корзину");


    }

    public void searchTenModelMP() {
        log.info("Находим 10 модель материнской платы и кликаем на нее");
        WebElement clickModelPM10 = driver.findElement(By.xpath("//div[@class='bcontent']//a[text()='ASRock B560M STEEL LEGEND']"));
        clickModelPM10.sendKeys(Keys.PAGE_DOWN);
        clickModelPM10.click();
        log.info("переходим на нее");
    }

    public void addContainerTenMP() {
        log.info("Добавляем в корзину");
        WebElement addContainerMP = driver.findElement(By.xpath("//a[text()='Добавить в корзину']"));
        addContainerMP.click();
        log.info("Добавли в корзину");
    }

    public void stepContainer() {
        log.info("Переходим в корзину");
        WebElement nextContainer = driver.findElement(By.xpath("//a[@id='add_cart']"));
        nextContainer.click();
        log.info("Перешли в корзину");
    }


}
