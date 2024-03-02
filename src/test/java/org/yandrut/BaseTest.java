package org.yandrut;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import selenium.DriverProvider;

public class BaseTest {
    @BeforeMethod
    public void openBrowser() {
        // Opens a new browser instance
        WebDriver driver = DriverProvider.getInstance();
        driver.get("https://code-seek.com");
    }

    @AfterMethod
    public void closeBrowser() {
        // Closes a browser instance
        DriverProvider.quit();
    }
}
