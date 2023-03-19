package pages;

import io.qameta.allure.Step;
import locators.GoogleLocators;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.GoogleLocators;

import java.time.Duration;
import java.util.List;

import static locators.GoogleLocators.*;
import static locators.GoogleLocators.USER_PROFILE;


public class GoogleHomePage extends BasePage {

    @FindBy(xpath = "//*[@id='search']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//ul[@role='listbox']")
    private WebElement autoCompleteSuggestionsList;


    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод поискового запроса '{0}'")
    public void enterSearchTerm(String searchTerm) {
        driver.findElement(GoogleLocators.SEARCH_INPUT).sendKeys(searchTerm);
    }

    @Step("Нажатие кнопки 'Поиск в Google'")
    public void pressEnterButton() {
        WebElement searchButton = findElementWait(SEARCH_INPUT);
        if (searchButton != null) {
            searchButton.sendKeys(Keys.ENTER);
        }
    }

    @Step("Нажатие кнопки 'Войти'")
    public void clickSignInButton() {
        WebElement signInButton = findElementWait(SIGN_IN_BUTTON);
        if (signInButton != null) {
            signInButton.click();
        }
    }



    public boolean areAutoCompleteSuggestionsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(autoCompleteSuggestionsList));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean areSearchResultsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
            return !searchResults.isEmpty();
        } catch (TimeoutException e) {
            return false;
        }
    }


}
