package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulRentPage extends BasePage {

    // Локатор окна с текстом "Заказ оформлен"
    private final By successfulWindowLocator = (By.xpath("//div[text()='Заказ оформлен']"));

    public SuccessfulRentPage (WebDriver webDriver) {
        super (webDriver);
    }

    // Если есть поле с текстом "Заказ оформлен", то true
    public boolean successfulIsDisplayed () {
        return webDriver.findElement(successfulWindowLocator).isDisplayed();
    }
}
