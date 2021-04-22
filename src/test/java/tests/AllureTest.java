package tests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import steps.LoginSteps;


public class AllureTest extends BaseTest {
    @Epics({@Epic("Main Epic"), @Epic("")})
    @Test(description = "Логин тест")
    @Feature("Feature 1")
    @Story("Story 1")
    @Description("Проверка с корректными данными.")
    @Flaky
    @TmsLink("629")
    @Issue("629")
    @Link(name = "Test Link", url = "https://thumbs.dreamstime.com/z/funny-cartoon-bug-vector-illustration-cute-beetle-50577038.jpg")
    @Severity(SeverityLevel.BLOCKER)
    public void LoginTest() {
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }


    @Epics({@Epic("Second epic"), @Epic("")})
    @Features({@Feature("Feature 1"),@Feature("Feature 2")})
    @Stories({@Story("Story 1"), @Story("Story 2")})
    @Test(description = "Тест c неправильными логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void LoginTestWithIncorrectCredentials() {

        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("test@gmail.com", "qweqwe");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.errorLabel.getText(),
                "Email/Login or Password is incorrect. Please try again.1");
        softAssert.assertEquals(loginPage.errorLabel.getText(),
                "Email/Login or Password is incorrect. Please try again.2");
        softAssert.assertAll();
    }
}
