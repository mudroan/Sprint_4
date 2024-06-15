package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class MainPage extends BasePage {

    // Локатор кнопки [Заказать] на главное странице вверху экрана
    private final By createOrderButtonLocator = By.xpath ("//div[contains(@class, 'Header')]/button[text()='Заказать']");

    // Локатор кнопки [Заказать] на главное странице внизу экрана
    private final By createBottomOrderButtonLocator = By.xpath ("//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    // Локатор кнопки куки
    private final By cookiesButtonLocator = By.xpath ("//button[text()='да все привыкли']");

    // Локатор вопроса в разделе "Вопросы о важном"
    private final String questionLocator = "accordion__heading-%s";

    // Локатор ответа в разделе "Вопросы о важном"
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";

    public MainPage(WebDriver webDriver) {
        super (webDriver);
    }

   // Поиск и нажатие кнопки [Заказать] вверху страницы
   public void clickOrderButton() {
       WebElement orderButton = webDriver.findElement(createOrderButtonLocator);
       orderButton.click();
   }

    // Поиск и нажатие кнопки [Заказать] внизу страницы
    public void clickBottomOrderButton() {
        WebElement orderBottomButton = webDriver.findElement(createBottomOrderButtonLocator);
        ((JavascriptExecutor) webDriver).executeScript ("arguments[0].scrollIntoView();", orderBottomButton);

        new WebDriverWait (webDriver, ofSeconds (15)).until(ExpectedConditions.elementToBeClickable (orderBottomButton));
        orderBottomButton.click();
    }

    // Закрытие окна с куки
   public void closeCookieWindow() {
        webDriver.findElement(cookiesButtonLocator).click();
   }

    // Поиск и скролл до раздела "Вопросы о важном"
    public void expandQuestion(int index) {
        WebElement element = webDriver.findElement (By.id(String.format(questionLocator, index)));
        ((JavascriptExecutor) webDriver).executeScript ("arguments[0].scrollIntoView();", element);

        new WebDriverWait (webDriver, ofSeconds (15)).until(ExpectedConditions.elementToBeClickable (element));
        element.click ();
    }

    // Разворачивание ответов на вопросы в разделе "Вопросы о важном"
    public boolean answerIsDisplayed(String expectedAnswer) {
        WebElement element = webDriver.findElement(By.xpath (String.format(answerLocator, expectedAnswer)));
        return element.isDisplayed ();
    }
}