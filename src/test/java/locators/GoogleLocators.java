package locators;
import org.openqa.selenium.By;


public class GoogleLocators {
    public static final By SEARCH_INPUT = By.xpath("//*[@name='q']");
    public static final By SEARCH_BUTTON = By.xpath("//*[@aria-label='Поиск в Google']");
    public static final By SIGN_IN_BUTTON = By.xpath("//*[@id='gb']/div/div[2]/a");
    public static final By EMAIL_INPUT = By.xpath("//*[@id='identifierId']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@name='Passwd']");
    public static final By NEXT_BUTTON = By.xpath("//*[@id='identifierNext']");
    public static final By PASSWORD_NEXT_BUTTON = By.xpath("//*[@id='passwordNext']");
    public static final By ERROR_MESSAGE_EMAIL = By.xpath("//*[@class='o6cuMc Jj6Lae']");
    public static final By ERROR_MESSAGE_PASSWORD = By.xpath("//*[@class='OyEIQ uSvLId']");
    public static final By SEARCH_RESULTS = By.xpath("//*[@id='topstuff']//p[1]");
    public static final By USER_PROFILE = By.xpath("//*[@id='gb']//img");
}
