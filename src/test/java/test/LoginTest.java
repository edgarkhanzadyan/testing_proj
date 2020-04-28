package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.MainPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername("auatesting");
        loginPage.setPassword("aua.testing.sunset123!!!");
        MainPage mainPage = loginPage.clickBtn();
        assertEquals(mainPage.getUsername(), "auatesting");
    }

    @Test
    public void testFailLogin() {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername("auatesting");
        loginPage.setPassword("badpass");
        loginPage.clickBtn();

        assertEquals(loginPage.getIncorrectText(), "That password was incorrect. Please try again.");

    }
}