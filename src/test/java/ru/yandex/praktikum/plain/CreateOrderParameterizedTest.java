package ru.yandex.praktikum.plain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.WebDriverFactory;
import ru.yandex.praktikum.page.InfoRentPage;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderInfoPage;

@RunWith(Parameterized.class)

    public class CreateOrderParameterizedTest {
        private WebDriver webDriver;
        private static final String BROWSER = "FIREFOX";
        private static final String url = "https://qa-scooter.praktikum-services.ru/";
        private static String bottomOrderButton;
        private final String name;
        private final String surname;
        private final String address;
        private final String undegroundTitle;
        private final String phone;
        private final String date;
        private final String period;
        private final String comment;

        public CreateOrderParameterizedTest (String bottomOrderButton, String name, String surname, String address, String undegroundTitle, String phone, String date, String period, String comment) {

            this.bottomOrderButton = bottomOrderButton;
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.undegroundTitle = undegroundTitle;
            this.phone = phone;
            this.date = date;
            this.period = period;
            this.comment = comment;
        }

        @Parameterized.Parameters
        public static Object[][] data() {
            return new Object[][]{
                    {bottomOrderButton, "Чендлер", "Бинг", "Льва Толстого, 1", "Парк культуры", "89004566677", "29.04.2024", "сутки", "Хочу кататься"},
                    {bottomOrderButton, "Моника", "Геллер", "Льва Толстого, 100", "Парк культуры", "89001112112", "01.05.2024", "семеро суток", "Не позднее 12.00"},
            };
        }

        @Before
        public void setup() {
            webDriver = WebDriverFactory.getWebDriver (BROWSER);
            webDriver.get (url);
        }

        @Test
        public void orderScooterForParkKulturiyStation () {
            MainPage mainPage = new MainPage (webDriver);
            mainPage.clickBottomOrderButton ();

            OrderInfoPage orderInfoPage = new OrderInfoPage (webDriver);

            orderInfoPage.enterOrderName (name);
            orderInfoPage.enterOrderSurname (surname);
            orderInfoPage.enterOrderAdress (address);
            orderInfoPage.selectUndegroundParkKulturiy (undegroundTitle);
            orderInfoPage.enterOrderPhone (phone);

            orderInfoPage.clickNextButton ();

            InfoRentPage infoRentPage = new InfoRentPage (webDriver);

            infoRentPage.enterDeliveryDate (date);
            infoRentPage.selectPeriodSevenDay (period);
            infoRentPage.enterComment (comment);

            infoRentPage.clickOrderButton ();
            infoRentPage.clickYesButton ();

            infoRentPage.searchSuccessfulText ();
        }

        @After
        public void tearDown() {
            webDriver.quit ();
        }
    }

