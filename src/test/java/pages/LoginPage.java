package pages;
import baseEntities.BasePageFactory;
import core.BrowsersService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageFactory {

    @FindBy(id = "name")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "button_primary")
    public WebElement buttonPrimary;

    @FindBy(className = "error-text")
    public WebElement errorLabel;
    // Описание селекторов

    // Инициализация класса
    public LoginPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(baseUrl);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return buttonPrimary.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

}
