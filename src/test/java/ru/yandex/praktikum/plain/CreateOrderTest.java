package ru.yandex.praktikum.plain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.WebDriverFactory;
import ru.yandex.praktikum.page.InfoRentPage;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderInfoPage;


public class CreateOrderTest {
    private WebDriver webDriver;

    @Before
    public void setup () {
        webDriver = WebDriverFactory.getWebDriver (System.getProperty ("browser", "chrome"));
        webDriver.get ("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void orderScooterTest1 () {
        MainPage mainPage = new MainPage (webDriver);
        mainPage.clickOrderButton ();

        OrderInfoPage orderInfoPage = new OrderInfoPage (webDriver);

        orderInfoPage.enterOrderName("Игорь");
        orderInfoPage.enterOrderSurname("Кукушкин");
        orderInfoPage.enterOrderAdress("Москва, Красная площадь, 1");
        orderInfoPage.selectUndegroundTverskaya("Тверская");
        orderInfoPage.enterOrderPhone("+79000000007");

        orderInfoPage.clickNextButton();

        InfoRentPage infoRentPage = new InfoRentPage (webDriver);

        infoRentPage.enterDeliveryDate("01.06.2024");
        infoRentPage.selectPeriodDay ("сутки");

        infoRentPage.clickOrderButton();
        infoRentPage.clickYesButton ();

        infoRentPage.searchSuccessfulText ();
    }

    @Test
    public void orderScooterTest2 () {
        MainPage mainPage = new MainPage (webDriver);
        mainPage.clickBottomOrderButton ();

        OrderInfoPage orderInfoPage = new OrderInfoPage (webDriver);

        orderInfoPage.enterOrderName("Антон");
        orderInfoPage.enterOrderSurname("Мудров");
        orderInfoPage.enterOrderAdress("Москва, Льва-Толстого, 16");
        orderInfoPage.selectUndegroundParkKulturiy("Парк культуры");
        orderInfoPage.enterOrderPhone("+79040036801");

        orderInfoPage.clickNextButton();

        InfoRentPage infoRentPage = new InfoRentPage (webDriver);

        infoRentPage.enterDeliveryDate("01.05.2024");
        infoRentPage.selectPeriodSevenDay ("семеро суток");
        infoRentPage.enterComment ("Привезите, пожалуйста, быстрее!!!");

        infoRentPage.clickOrderButton();
        infoRentPage.clickYesButton ();

        infoRentPage.searchSuccessfulText ();
    }

    @After
        public void tearDown () {
        webDriver.quit();
    }
}