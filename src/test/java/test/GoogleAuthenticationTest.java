package test;


import data.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleAuthenticationPage;
import pages.GoogleHomePage;

@Epic("Тестирование аутентификации")
@Feature("Аутентификация")
public class GoogleAuthenticationTest extends BaseTest {

    @Test(description = "Успешный вход в аккаунт Google")
    @Description("Проверка успешного входа в аккаунт Google с использованием валидных данных")
    public void successfulSignIn() {
        GoogleHomePage GooogleHomePage = new GoogleHomePage(driver);
        GooogleHomePage.clickSignInButton();

        GoogleAuthenticationPage authenticationPage = new GoogleAuthenticationPage(driver);
        authenticationPage.enterEmail(TestData.VALID_EMAIL);
        authenticationPage.clickNextButton();
        authenticationPage.enterPassword(TestData.VALID_PASSWORD);
        authenticationPage.clickPasswordNextButton();

        Assert.assertTrue(authenticationPage.isUserProfileDisplayed(), "Аватарка пользователя не отображается");
    }

    @Test(description = "Вход в аккаунт Google с некорректным адресом электронной почты")
    @Description("Проверка сообщения об ошибке при входе с некорректным адресом электронной почты")
    public void signInWithIncorrectEmail() {
        GoogleHomePage GooogleHomePage = new GoogleHomePage(driver);
        GooogleHomePage.clickSignInButton();

        GoogleAuthenticationPage authenticationPage = new GoogleAuthenticationPage(driver);
        authenticationPage.enterEmail(TestData.INVALID_EMAIL);
        authenticationPage.clickNextButton();

        String errorMessage = authenticationPage.getErrorMessageEmail();
        Assert.assertTrue(errorMessage.contains("Не удалось найти аккаунт Google."), "Неверное сообщение об ошибке");
    }

    @Test(description = "Вход в аккаунт Google с некорректным паролем")
    @Description("Проверка сообщения об ошибке при входе с некорректным паролем")
    public void signInWithIncorrectPassword() {
        GoogleHomePage GooogleHomePage = new GoogleHomePage(driver);
        GooogleHomePage.clickSignInButton();

        GoogleAuthenticationPage authenticationPage = new GoogleAuthenticationPage(driver);
        authenticationPage.enterEmail(TestData.VALID_EMAIL);
        authenticationPage.clickNextButton();
        authenticationPage.enterPassword(TestData.INVALID_PASSWORD);
        authenticationPage.clickPasswordNextButton();

        String errorMessage = authenticationPage.getErrorMessagePassword();
        Assert.assertTrue(errorMessage.contains("Неверный пароль."),
                "Неверное сообщение об ошибке");
    }
}
