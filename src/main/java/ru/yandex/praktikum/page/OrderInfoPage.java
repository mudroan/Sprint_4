package ru.yandex.praktikum.page;

import org.openqa.selenium.*;

public class OrderInfoPage extends BasePage {

    // Локатор поля "Имя"
    private final By enterOrderNameLocator = (By.xpath ("//input[@placeholder='* Имя']"));

    // Локатор поля "Фамилия"
    private final By enterOrderSurnameLocator = (By.xpath ("//input[@placeholder='* Фамилия']"));

    // Локатор поля "Адрес"
    private final By enterOrderAdressLocator = (By.xpath ("//input[@placeholder='* Адрес: куда привезти заказ']"));

    // Локатор поля "Станция метро"
    private final By orderUndegroundLocator = (By.xpath ("//input[@placeholder='* Станция метро']"));

    // Локатор поля "Телефон"
    private final By enterOrderPhoneLocator = (By.xpath ("//input[@placeholder='* Телефон: на него позвонит курьер']"));

    // Локатор кнопки [Далее]
    private final By clickNextButtonLocator = (By.xpath ("//button[text()='Далее']"));

    public OrderInfoPage (WebDriver webDriver) {
        super (webDriver);
    }

    // Поиск и ввод имени
    public void enterOrderName(String name) {
        WebElement orderName = webDriver.findElement (enterOrderNameLocator);
        orderName.sendKeys (name);
    }

    // Поиск поля и ввод фамилии
    public void enterOrderSurname(String surname) {
        WebElement orderSurname = webDriver.findElement (enterOrderSurnameLocator);
        orderSurname.sendKeys (surname);
    }

    // Поиск поля и ввод адреса
    public void enterOrderAdress(String adress) {
        WebElement orderAdress = webDriver.findElement (enterOrderAdressLocator);
        orderAdress.sendKeys (adress);
    }

    // Поиск поля станции метро и выбор значения "Тверская"
     public void selectUndegroundTverskaya (String undegroundTitle) {
        WebElement orderUndeground = webDriver.findElement (orderUndegroundLocator);
        orderUndeground.click();

        WebElement tverskayaStationMenu = webDriver.findElement(By.xpath ("//button[@value='31'][./div[text()='Тверская']]"));
        ((JavascriptExecutor) webDriver).executeScript ("arguments[0].scrollIntoView();", tverskayaStationMenu);
        tverskayaStationMenu.click();
    }

    // Поиск поля станции метро и выбор значения "Парк культуры"
    public void selectUndegroundParkKulturiy (String undegroundTitle) {
        WebElement orderUndeground = webDriver.findElement (orderUndegroundLocator);
        orderUndeground.click();

        WebElement parkKulturiyStationMenu = webDriver.findElement(By.xpath ("//button[@value='13'][./div[text()='Парк культуры']]"));
        ((JavascriptExecutor) webDriver).executeScript ("arguments[0].scrollIntoView();", parkKulturiyStationMenu);
        parkKulturiyStationMenu.click();
    }

    // Поиск и ввод номера телефона
    public void enterOrderPhone(String phone) {
        WebElement searchField = webDriver.findElement (enterOrderPhoneLocator);
        searchField.sendKeys (phone);
    }

    // Поиск и нажатие кнопки [Далее] на странице "Для кого самокат"
    public void clickNextButton () {
        WebElement nextButton = webDriver.findElement (clickNextButtonLocator);
        nextButton.click();
    }
}

