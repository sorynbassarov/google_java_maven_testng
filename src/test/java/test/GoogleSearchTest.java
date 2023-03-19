package test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import data.TestData;


@Epic("Тестирование функции поиска")
@Feature("Поиск")
public class GoogleSearchTest extends BaseTest {

    @Test(description = "Проверка поиска в Google")
    @Description("Проверка, что результаты поиска отображаются после ввода запроса")
    public void searchInGoogle() {
        GoogleHomePage GooogleHomePage = new GoogleHomePage(driver);
        GooogleHomePage.enterSearchTerm(TestData.SEARCH_TERM);
        GooogleHomePage.pressEnterButton();
        Assert.assertTrue(GooogleHomePage.areSearchResultsDisplayed(), "Результаты поиска не отображаются");

    }

    @Test(description = "Проверка некорректного поиска в Google")
    @Description("Проверка, что результаты поиска не отображаются после ввода некорректного запроса")
    public void incorrectSearchInGoogle() {
        GoogleHomePage GooogleHomePage = new GoogleHomePage(driver);
        GooogleHomePage.enterSearchTerm(TestData.INCORRECT_SEARCH_TERM);
        GooogleHomePage.pressEnterButton();

        Assert.assertFalse(GoooglehomePage.areSearchResultsDisplayed(), "Результаты поиска не отображаются");
    }

    @Test(description = "Проверка автодополнения при вводе поискового запроса")
    @Description("Проверка, что автодополнение отображается при вводе поискового запроса")
    public void autoCompleteSuggestions() {
        GoogleHomePage GooogleHomePage = new GoogleHomePage(driver);
        GooogleHomePage.enterSearchTerm(TestData.PARTIAL_SEARCH_TERM);

        Assert.assertTrue(GooogleHomePage.areAutoCompleteSuggestionsDisplayed(), "Предложения автодополнения не отображаются");
    }
}
