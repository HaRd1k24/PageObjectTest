package PageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContainerPage extends AbstractPageObject {
    private static final String url = "https://www.regard.ru/basket/";

    public ContainerPage() {
        super(url);
    }


    @Override
    public void open() {
        driver.get(url);
    }


    public void equalsBuyMP() {
        log.info("Находим названия Материнской платы");
        WebElement foPM = driver.findElement(By.xpath("//a[text()='ASRock B460M Steel Legend']"));

        WebElement fivePM = driver.findElement(By.xpath("//a[text()='ASRock B460M-HDV']"));

        WebElement tenPM = driver.findElement(By.xpath("//a[text()='ASRock B560M STEEL LEGEND']"));

        log.info("Сравниваем названия материнских плат");
        Assertions.assertEquals(foPM.getText(), "ASRock B460M Steel Legend");
        Assertions.assertEquals(fivePM.getText(), "ASRock B460M-HDV");
        Assertions.assertEquals(tenPM.getText(), "ASRock B560M STEEL LEGEND");
        log.info("Сравнились названия материнских плат");
    }
}
