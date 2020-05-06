package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.MainPage;
import pages.UserProfilePage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPageChrome = homePageChrome.clickLoginButton();
        loginPageChrome.setUsername("auatesting");
        loginPageChrome.setPassword("aua.testing.sunset123!!!");
        MainPage mainPageChrome = loginPageChrome.clickBtn();
        assertEquals(mainPageChrome.getUsername(), "AUAtesting");
        UserProfilePage userProfilePageChrome = mainPageChrome.goToUserProfilePage();
        assertEquals(userProfilePageChrome.getDisplayName(), "AUAtesting");
        assertEquals(userProfilePageChrome.getEmail(), "akshdfjkahsdfkjh@fgdsjkhfs.df");
        
        LoginPage loginPageFirefox = homePageFirefox.clickLoginButton();
        loginPageFirefox.setUsername("auatesting");
        loginPageFirefox.setPassword("aua.testing.sunset123!!!");
        MainPage mainPageFirefox = loginPageFirefox.clickBtn();
        assertEquals(mainPageFirefox.getUsername(), "AUAtesting");
        UserProfilePage userProfilePageFirefox = mainPageFirefox.goToUserProfilePage();
        assertEquals(userProfilePageFirefox.getDisplayName(), "AUAtesting");
        assertEquals(userProfilePageFirefox.getEmail(), "akshdfjkahsdfkjh@fgdsjkhfs.df");
    }

    @Test
    public void testFailLogin() {
        LoginPage loginPageChrome = homePageChrome.clickLoginButton();
        loginPageChrome.setUsername("auatesting");
        loginPageChrome.setPassword("badpass");
        loginPageChrome.clickBtn();
        assertEquals(loginPageChrome.getIncorrectText(), "That password was incorrect. Please try again.");
        
        LoginPage loginPageFirefox = homePageFirefox.clickLoginButton();
        loginPageFirefox.setUsername("auatesting");
        loginPageFirefox.setPassword("badpass");
        loginPageFirefox.clickBtn();
        assertEquals(loginPageFirefox.getIncorrectText(), "That password was incorrect. Please try again.");

    }
}