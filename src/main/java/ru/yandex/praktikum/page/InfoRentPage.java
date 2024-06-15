package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InfoRentPage extends BasePage {

    // Локатор поля "Когда привезти самокат"
    private final By enterDeliveryDateLocator = (By.xpath ("//input[@placeholder='* Когда привезти самокат']"));

    // Локатор поля "Срок аренды"
    private final By enterPeriodLocator = (By.xpath ("//div[text()='* Срок аренды']"));

    // Локатор пунка меню "Срок аренды" и значения "сутки"
    private final By enterDayPeriodMenuLocator = (By.xpath ("//div[text()='сутки']"));

    // Локатор пунка меню "Срок аренды" и значения "семеро суток"
    private final By enterPeriodMenuLocator = (By.xpath ("//div[text()='семеро суток']"));

    // Локатор пункта "Комментарий для курьера"
    private final By enterCommentLocator = (By.xpath ("//input[@placeholder='Комментарий для курьера']"));

    // Локатор кнопки "Заказать"
    private final By clickOrderButtonLocator = (By.xpath ("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']"));

    // Локатор кнопки "Да" в окне подтверждения заказа
    private final By yesButtonLocator = (By.xpath ("//button[text()='Да']"));

    public InfoRentPage(WebDriver webDriver) {
        super (webDriver);
    }

    // Ввод даты доставки и нажатие на кнопку [Enter]
    public void enterDeliveryDate(String date) {
        WebElement dateInput = webDriver.findElement (enterDeliveryDateLocator);
        dateInput.sendKeys (date, Keys.ENTER);
    }

    // Выбор периода "сутки"
    public void selectPeriodDay (String period) {
        WebElement orderPeriod = webDriver.findElement (enterPeriodLocator);
        orderPeriod.click ();

        WebElement rentPeriodMenuItem = webDriver.findElement (enterDayPeriodMenuLocator);
        rentPeriodMenuItem.click ();
    }

    // Выбор периода "семеро суток"
    public void selectPeriodSevenDay (String period) {
        WebElement orderPeriod = webDriver.findElement (enterPeriodLocator);
        orderPeriod.click ();

        WebElement rentPeriodMenuItem = webDriver.findElement (enterPeriodMenuLocator);
        rentPeriodMenuItem.click ();
    }

    // Поиск и ввод комментария
    public void enterComment (String comment) {
        WebElement orderAdress = webDriver.findElement (enterCommentLocator);
        orderAdress.sendKeys (comment);
    }

    // Поиск и нажатие кнопки [Заказать] на странице "Про аренду"
    public void clickOrderButton() {
        WebElement orderButton = webDriver.findElement (clickOrderButtonLocator);
        orderButton.click ();
    }

    //Поиск и нажати кнопки [Да] в окне подтверждения заказа
    public void clickYesButton() {
        WebElement yesButton = webDriver.findElement (yesButtonLocator);
        yesButton.click();
 }
}