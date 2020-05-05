package base;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.ITestResult;

import event.EventReporter;
import pages.HomePage;

public class BaseTest {
    private EventFiringWebDriver chrome;
    private EventFiringWebDriver firefox;
    protected HomePage homePageChrome;
    protected HomePage homePageFirefox;
    public static String screenTitle;
    DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
    DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();

    @BeforeMethod
    public void setUp() {
        try {
            // System.setProperty("webdriver.chrome.driver", "chromedriver");
            chrome = new EventFiringWebDriver(
                    new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCapabilities));
            chrome.register(new EventReporter());
            chrome.get("https://www.twitch.tv");

            firefox = new EventFiringWebDriver(
                    new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxCapabilities));
            firefox.register(new EventReporter());
            firefox.get("https://www.twitch.tv");

            homePageChrome = new HomePage(chrome);
            homePageFirefox = new HomePage(firefox);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File scrFileChrome = chrome.getScreenshotAs(OutputType.FILE);
            File scrFileFirefox = firefox.getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir");
            try {
                FileUtils.copyFile(scrFileChrome, new File(path + "/" + result.getName() + "_chrome" + ".jpg"));
                FileUtils.copyFile(scrFileFirefox, new File(path + "/" + result.getName() + "_firefox" + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod(dependsOnMethods = "recordFailure")
    public void off() {
        chrome.quit();
        firefox.quit();
    }
}
