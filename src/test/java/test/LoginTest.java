package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.BrowsePage;
import pages.LoginPage;
import pages.MainPage;
import pages.UserProfilePage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void testPuzzles() {
        LoginPage loginPageChrome = homePageChrome.clickLoginButton();
        loginPageChrome.setUsername("auatesting");
        loginPageChrome.setPassword("aua.testing.sunset123!!!");
        MainPage mainPageChrome = loginPageChrome.clickBtn();
        assertEquals(mainPageChrome.getUsername(), "AUAtesting");
        BrowsePage browsePageChrome = mainPageChrome.goToBrowsePage();
        browsePageChrome.findPuzzleCategory();

        LoginPage loginPageFirefox = homePageFirefox.clickLoginButton();
        loginPageFirefox.setUsername("auatesting");
        loginPageFirefox.setPassword("aua.testing.sunset123!!!");
        MainPage mainPageFirefox = loginPageFirefox.clickBtn();
        assertEquals(mainPageFirefox.getUsername(), "AUAtesting");
        BrowsePage browsePageFirefox = mainPageFirefox.goToBrowsePage();
        browsePageFirefox.findPuzzleCategory();
    }
}