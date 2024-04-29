package ru.yandex.praktikum.plain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.WebDriverFactory;
import ru.yandex.praktikum.page.InfoRentPage;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderInfoPage;
import ru.yandex.praktikum.page.SuccessfulRentPage;

import static org.junit.Assert.assertTrue;

public class CreateOrderTest {
    private WebDriver webDriver;
    private static final String BROWSER = "CHROME";
    private static final String url = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver (BROWSER);
        webDriver.get (url);
    }

    @Test
    public void orderScooterForTverskayaStation() {

        MainPage mainPage = new MainPage (webDriver);
        mainPage.clickOrderButton ();

        OrderInfoPage orderInfoPage = new OrderInfoPage (webDriver);

        orderInfoPage.enterOrderName ("Игорь");
        orderInfoPage.enterOrderSurname ("Кукушкин");
        orderInfoPage.enterOrderAdress ("Москва, Красная площадь, 1");
        orderInfoPage.selectUndegroundTverskaya ("Тверская");
        orderInfoPage.enterOrderPhone ("+79000000007");

        orderInfoPage.clickNextButton ();

        InfoRentPage infoRentPage = new InfoRentPage (webDriver);

        infoRentPage.enterDeliveryDate ("01.06.2024");
        infoRentPage.selectPeriodDay ("сутки");

        infoRentPage.clickOrderButton ();
        infoRentPage.clickYesButton ();

        SuccessfulRentPage successfulRentPage = new SuccessfulRentPage (webDriver);
        assertTrue(successfulRentPage.successfulIsDisplayed());
    }

    @After
    public void tearDown() {
        webDriver.quit ();
    }
}