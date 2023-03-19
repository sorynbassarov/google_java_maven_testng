package pages;

import io.qameta.allure.Step;
import locators.GoogleLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static locators.GoogleLocators.*;

public class GoogleAuthenticationPage extends BasePage {

    public GoogleAuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод адреса электронной почты '{0}'")
    public void enterEmail(String email) {
        WebElement emailInput = findElementWait(EMAIL_INPUT);
        if (emailInput != null) {
            emailInput.sendKeys(email);
        }
    }

    @Step("Ввод пароля '{0}'")
    public void enterPassword(String password) {
        WebElement emailInput = findElementWait(PASSWORD_INPUT);
        if (emailInput != null) {
            emailInput.sendKeys(password);
        }
    }
    @Step("Нажатие кнопки 'Далее'")
    public void clickNextButton() {
        WebElement nextButton = findElementWait(NEXT_BUTTON);
        if (nextButton != null) {
            nextButton.click();
        }
    }

    @Step("Нажатие кнопки 'Далее' после ввода пароля")
    public void clickPasswordNextButton() {
        WebElement nextButton = findElementWait(PASSWORD_NEXT_BUTTON);
        if (nextButton != null) {
            nextButton.click();
        }
    }

    @Step("Получение сообщения об ошибке")
    public String getErrorMessageEmail() {
        WebElement errorMessage = findElementWait(ERROR_MESSAGE_EMAIL);
        return errorMessage.getText();

    }

    @Step("Получение сообщения об ошибке")
    public String getErrorMessagePassword() {
        WebElement errorMessage = findElementWait(ERROR_MESSAGE_PASSWORD);
        return errorMessage.getText();

    }
    @Step("Проверка наличия аватарки пользователя")
    public boolean isUserProfileDisplayed() {
        WebElement userDisplayed = findElementWait(USER_PROFILE);
        return userDisplayed.isDisplayed();
    }
}
