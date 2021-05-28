import PageObject.ContainerPage;
import PageObject.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.WebDriverWrapper;


public class TestBuy {
    static WebDriverWrapper driver;
    static MainPage mainPage;
    static ContainerPage containerPage;

    @BeforeAll
    static void setUp() {
        driver = WebDriverWrapper.getInstance();
        mainPage = new MainPage();
        containerPage = new ContainerPage();
    }

    @Test
    @DisplayName("PageObject")
    void testPO() {
        mainPage.open();
        mainPage.searchM();
        mainPage.clickModelMp();
        mainPage.addContainerFiveMp();
        mainPage.clickCorpusModel();
        mainPage.clickCorpusInModel();
        mainPage.backStepMainPage();
        mainPage.addContainerFourMp();
        mainPage.searchTenModelMP();
        mainPage.addContainerTenMP();
        mainPage.stepContainer();

        containerPage.open();
        containerPage.equalsBuyMP();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }


}
