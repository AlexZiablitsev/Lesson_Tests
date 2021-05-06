package tests;

import baseEntities.BaseTest;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import steps.LoginSteps;
import steps.ProjectSteps;

public class SmokeTest2 extends BaseTest {

    @Test
    public void LoginTest() {
/*
        1. Запустить драйвер
        2. Перейти на сайт
        3. Ввести логин
        4. Ввести пароль
        5. Нажать Login
        6. Dashboard page отобразился
*/
        LoginSteps loginSteps = new LoginSteps(browsersService);
        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");

        Assert.assertEquals(browsersService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test
    public void LoginTestWithIncorrectCredentials() {
/*
        1. Запустить драйвер
        2. Перейти на сайт
        3. Ввести логин
        4. Ввести пароль
        5. Нажать Login
        6. Dashboard page отобразился
*/
        LoginSteps loginSteps = new LoginSteps(browsersService);
        LoginPage loginPage = loginSteps.loginWithIncorrectCredentials("test@gmail.com", "qweqwe");

        Assert.assertEquals(loginPage.getErrorText(),
                "Email/Login or Password is incorrect. Please try again.");
    }

//    @Test
//    public void AddProjectTest() {
//
//        Project project1 = new Project();
//        project1.setName("AZjablicev_01");
//        project1.setAnnouncement("project1");
//        project1.setShowAnnouncement(false);
//
//
//        LoginSteps loginSteps = new LoginSteps(browsersService);
//        loginSteps.loginWithCorrectCredentials("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
//
//        ProjectSteps projectsSteps = new ProjectSteps(browsersService);
//        projectsSteps.addProject(project1);
//
//        Assert.assertTrue(projectsSteps.getMessageSuccessAdd().isDisplayed());
//    }
}
