package org.yandrut;

import org.testng.annotations.Test;
import selenium.DriverProvider;
import selenium.pages.TechExpertisePage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TechExpertiseTest extends BaseTest {

    @Test
    public void titleOfWebPageMatches() {
        TechExpertisePage page = new TechExpertisePage(DriverProvider.getInstance());
        page.openURL("https://www.code-seek.com/tech-expertise");
        String expected = "Tech expertise";
        String actual = page.getWebsiteTitle();

        assertEquals(expected, actual);
    }

    @Test
    public void allowsToSwitchTechnologiesElements() {
        TechExpertisePage page = new TechExpertisePage(DriverProvider.getInstance());
        page.openURL("https://www.code-seek.com/tech-expertise");
        page.clickThroughTabsList();
        boolean clicksThroughAllElements = page.clicksThroughAllElements();

        assertTrue(clicksThroughAllElements);
    }

    @Test
    public void clickingOnLogoRedirectsToHomePage() {
        TechExpertisePage page = new TechExpertisePage(DriverProvider.getInstance());
        page.clickOnLogoIcon();
        String expected = "Codeseek";
        String actual = page.getWebsiteTitle();

        assertEquals(expected, actual);
    }
}
